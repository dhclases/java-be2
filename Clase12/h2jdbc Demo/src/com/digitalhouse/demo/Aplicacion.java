package com.digitalhouse.demo;



import java.sql.*;

public class Aplicacion {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " EMPRESA varchar(100) NOT NULL, "
            + " EDAD INT NOT NULL,"
            + " FECHA_INICIO varchar(100) NOT NULL"
            + " )";

    private static final String SQL_INSERT =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (1,'Javier','Digital',28,'12/10/2020')";
    private static final String SQL_INSERT2 =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (2,'Pepe','Facebook',40,'09/11/2020')";
    private static final String SQL_INSERT3 =  "INSERT INTO EMPLEADO (ID, NOMBRE, EMPRESA, EDAD, FECHA_INICIO) VALUES (3,'Diego','Google',33,'12/20/2021')";

    public static void main(String[] args) throws Exception {
        // Establecer connection
        Connection connection = null;
        try {
            connection = getConnection();

            //Crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            // Realziar la primera carga de datos
            Statement statementIns = connection.createStatement();
            statementIns.execute(SQL_INSERT);

            Statement statementIns2 = connection.createStatement();
            statementIns2.execute(SQL_INSERT2);

            Statement statementIns3 = connection.createStatement();
            statementIns3.execute(SQL_INSERT3);

            String sql = "SELECT * FROM EMPLEADO";
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);

            // Listar los campos del resulset
            while(rs.next()){
                // Listamos por orden y por nombre del campo
                System.out.println(rs.getInt(1) + " " + rs.getString("NOMBRE") + " " + rs.getString(3) + " " + rs.getInt("EDAD"));
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


















    }

    public static Connection getConnection() throws Exception {
       //Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test");

    }




}

