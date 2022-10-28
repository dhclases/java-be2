package com.digitalhouse.demo;

import com.digitalhouse.demo.persitencia.AnimalesH2;
import com.digitalhouse.demo.util.ConsultaSQL;
import com.digitalhouse.demo.util.H2Gestor;

import java.sql.Connection;

public class Aplicacion {
    public static void main(String[] args) {
        try {
            Connection conn = H2Gestor.getConnection();

            if (!conn.isClosed()) {
                System.out.println("Connection is open !!");
            }

            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_CREATE_TABLE);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL1);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL2);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL3);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL4);
            H2Gestor.executeSQL(conn, ConsultaSQL.SQL_INSERT_ANIMAL5);

            AnimalesH2.listarAnimales(conn);

            AnimalesH2.eliminarAnimalPorId(conn, 1);

            AnimalesH2.listarAnimales(conn);

            if (!conn.isClosed()) {
                conn.isClosed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

//TODO: Definir las consultas
//TODO: Definir los metodos de ejecucion de SQL y Query
//TODO: Abrir Coneccion y Ejecutar SQL, recorres los recordset necesarios

