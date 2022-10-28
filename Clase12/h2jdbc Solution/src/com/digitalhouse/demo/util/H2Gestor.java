package com.digitalhouse.demo.util;

import java.sql.*;

public class H2Gestor {

    public static final String H2_URL = "jdbc:h2:test";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(H2_URL);
    }

    public static void executeSQL(Connection conn, String sql) {
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(Connection conn, String sql) {
        try {
            Statement sqlSmt = conn.createStatement();
            return sqlSmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
