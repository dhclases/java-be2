package com.dh.demo.util;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class H2Gestor {

    public static final String H2_URL = "jdbc:h2:~/test2";

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private static final Logger logger = LogManager.getLogger(H2Gestor.class);


    public  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(H2_URL);
    }

    public  void executeSQL(Connection conn, String sql){
        try {
            Statement statement= conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public  ResultSet executeQuery(Connection conn, String sql){
        try {
            Statement statement= conn.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void executeUpdate(PreparedStatement ps){
        try {
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

    }

}
