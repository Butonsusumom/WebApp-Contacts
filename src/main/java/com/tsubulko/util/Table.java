package com.tsubulko.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class Table<T> {
    protected final Connection connection;

    public Table(ConnectorDB connector) {
        this.connection = connector.getConnection();
    }

    public void clear() throws SQLException {
        String query = Factory.getClear(getName());
        connection.createStatement().execute(query);
    }

    public void delete(String condition) throws SQLException {
        String query = Factory.getDelete(getName(), condition);
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        stmt.close();
    }

    public void edit(String condition, String... changes) throws SQLException {
        String query = Factory.getUpdate(getName(), condition, changes);
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        stmt.close();
    }

    public List<T> find(String condition) throws SQLException {
        String query = Factory.getSelect(getName(), condition, getColumnNames());
        ResultSet res = connection.createStatement().executeQuery(query);
        return getAllFromResultSet(res);
    }

    public List<T> getAll() throws SQLException {
        String query = Factory.getSelectAll(getName());
        ResultSet res = connection.createStatement().executeQuery(query);
        return getAllFromResultSet(res);
    }

    public abstract void insert(T obj) throws SQLException;

    protected abstract List<T> getAllFromResultSet(ResultSet res) throws SQLException;

    public abstract String getName();

    public abstract int getColumnsNumber();

    public abstract String[] getColumnNames();
}
