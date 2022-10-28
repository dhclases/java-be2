package com.digitalhouse.demo.persitencia;

import java.sql.*;

public class AnimalesH2 {
    public static void listarAnimales(Connection connection) {
        String sql = "SELECT * FROM ANIMALES";


        try {
            Statement sqlStm = connection.createStatement();
            ResultSet rs = sqlStm.executeQuery(sql);
            while (rs.next()){
                System.out.println("id=" +rs.getInt("ID") + " Nombre " + rs.getString("NOMBRE") + " Tipo= " + rs.getString("TIPO"));
            }
            rs.close();
            sqlStm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void eliminarAnimalPorId(Connection conn, int id) {
        String sql = "DELETE FROM ANIMALES WHERE ID=?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            if (preparedStatement.execute()){
                System.out.println("Registro eliminado");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
