
<%@page import="com.mycompany.proyectoaa2ev02.entidadCliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Guardar usuarios</h1>
        
      <a href="index.jsp"><button>Regresar a menu</button></a>
        
        
        <form action="servletCliente" method="POST">
            <p><label>Cedula: </label><input type="text" name="cedula">
            <p><label>Nombres: </label><input type="text" name="nombre">   
            <p><label>Apellidos: </label><input type="text" name="apellido">
            <p><label>Edad: </label><input type="text" name="edad">
            <p><label>Correo: </label><input type="text" name="correo">
            <p><label>Clave: </label><input type="text" name="clave">
            <p><label>Telefono: </label><input type="text" name="telefono">
                
                <button type="submit" name="action" value="guardar">Guardar</button>    
        </form>
        
<table border="1">
            
            <tr>
                <th>Cedula</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Correo</th>
                <th>Clave</th>
                <th>Telefono</th>
                
            </tr>
             <% 
            List<entidadCliente> usu = (List<entidadCliente>) request.getAttribute("listaclientes");
            
            for(entidadCliente cliente: usu){
            %>
            
            <tr>
                <td><%= cliente.getCedula()%></td>
                <td><%= cliente.getNombre()%></td>
                <td><%= cliente.getApellido()%></td>
                <td><%= cliente.getEdad()%></td>
                <td><%= cliente.getCorreo()%></td>
                <td><%= cliente.getClave()%></td>
                <td><%= cliente.getTelefono()%></td>
            </tr>
            <%
                }
            %>
        </table>
   
    </body>
</html>
