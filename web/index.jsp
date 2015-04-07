<%-- 
    Document   : index
    Created on : 04-abr-2015, 15:41:19
    Author     : Lion
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/mSheetLogIn.css">
        <link rel="stylesheet" href="./css/mSheetBasico.css">
        <title>Ingreso</title>
    </head>
    <body>        
        <header>
            <h1><strong>Ingreso</strong></h1>
        </header>
        
        <form name="frmUsuario" action="./cLogIn" method="POST" align="center" class="formLogin">
            <div class="slogin" align="center" >
                <p1><strong>NickName</strong></p1><br>
                <input id="etNickName" name="nickname"  class="ctext" placeholder="nickname" value=""  type="text"/><br>
                <p1><strong>Contraseña</strong></p1><br>
                <input id="etPassword" name="password"  class="ctext" placeholder="******" value=""  type="password"/><br>
                <input class="cbutton"  value="Ingresar"type="submit"/><br>
                <a href="crearuser.jsp" >crear cuenta</a>
            </div>
        </form>
        
    </body>
</html>
