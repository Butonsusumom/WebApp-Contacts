package com.tsubulko.util;

import com.tsubulko.entity.Phone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Phones extends Table<Phone> {
    public Phones(ConnectorDB connector) {
        super(connector);
    }

    @Override
    public void delete(String condition) throws SQLException {
        String query = Factory.getSelect(getName(), condition, "id",  "contact_id");
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        res.next();
        int ind = res.getInt(1);
        int contactId = res.getInt(2);
        res.close();
        stmt.close();
        super.delete(condition);

        condition = String.format("(ind > %d) AND (contact_id = %d)", ind, contactId);
        query = Factory.getSelect(getName(), condition, "id");
        stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        res = stmt.executeQuery(query);
        while (res.next()) {
            int curInd = res.getInt(1);
            res.updateInt(1, curInd - 1);
            res.updateRow();
        }
        res.close();
        stmt.close();
    }

    @Override
    public void insert(Phone phoneNumber) throws SQLException {
        String query = Factory.getInsert(
                getName(), 1, getColumnNames());
        PreparedStatement prepStmt = connection.prepareStatement(query);
        prepStmt.setInt(1, phoneNumber.getIdContact());
        prepStmt.setInt(2, phoneNumber.getIdContact());
        prepStmt.setString(3, phoneNumber.getCountryCode());
        prepStmt.setString(4, phoneNumber.getOperatorCode());
        prepStmt.setString(5, phoneNumber.getNumber());
        prepStmt.setString(6, Objects.toString(phoneNumber.getType(), null));
        prepStmt.setString(7, phoneNumber.getComment());
        prepStmt.execute();
        prepStmt.close();
    }

    @Override
    protected List<Phone> getAllFromResultSet(ResultSet res) throws SQLException {
        List<Phone> list = new ArrayList<>();
        while (res.next()) {
            Phone phoneNumber = new Phone();
            phoneNumber.setId(res.getInt(1));
            phoneNumber.setIdContact(res.getInt(2));
            phoneNumber.setCountryCode(res.getString(3));
            phoneNumber.setOperatorCode(res.getString(4));
            phoneNumber.setNumber(res.getString(5));
            Optional.ofNullable(res.getObject(6)).ifPresent((val) ->
                    phoneNumber.setType(Phone.PhoneType.valueOf((String)val)));
            Optional.ofNullable(res.getObject(7)).ifPresent((val) ->
                    phoneNumber.setComment((String)val));
            list.add(phoneNumber);
        }
        res.close();
        return list;
    }

    private int getNewIndex(int contactId) throws SQLException {
        String query = Factory.getSelect(getName(), "contact_id = " + contactId, "MAX(id)");
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        res.next();
        int index = res.getInt(1);
        res.close();
        stmt.close();
        return index + 1;
    }

    @Override
    public String getName() {
        return "PHONE_NUMBERS";
    }

    @Override
    public int getColumnsNumber() {
        return 7;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "id",
                "contact_id",
                "country_code",
                "operator_code",
                "number",
                "type",
                "comment"
        };
    }
}
