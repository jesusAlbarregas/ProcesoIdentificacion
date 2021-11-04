<%-- 
    Document   : index
    Created on : 12-may-2020, 11:24:20
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/CSS/estilo.css" />
        <title>Identificaci&oacute;n</title>
    </head>
    <body>
        <div id="contenido">
            <h2>Proceso de indentificaci&oacute;n</h2>
            
            <form action="Controlador" method="post">
                <table>
                    <tr>
                        <td colspan="2"><span class="error"><%= (request.getAttribute("error")==null)?"":request.getAttribute("error")%></span></td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td><input type="text" name="usuario" value="<%= (request.getAttribute("usuario")==null)?"":request.getAttribute("usuario")%>"/></td>
                        
                    </tr>
                    <tr>
                        <td>Contrase&ntilde;a:</td>
                        <td><input type="password" name="clave" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="checkbox" name="recordar" value="true" />Recordar usuario</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Enviar" name="enviar" /></td>
                        
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
