/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoaa2ev02;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SEBASTIAN
 */
public class clienteDAO {
    
    public void insertarCliente(int cedula,
    String nombre,
    String apellido,
    int edad,
    String correo,
    String clave,
    String telefono ){
    
    Connection conn = null;
    
    PreparedStatement stmt = null;
    
    
        try {
            conn = conexionDAO.obtenerConexion();
            String sql=" insert into cliente values (" + cedula+ ", '" + nombre+"', '"+apellido+"', "+edad+ ", '"
                    + correo+"', '" + clave+"', '"+ telefono+"' );";
            stmt = conn.prepareStatement(sql);
            
         
             stmt.executeUpdate();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        finally{
        conexionDAO.cerrarConexion(conn);
        
            try {
                if(stmt !=null){stmt.close();}
            } catch (SQLException ex) {  ex.printStackTrace();
            }
        
        
        }
    
    
    
    }
    
    
    
    
   public List<entidadCliente> obtenerClientes(){
   List<entidadCliente> clientes = new ArrayList<>();
   
   Connection conn = null;
   PreparedStatement stmt = null;
   ResultSet rs = null;
   
       try {
           conn = conexionDAO.obtenerConexion();
           String sql = "select * from cliente;";
           stmt = conn.prepareStatement(sql);
           
           rs= stmt.executeQuery();
           
           while(rs.next()){
           entidadCliente cliente = new entidadCliente();
            cliente.setCedula(rs.getInt("cedula"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setEdad(rs.getInt("edad"));
            cliente.setCorreo(rs.getString("correo"));
            cliente.setClave(rs.getString("clave"));
            cliente.setTelefono(rs.getString("telefono"));
            clientes.add(cliente);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
      finally{
        conexionDAO.cerrarConexion(conn);
        
            try {
                if(stmt !=null){stmt.close();}
            } catch (SQLException ex) {  ex.printStackTrace();
            }
            
             try {
                if(rs !=null){rs.close();}
            } catch (SQLException ex) {  ex.printStackTrace();
            }
        
        
        }
   
       return clientes;
   } 
    
    
   
   
     public void modificarCliente(int cedula,
    String nombre,
    String apellido,
    int edad,
    String correo,
    String clave,
    String telefono ){
    
    Connection conn = null;
    
    PreparedStatement stmt = null;
    
    
        try {
            conn = conexionDAO.obtenerConexion();
            String sql=" update cliente set nombre = '" + nombre+"', '"+apellido+"', "+edad+ ", '"
                    + correo+"', '" + clave+"', '"+ telefono+"'  where cedula="+cedula+";";
            stmt = conn.prepareStatement(sql);
             stmt.executeUpdate();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        finally{
        conexionDAO.cerrarConexion(conn);
        
            try {
                if(stmt !=null){stmt.close();}
            } catch (SQLException ex) {  ex.printStackTrace();
            }
        
        
        }
    
  
    }
   
     
     
     
         public void eliminarClientes(int cedula){
    
    Connection conn = null;
    
    PreparedStatement stmt = null;
    
    
        try {
            conn = conexionDAO.obtenerConexion();
            String sql=" delete from cliente  where cedula="+cedula+";";
            stmt = conn.prepareStatement(sql);
       
             stmt.executeUpdate();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        finally{
        conexionDAO.cerrarConexion(conn);
        
            try {
                if(stmt !=null){stmt.close();}
            } catch (SQLException ex) {  ex.printStackTrace();
            }
        
        
        }
    
  
    }
   
   
}
