package com.mycompany.proyectoaa2ev02;
import java.sql.*;
/**
 *
 * @author SEBASTIAN
 */
public class conexionDAO {
    private static final String url = "jdbc:postgresql://localhost:5432/prueba";
    private static final String username="postgres";
    private static final String pass="root";
    
    public static Connection obtenerConexion(){
    Connection conn =null;
    try{
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url,username,pass);
    }catch(Exception e){
        System.out.println("Error al conectar"+e);
    }
    return conn;
    }
    public static void cerrarConexion (Connection conn) {
    
        try {
            if(conn!=null){ conn.close();}
        } catch (Exception e) { System.out.println("Error al conectar"+e);
        }
    }
    
}