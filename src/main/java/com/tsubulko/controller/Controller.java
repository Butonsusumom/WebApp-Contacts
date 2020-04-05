package com.tsubulko.controller;

import com.tsubulko.entity.Photo;
import com.tsubulko.util.ConnectorDB;

import java.sql.Connection;
import java.sql.SQLException;

/*public class Controller{
    private final static String SQL_GET_USERINFO_BY_ID = "select * from photo where idContact=1 ";
    private Connection connection;
    private Photo user;
    public Controller() throws SQLException {
        this.connection = ConnectorDB.getConnection();;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public UserInfo getUserInfobyId(final long id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_USERINFO_BY_ID);
            ps.setString(1, String.valueOf(id));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserInfo resultSetUser = new UserInfo();
                resultSetUser.setId(id);
                resultSetUser.setName(rs.getString(2));
                resultSetUser.setCity(rs.getString("city"));
                resultSetUser.setEmail(rs.getString("email"));
                resultSetUser.setPhone(rs.getString("phone"));
                return resultSetUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        try {
            Controller manager = new Controller();
            UserInfo finduser = manager.getUserInfobyId(1);
            System.out.println(finduser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/