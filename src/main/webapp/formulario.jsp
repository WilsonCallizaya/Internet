<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    Aviso avisos = (Aviso) request.getAttribute("avisos");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form action="InternetController" method="post">
            <input type="hidden" name="id" value="${avisos.id}">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="${avisos.nombre}"/></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido" value="${avisos.apellido}"/></td>
                </tr>
                <tr>
                    <td>Seminario:</td>
                    <td><input type="text" name="seminario" value="${avisos.seminario}"/></td>
                </tr>
                <tr>
                    <td>Confirmado:</td>
                    <td>
                        <input type="checkbox" name="confirmado" value="si" ${avisos.confirmado == 'si' ? 'checked' : ''}/> Si<br>
                        <input type="checkbox" name="confirmado" value="no" ${avisos.confirmado == 'no' ? 'checked' : ''}/> No
                    </td>
                </tr>
                <tr>
                    <td>Fecha:</td>
                    <td><input type="date" name="fecha" value="${avisos.fecha}"/></td>
                </tr>
                <tr>

                    <td><input type="submit" value="enviar"/></td>
                </tr>

                
                
                
            </table>
            
            
        </form>
    </body>
</html>
