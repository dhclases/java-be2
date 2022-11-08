package com.digitalhouse.demo;

import com.digitalhouse.demo.model.Cuenta;
import com.digitalhouse.demo.util.ConsultaSQL;
import com.digitalhouse.demo.util.H2Gestor;
import com.digitalhouse.demo.util.LogGestor;
import org.apache.log4j.Logger;

import java.sql.*;


public class Aplicacion {

    // Definir logger
    public static final Logger logger = Logger.getLogger(Aplicacion.class);

    public static void main(String[] args) throws SQLException {
        Cuenta cuenta = new Cuenta(12, "Sueldo", 10);
        try {
            // Inicializar logger
            LogGestor.inicializar();

            // Indicar inicio de proceso
            logger.info("*** Inicio Proceso ****");

            // Establcer conn
            Connection conn = H2Gestor.getConnection();

            // Crear tabla
            Statement statement = conn.createStatement();
            statement.execute(ConsultaSQL.SQL_CREATE_TABLE);

            // Insertar cuenta
            // * Definir SQL
            PreparedStatement psInsert = conn.prepareStatement(ConsultaSQL.SQL_INSERT_CUENTA);
            // * Definir Parametros
            psInsert.setInt(1, 1);
            psInsert.setString(2, cuenta.getNombre());
            psInsert.setInt(3, cuenta.getNroCuenta());
            psInsert.setDouble(4, cuenta.getSaldo());

            // * Executar SQL
            psInsert.execute();

            // listar Cuenta
            H2Gestor.imprimirRecordset(conn);

            // Update Cuenta
            PreparedStatement psUpdate1 = conn.prepareStatement(ConsultaSQL.SQL_UPDATE_CUENTA);
            // * Definir Parametros
            psUpdate1.setDouble(1, cuenta.getSaldo() + 10);
            psUpdate1.setInt(2, 1);
            // * Executar SQL
            psUpdate1.execute();

            // listar Cuenta
            H2Gestor.imprimirRecordset(conn);

            // Administar transaccion
            conn.setAutoCommit(false);

            // SQL
            PreparedStatement psUpdate2 = conn.prepareStatement(ConsultaSQL.SQL_UPDATE_CUENTA);
            psUpdate2.setDouble(1, cuenta.getSaldo() + 10);
            psUpdate2.setInt(2, 1);
            psUpdate2.execute();

            // Forzar error
            // int a = 4 /0;

            // Hacer commint
            conn.commit();

            // Listar
            H2Gestor.imprimirRecordset(conn);

            // Administar transaccion automatica
            conn.setAutoCommit(true);

            // Listar cuenta
            H2Gestor.imprimirRecordset(conn);


        } catch (Exception e) {
            // Loggear error
            logger.error(e.getMessage());
            // e.printStackTrace();
        }

        // Indicar inicio de proceso
        logger.info("*** Fin de  Proceso ****");
    }

}

//TODO: Definir Modelo
//TODO: Inicializar log
//TODO: Indicar si la conexion esta abierta
//TODO: Indicar Inicio y fin de proceso

