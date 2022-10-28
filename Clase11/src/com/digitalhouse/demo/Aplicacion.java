package com.digitalhouse.demo;

import com.digitalhouse.demo.persitencia.AnimalesH2;
import com.digitalhouse.demo.util.ConsultaSQL;
import com.digitalhouse.demo.util.H2Gestor;

import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacion {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = H2Gestor.getConnection();

            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_CREATE_TABLE);

            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL1);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL2);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL3);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL4);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL5);

            AnimalesH2.listarAnimales(conn);

            AnimalesH2.eliminarAnimalPorId(conn, 1);

            AnimalesH2.listarAnimales(conn);

            if(!conn.isClosed()){
                System.out.println("Connection is open !!!");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}
// TODO: Abrir conexion
//TODO: Definir las consultas
//TODO: Ejecutar consulta de Crear Tabla
//TODO: Ejecutar consulta de insertar animales
//TODO: Cerrar la conexion
