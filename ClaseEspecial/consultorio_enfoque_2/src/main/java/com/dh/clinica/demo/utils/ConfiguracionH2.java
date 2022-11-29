package com.dh.clinica.demo.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase con responsabilidad de conectarse a la Base de Datos
 */
@Component
public class ConfiguracionH2 {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

    private Connection conexion;
    private static final Logger logger = Logger.getLogger(ConfiguracionH2.class);

    public void createTableSql(String sql){
        try {
            logger.debug("Obteniendo conexión para ejecutar sql = "+sql);
            Connection connection = this.obtenerConexionConBD();
            Statement statement= connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection obtenerConexionConBD() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                logger.info("Creando conexión H2");
                conexion = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                logger.error("Error al conectarse a la base de datos: " + e.getMessage());
                throw e;
            }
        }
        return conexion;
    }

    public void executeSQL(String sql){
        try {
            logger.debug("Obteniendo conexión para ejecutar sql = "+sql);
            Statement statement= this.obtenerConexionConBD().createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este método cierra la conexión en caso de que se encuentre abierta
     * @throws SQLException error al cerrar conexión
     */
    public void cerrarConexion() throws SQLException {
        if(conexion != null && !conexion.isClosed()){
            logger.info("Cerrando conexión BD");
            conexion.close();
            conexion = null;
        }
    }

}