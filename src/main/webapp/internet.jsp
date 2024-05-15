
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Aviso> avisos =(List<Aviso>) request.getAttribute("aviso");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>SEGUNDO PARCIAL TEMP-742 </p>
        <p>Nombre: Wilson Ariel Callizaya Mamani </p>                  
        <p>Carnet: 13693963</p>
        
        <h1>REGISTRO DIA DEL INTERNET</h1>
        <p><a href="InternetController?action=add">Nuevo</a></p>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>SEMINARIO</th>
                <th>CONFIRMADO</th>
                <th>FECHA</th>         
            </tr>
<c:forEach var="item" items="${avisos}">

                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.seminario}</td>
                    <td>${item.confirmado}</td>
                    <td>${item.fecha}</td>
                    <td><a href="InternetController?action=edit&id=${item.id}">editar</a></td>
                    <td><a href="InternetController?action=delete&id=${item.id}">eliminar</a></td>

                </tr>
            </c:forEach>
            
            
        </table>
    </body>
</html>
