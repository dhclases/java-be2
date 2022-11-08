package com.digitalhouse.demo.util;

public final class ConsultaSQL {
    public static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS CUENTA; CREATE TABLE CUENTA "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " NRO_CUENTA NUMERIC(10, 2) NOT NULL,"
            + " SALDO INT NOT NULL"
            + " )";

    public static final String SQL_INSERT_CUENTA = "INSERT INTO CUENTA (ID, NOMBRE, NRO_CUENTA, SALDO) VALUES (?,?,?,?)";
    public static final String SQL_UPDATE_CUENTA = "UPDATE CUENTA SET SALDO=? WHERE ID=?";
}

