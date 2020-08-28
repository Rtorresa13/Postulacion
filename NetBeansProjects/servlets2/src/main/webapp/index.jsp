<%-- 
    Document   : Login
    Created on : 1 jun. 2020, 18:59:03
    Author     : rody_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/Login.js" type="text/javascript"></script>
    
 
    </head>
    <body>

        <div class="container">
            <div id="login" class="signin-card">
                <div class="logo-image">
                    <center>
                        <img src="img/cds_log_02-8789373f-c85b-45bc-b2a9-90d863ff3262.png" alt="Logo" title="Logo" width="100%"/>

                    </center>
                </div>

                <h1 class="display1">INGRESO EMPLEADOS</h1>

                <form action="" name="login" method="" class="" role="form">
                    <input type="hidden" name="op">
                    <div id="form-login-username" class="form-group">
                        <input id="username" class="form-control" value="<%if (request.getAttribute("user")!=null) {String user =(String)request.getAttribute("user");out.print(user); }%>" name="usuario"  type="text" size="18" alt="login" />  
                        <span class="form-highlight"></span>
                        <span class="form-bar"></span>
                        <label for="username" class="float-label">Usuario</label>
                        
                        <div style="float:right ;color:red;" >
                            <%if (request.getAttribute("errorUser")!=null) {String msj1 =(String)request.getAttribute("errorUser");out.print(msj1);}%>
</div>
                    </div>
                    <div id="form-login-password" class="form-group">
                        <input id="passwd" class="form-control" name="clave" type="password" size="18" alt="password" >
                        <span class="form-highlight"></span>
                        <span class="form-bar"></span>
                        <label for="password" class="float-label">Contraseña</label>
                        <div style="float: right;color:red">
                                            <%if (request.getAttribute("errorClave")!=null) {String msj2 =(String)request.getAttribute("errorClave");out.print(msj2); }%>
</div>
                    </div>
                    <div id="form-login-remember" class="form-group">

                    </div>
                    <div>
                        <button class="btn btn-block btn-info ripple-effect" onclick="Ingreso('<%=request.getContextPath()%>/LoginServlet')" type="submit" name="Submit" alt="sign in">Ingresar</button>  
                    </div>

            </div>
        </form>
    </div>
</div>
<center>
    <font color ="red">
<%
if (request.getAttribute("mensaje")!=null) {
        
String msj =(String)request.getAttribute("mensaje");
        out.print(msj);
    }
%></font>
</center>
</body>
</html>
