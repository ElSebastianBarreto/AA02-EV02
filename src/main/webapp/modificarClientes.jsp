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
        <h1>Modificar usuarios</h1>
        
        <a href="index.jsp"><button>Regresar a menu</button></a>
        <a href="servletCliente?action=guardar"><button>crear usuarios</button></a>
        <form action="servletCliente" method="POST">
            <p><label>Cedula: </label><input type="text" name="cedula" id="cedulaid" readonly="">
            <p><label>Nombres: </label><input type="text" name="nombre" id="idnombre">
            <p><label>Apellido: </label><input type="text" name="apellido" id="idapellido">
            <p><label>Edad: </label><input type="text" name="edad" id="idedad">
            <p><label>Correo: </label><input type="text" name="correo" id="idcorreo">
            <p><label>Clave: </label><input type="text" name="clave" id="idclave">
            <p><label>Telefono: </label><input type="text" name="telefono" id="idtelefono">
            <button type="submit" name="action" value="modificar">Modificar</button>
         
             
        </form>

        <form id="eliminarForm" action="servletCliente" method="POST" style="display:none;">
            <input type="hidden" name="id" id="idEliminar">
            <input type="hidden" name="action" value="eliminar">
        </form>

        <table border="1" id="mitabla">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Correo</th>
                <th>Clave</th>
                <th>Telefono</th>
                <th>Selecciona para modificar</th>
                 <th>Elimina registro</th>
            </tr>
            <% 
            List<entidadCliente> usu = (List<entidadCliente>) request.getAttribute("listaclientes");
            for(entidadCliente cliente: usu){
            %>
            <tr>
                <td><%= cliente.getCedula()%></td>
                <td><%= cliente.getNombre() %></td>
                <td><%= cliente.getApellido()%></td>
                <td><%= cliente.getEdad()%></td>
                <td><%= cliente.getCorreo()%></td>
                <td><%= cliente.getClave()%></td>
                <td><%= cliente.getTelefono()%></td>
                <td><button type="button" onClick="seleccionar(this)">Seleccionar</button></td>
                <td><button type="button" onClick="eliminar('<%= cliente.getCedula()%>')">Eliminar</button></td>

            </tr>
            <% 
            }
            %>
        </table>

        <script>
            function seleccionar(button) {
                var row = button.parentNode.parentNode;
                document.getElementById('cedulaid').value = row.cells[0].innerHTML;
                document.getElementById('idnombre').value = row.cells[1].innerHTML;
                document.getElementById('idapellido').value = row.cells[2].innerHTML;
                document.getElementById('idedad').value = row.cells[3].innerHTML;
                document.getElementById('idcorreo').value = row.cells[4].innerHTML;
                document.getElementById('idclave').value = row.cells[5].innerHTML;
                document.getElementById('idtelefono').value = row.cells[6].innerHTML;
            }

            function eliminar(cedula) {
                document.getElementById('idEliminar').value = cedula;
                document.getElementById('eliminarForm').submit();
            }
        </script>
    </body>
</html>