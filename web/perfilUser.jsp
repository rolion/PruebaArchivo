<%-- 
    Document   : principal
    Created on : 05-abr-2015, 13:34:53
    Author     : Lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/mSheetBasico.css">
        <link rel="stylesheet" href="./css/mSheetPerfil.css">
        <title>JSP Page</title>
    </head>
    <body>
         <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
        <header>
            <h1><strong>Perfil</strong></h1>
        </header>
        <formname name="frmPerfil" action="./cPerfil" method="POST"  class="formMainPerfil">
            <nav aline align="left">
                <li>
                  Bienvenido ${EPerfil.nombre}
                </li>
                <li>
                    <a href="UpdatePerfil.jsp" >Actualizar Perfil</a>
                </li>
                <li>
                    <a href="UpdateUser.jsp" >Actualizar Cuenta Usuario</a>
                </li>
                <li>
                    <a href="UpdateUser.jsp" >Gestionar Privilegios</a>
                </li>
                <li>
                    <a href="UpdateUser.jsp" >Gestionar Grupo</a>
                </li>
            </nav>
            <div class="divPerfil">
                <p class="titleP">Datos Personales</p>
                <p><strong>Nombre: </strong>${EPerfil.nombre}</p>
                <p><strong>Apellido: </strong>${EPerfil.apellido}</p>
                <p><strong>C.I: </strong>${EPerfil.ci}</p>
                <p><strong>Email: </strong>${EPerfil.email}</p>
                <p><strong>Telefono: </strong>${EPerfil.telefono}</p>
                <p><strong>Pais: </strong>${EPerfil.pais}</p>
                <p><strong>Ciudad: </strong>${EPerfil.ciudad}</p>
            </div>
            <div class="divUser">
                <p class="titleP">Datos De cuenta</p>
                <p><strong>Usuario:</strong>${EUsuario.username}</p>
                <p><strong>Grupo:</strong>${EUsuario.groupName}</p>
            </div>
        </form>
    </body>
</html>
