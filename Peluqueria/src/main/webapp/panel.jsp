<%-- 
    Document   : panel
    Created on : 13/03/2025, 7:24:59 p. m.
    Author     : Usuario-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Usuarios Proyecto Peluqueria</title>
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
            >
    </head>
    <body>
        <<main class="container">
        <h1>Bienvenido <%= request.getAttribute("usuario") %> </h1>
        <p>Este es tu panel de Usuario &#128516</p>
        </main>
    </body>
</html>
