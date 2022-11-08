package com.digitalhouse.demo.util;

import java.sql.*;

public class H2Gestor {

    public static final String H2_URL = "jdbc:h2:~/test";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(H2_URL);
    }

    public static void imprimirRecordset(Connection connection) throws SQLException {
        String sql = "SELECT * FROM CUENTA";
        Statement sqlSmt = connection.createStatement();
        System.out.printf("%s %s %s %n","*".repeat(3), " Listado de Cuenta " ,"*".repeat(3));
        ResultSet rs = sqlSmt.executeQuery(sql);
        while (rs.next()) {
            System.out.printf("ID = %d ", rs.getInt("ID") );
            System.out.printf(" Cuenta = %s",  rs.getString("NRO_CUENTA"));
            System.out.printf(" Nombre = %s ",  rs.getString("NOMBRE"));
            System.out.printf(" Saldo = %9.3f %n", rs.getFloat("SALDO"));
        }
        System.out.println("*".repeat(60));

    }

}
