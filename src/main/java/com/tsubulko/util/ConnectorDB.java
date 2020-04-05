package com.tsubulko.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB implements AutoCloseable {
    private java.sql.Connection connection;

    public ConnectorDB() throws SQLException {
        ResourceBundle res = ResourceBundle.getBundle("db");
        String url = res.getString("db.url");
        String options = res.getString("db.options");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasky?user=root1&password=Blumblum1@");
    }

    java.sql.Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
