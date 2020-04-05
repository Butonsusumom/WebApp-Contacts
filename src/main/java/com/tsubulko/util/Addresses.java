package com.tsubulko.util;

import com.tsubulko.entity.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Addresses extends Table<Address> {

    public Addresses(ConnectorDB connector) {
        super(connector);
    }

    @Override
    public void insert(Address obj) throws SQLException {
        String query = Factory.getInsert(getName(), 1, getColumnNames());
        PreparedStatement prepStmt = connection.prepareStatement(query);
        prepStmt.setInt(1,  obj.getContactId());
        prepStmt.setString(2, obj.getCountry());
        prepStmt.setString(3, obj.getCity());
        prepStmt.setString(4, obj.getStreet());
        prepStmt.setInt(5, obj.getHouse());
        prepStmt.setInt(6, obj.getZip());
        prepStmt.execute();
        prepStmt.close();
    }


    @Override
    protected List<Address> getAllFromResultSet(ResultSet res) throws SQLException {
        List<Address> list = new ArrayList<>();
        while (res.next()) {
            Address address = new Address();
            address.setContactId(res.getInt(1));
            address.setCountry(res.getString(2));
            address.setCity(res.getString(3));
            address.setStreet(res.getString(4));
            address.setHouse(res.getInt(5));
            address.setZip(res.getInt(6));
            list.add(address);
        }
        return list;
    }

    @Override
    public String getName() {
        return "ADDRESSES";
    }

    @Override
    public int getColumnsNumber() {
        return 6;
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "contact_id",
                "country",
                "city",
                "street",
                "house",
                "zip"
        };
    }
}