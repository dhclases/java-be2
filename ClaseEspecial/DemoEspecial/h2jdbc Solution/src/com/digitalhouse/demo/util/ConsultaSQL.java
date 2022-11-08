package com.digitalhouse.demo.util;

public final class ConsultaSQL {

    /* Forma i
    public static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " TIPO varchar(100) NOT NULL "
            + " )";
    */

    // El uso de """ esta solo para Java 15, 14, 13
    public static final String SQL_CREATE_TABLE = """
            DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES
             (  ID INT PRIMARY KEY,
                NOMBRE varchar(100) NOT NULL,
                TIPO varchar(100) NOT NULL )
            """;
    public static final String SQL_INSERT_ANIMAL1 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (1, 'Pancho', 'Perro')";
    public static final String SQL_INSERT_ANIMAL2 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (2, 'Pillo', 'Gato')";
    public static final String SQL_INSERT_ANIMAL3 = "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (3, 'Cepillo', 'Elefante')";

    public static final String SQL_INSERT_ANIMAL4 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (4, 'Pepe', 'Perro')";

    public static final String SQL_INSERT_ANIMAL5 =  "INSERT INTO ANIMALES (ID, NOMBRE, TIPO) VALUES (5, 'Rolo', 'Caballo')";
}
