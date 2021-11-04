<%-- 
    Document   : menu
    Created on : 08-oct-2017, 18:00:36
    Author     : Jesus
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/estilo.css" />
        <title>Admin</title>
    </head>
    <body>
        <div id="contenido">
            <h2>Men&uacute; de <%= (session.getAttribute("usuario")!=null)?session.getAttribute("usuario"):"Usuario no identificado"%></h2>
            <h3>&Uacute;ltimo acceso: <%= (request.getAttribute("acceso")!=null)?request.getAttribute("acceso"):""%></h3>
            <p>Varias opciones (por ejemplo: <a href="<%=request.getContextPath() %>/Pedidos">Pedidos</a>)</p>
            <p><a href="<%=request.getContextPath() %>/Entrada">Cerrar sesi&oacute;n</a></p>
        </div>

    </body>
</html>
