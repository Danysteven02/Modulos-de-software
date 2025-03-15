<%-- 
    Document   : login
    Created on : 13/03/2025, 7:17:08 p. m.
    Author     : Usuario-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Peluqueria</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
    </head>
    <body>
        <main class="container">
        <h1>Login Peluqueria</h1>
        <h3 style="color:red">
            <%= request.getAttribute("mensajeError") !=null ? request.getAttribute("mensajeError"):"" %>
        </h3>
        <form action="loginServlet" name="login" method="POST">
            <input type="text" name="user" placeholder="Usuario">
            <input type="text" name="password" placeholder="Contraseña">
            <input type="submit" value="Ingresar">
        </form>
        </main>
    </body>
</html>

