<%-- 
    Document   : index
    Created on : 12/07/2024, 1:25:45 p. m.
    Author     : SEBASTIAN
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Lista de bd</title>
        
        <style>
            .botones-container{
                text-align: center;
            }
            .botonoes-container button{
                margin: 5px;
            }
        </style>    
    </head>
    <body>
        <h1>Crud JSP </h1>
        <h2>menu principal</h2>
        
        
        <div class="botonoes-container"
            
            <form action="" method="GET">
                <a href=""><button>mostrar usuarios</button></a>
                <a href=""><button>guardar usuarios</button></a>
                <a href=""><button>modificar usuarios</button></a>

            </form>
            
 
            
        </div>
        
    </body>
</html>
