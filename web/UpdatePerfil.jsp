<%-- 
    Document   : UpdatePerfil
    Created on : 05-abr-2015, 20:55:41
    Author     : Lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
        <h1>Hello ${EUsuario.username}</h1>
            <p><strong>Nombre: </strong>${EPerfil.nombre}</p>
            <p><strong>Apellido: </strong>${EPerfil.apellido}</p>
            <p><strong>C.I: </strong>${EPerfil.ci}</p>
            <p><strong>Email: </strong>${EPerfil.email}</p>
            <p><strong>Telefono: </strong>${EPerfil.telefono}</p>
            <p><strong>Pais: </strong>${EPerfil.pais}</p>
            <p><strong>Ciudad: </strong>${EPerfil.ciudad}</p>
</html>
