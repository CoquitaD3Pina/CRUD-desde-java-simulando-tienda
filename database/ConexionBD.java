package tienda.database;

import java.sql.*;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/tienda_db";
    private static final String USUARIO = "postgres";
    private static final String CONTRASENA = "adrian12345";

    public static Connection obtenerConexion() {
        try {
        return DriverManager.getConnection(URL, USUARIO,CONTRASENA);
    } catch (Exception e) {
        System.out.println("Error al conectar: " + e.getMessage());
        return null;
    }   
    }
}    