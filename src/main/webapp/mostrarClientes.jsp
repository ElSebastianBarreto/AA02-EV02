
<%@page import="java.util.List"%>
<%@page import="com.mycompany.proyectoaa2ev02.entidadCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de usuarios</h1>
        
        <a href="index.jsp">Regresar a menu</a>
        
        <table border="1">
            
            <tr>
                <th>ID</th>
                 <th>Nombre</th>
                
            </tr>
            <% 
            List<entidadCliente> usu = (List<entidadCliente>) request.getAttribute("listaclientes");
            
            for(entidadCliente cliente: usu){
            %>
            
            <tr>
                <td><%= cliente.getCedula() %></td>
                <td><%= cliente.getNombre()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
