package com.tsubulko.util;

import com.tsubulko.entity.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Contacts extends Table<Contact> {


    public Contacts(ConnectorDB connector) {
        super(connector);
    }

    @Override
    public void clear() throws SQLException {
        String query = Factory.getSelectAll(getName());
        Statement stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            res.deleteRow();
        }
        res.close();
        stmt.close();
        String reseedQuery = Factory.getReseed(getName(), -1);
        stmt = connection.createStatement();
        stmt.execute(reseedQuery);
        stmt.close();
    }

    @Override
    public void insert(Contact contact) throws SQLException {
        String insertQuery =Factory.getInsert(
                getName(),
                1,
                Arrays.copyOfRange(getColumnNames(), 0, getColumnNames().length));
        PreparedStatement prepStmt = connection.prepareStatement(
                insertQuery,
                Statement.RETURN_GENERATED_KEYS);
        prepStmt.setLong(1, contact.getId());
        prepStmt.setString(2, contact.getName());
        prepStmt.setString(3, contact.getSurname());
        prepStmt.setString(4, contact.getPatronymic());
        prepStmt.setString(5, contact.getCurJob());
        prepStmt.setString(6, contact.getEmail());
        prepStmt.setString(7, contact.getCitizenship());
        prepStmt.setString(8, Objects.toString(contact.getSex(), null));
        prepStmt.setString(9, Objects.toString(contact.getMaritalStatus(), null));
        prepStmt.setString(10, Objects.toString(contact.getBirth(), null));
        prepStmt.setString(11, contact.getPhoto());
        prepStmt.execute();

        ResultSet res = prepStmt.getGeneratedKeys();
        res.next();
        contact.setId(res.getInt(1));
        res.close();
        prepStmt.close();
    }

    @Override
    protected List<Contact> getAllFromResultSet(ResultSet res) throws SQLException {
        List<Contact> list = new ArrayList<>();
        while (res.next()) {
            Contact contact = new Contact();
            contact.setId(res.getInt(1));
            contact.setName(res.getString(2));
            contact.setSurname(res.getString(3));
            contact.setPatronymic((String)res.getObject(4));
            contact.setCurJob((String)res.getObject(5));
            contact.setEmail((String)res.getObject(6));
            contact.setCitizenship((String)res.getObject(7));
            Optional.ofNullable(res.getObject(8)).ifPresent((val) ->
                    contact.setSex(Contact.Sex.valueOf((String)val)));
            Optional.ofNullable(res.getObject(9)).ifPresent((val) ->
                    contact.setMaritalStatus(Contact.Marital.valueOf((String)val)));
            contact.setBirth((String)res.getObject(10));
            contact.setPhoto((String)res.getObject(11));
            list.add(contact);
        }
        res.close();
        return list;
    }

    @Override
    public String getName() {
        return "CONTACTS";
    }

    @Override
    public int getColumnsNumber() {
        return 11;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "id",
                "name",
                "surname",
                "patronymic",
                "cur_job",
                "email",
                "citizenship",
                "sex",
                "marital_status",
                "birthday",
                "photo",
        };
    }
}
