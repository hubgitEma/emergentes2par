<%@page import="com.emergentes.modelo.Productos"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Productos</h1> 
        <a href="Inicio?action=add">Nuevo</a>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Descripcion</td>
                <td>cantidad</td>
                <td>Precio</td>
                <td>Categoria</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach var="item" items="${producto}">
                <tr>
                    <td>${item.id}</td>                   
                    <td>${item.descripcion}</td>                   
                    <td>${item.cantidad}</td>                   
                    <td>${item.precio}</td>                   
                    <td>${item.categoria}</td>                   
                    <td> <a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td> <a href="Inicio?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>   

        </table>
    </body>
</html>
