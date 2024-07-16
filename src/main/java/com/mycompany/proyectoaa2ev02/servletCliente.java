package com.mycompany.proyectoaa2ev02;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author SEBASTIAN
 */
@WebServlet(name = "servletCliente", urlPatterns = {"/servletCliente"})
public class servletCliente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

//recibir
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if("mostrar".equals(action)){
            mostrarClientes(request, response);
        }
        else if("guardar".equals(action)){mostrarClientesGuardar(request, response);}
        else if("modificar".equals(action)){mostrarClientesModificar(request, response);}
        else if("eliminar".equals(action)){mostrarClientesModificar(request, response);}
        
    }

 //enviar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String action = request.getParameter("action");
        if("guardar".equals(action)){guardarClientes(request, response);}
        else if("modificar".equals(action)){modificarClientes(request, response);}
        else if("eliminar".equals(action)){eliminarClientes(request, response);}
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    public void guardarClientes(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    
    int cedula = Integer.parseInt(request.getParameter("cedula"));
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    int edad = Integer.parseInt(request.getParameter("edad"));
     String correo = request.getParameter("correo");
    String clave = request.getParameter("clave");
    String telefono = request.getParameter("telefono");
    
    
    clienteDAO clienteDAO = new clienteDAO();
    clienteDAO.insertarCliente(cedula, nombre,apellido,edad,correo,clave,telefono);
    //nos actualiza
        mostrarClientesGuardar(request, response);
    
    }
    
    public void mostrarClientes(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    clienteDAO clienteDAO = new clienteDAO();
    List<entidadCliente> clientes = clienteDAO.obtenerClientes();
    request.setAttribute("listaclientes", clientes);
    request.getRequestDispatcher("mostrarClientes.jsp").forward(request, response);
    
    }
    
        public void mostrarClientesGuardar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    clienteDAO clienteDAO = new clienteDAO();
    List<entidadCliente> clientes = clienteDAO.obtenerClientes();
    request.setAttribute("listaclientes", clientes);
    request.getRequestDispatcher("guardarClientes.jsp").forward(request, response);
    
    }
        
        
           public void modificarClientes(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    
   int cedula = Integer.parseInt(request.getParameter("cedula"));
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    int edad = Integer.parseInt(request.getParameter("edad"));
     String correo = request.getParameter("correo");
    String clave = request.getParameter("clave");
    String telefono = request.getParameter("telefono");
    
    
    clienteDAO clienteDAO = new clienteDAO();
    clienteDAO.modificarCliente(cedula, nombre, apellido, edad, correo, clave, telefono);
    //nos actualiza
        mostrarClientesModificar(request, response);
    
    }
           
    public void mostrarClientesModificar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    clienteDAO clienteDAO = new clienteDAO();
    List<entidadCliente> clientes = clienteDAO.obtenerClientes();
    request.setAttribute("listaclientes", clientes);
    request.getRequestDispatcher("modificarClientes.jsp").forward(request, response);
    
    }
    
    
    public void eliminarClientes(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
    
    int id = Integer.parseInt(request.getParameter("id"));
   
    
    
    clienteDAO clienteDAO = new clienteDAO();
    clienteDAO.eliminarCliente(id);
 
        //nos actualiza
        mostrarClientesModificar(request, response);
    
    }
       
}
