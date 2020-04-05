package com.tsubulko.util;

public class Factory {
    private Factory() {}

    public static String TRUE_CONDITION = "1 > 0";

    public static String getSelectAll(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String getSelect(String tableName, String condition, String... columns) {
        StringBuilder query = new StringBuilder("SELECT ");
        for (String column : columns) {
            query.append(column).append(',');
        }
        query.replace(query.length() - 1, query.length(), "");
        query.append(" FROM ").append(tableName)
                .append(" WHERE (").append(condition).append(")");
        return query.toString();
    }

    public static String getUpdate(String tableName, String condition, String... changes) {
        StringBuilder query = new StringBuilder();
        String template = "UPDATE " + tableName + " SET %s WHERE (" + condition + ") ";
        for (String change : changes) {
            query.append(String.format(template, "" + change + ""));
        }
        return getTrans(query.toString());
    }

    public static String getInsert(String tableName, int rowsNumber, String... columnNames) {
        StringBuilder query = new StringBuilder("INSERT INTO dbo." + tableName);
        query.append(" (");
        for (String columnName : columnNames) {
            query.append('[').append(columnName).append("],");
        }
        query.replace(query.length() - 1, query.length(), ")");
        query.append(" VALUES");
        for (int i = 0; i < rowsNumber; i++) {
            query.append(" (");
            query.append("?,".repeat(columnNames.length));
            query.replace(query.length() - 1, query.length(), ")");
        }
        return query.toString();
    }

    public static String getDelete(String tableName, String condition) {
        return "DELETE FROM " + tableName + " WHERE (" + condition + ")";
    }

    public static String getDeleteBulk(String tableName, String... conditions) {
        StringBuilder query = new StringBuilder();
        String template = "DELETE FROM " + tableName + " WHERE (%s) ";
        for (String condition : conditions) {
            query.append(String.format(template, condition));
        }
        return getTrans(query.toString());
    }

    public static String getClear(String tableName) {
        return "TRUNCATE TABLE " + tableName;
    }

    public static String getReseed(String tableName, int newSeed) {
        return String.format("DBCC CHECKIDENT('%s', RESEED, %d)", tableName, newSeed);
    }

    public static String getTrans(String query) {
        return "BEGIN TRAN " + query + " COMMIT TRAN";
    }
}
