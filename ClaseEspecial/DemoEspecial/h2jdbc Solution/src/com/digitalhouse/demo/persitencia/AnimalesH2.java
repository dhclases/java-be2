package com.digitalhouse.demo.persitencia;

import java.sql.*;

public class    AnimalesH2 {
    public static void listarAnimales(Connection connection) {
        String sql = "SELECT * FROM ANIMALES";
        try {
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("id=" + rs.getInt("ID") + " Nombre=" + rs.getString("NOMBRE") + " Tipo=" + rs.getString("TIPO"));
            }
            rs.close();
            sqlSmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void eliminarAnimalPorId(Connection conn, int id) {
        String sql = "DELETE FROM ANIMALES WHERE ID=?";

        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);
            prepareStatement.setInt(1, id);

            if (prepareStatement.execute()) {
                System.out.println("Registro eliminado");
            }
            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
