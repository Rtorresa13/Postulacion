<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
String codigo=(String)request.getAttribute("codigo");
String nom =(String)request.getAttribute("nombre");
String dni=(String)request.getAttribute("dni");
String sexo=(String)request.getAttribute("sexo");
String cargo =(String) session.getAttribute("cargo");

%>


<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

         <script src="js/bootstrap.min.js" type="text/javascript"></script>
          <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
             <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
             <title>CLIENTES</title>
   
    </head>
    <body style="background-image: url(img/fondo.jpg);"">
        <header id="encabezado">
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="<%=request.getContextPath()%>/LoginServlet?op=2">Cruz del sur</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
         <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <% String nombre =(String)session.getAttribute("empleadonombre");
                               
                        out.print("Bienvenido "+ nombre +"!");%>
        </a>
      <div class="dropdown-menu  "  aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="<%=request.getContextPath()%>/LoginServlet?op=3">Cerrar sesion</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="<%=request.getContextPath()%>/EmpleadoServlet?op=7">Cambiar Contraseña</a>
        </div>
      </li>
     <%if (cargo.equals("Vendedor")){%>       
      <li class="nav-item">
        <a class="nav-link disabled" href="<%=request.getContextPath()%>/EmpleadoServlet?op=1">Empleados<span class="sr-only">(current)</span></a>
      </li>
            <li class="nav-item">
        <a class="nav-link disabled" href="<%=request.getContextPath()%>/VentasServlet?op=1">Ventas<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
        <a class="nav-link disable" href="<%=request.getContextPath()%>/ClienteServlet?op=1">Clientes<span class="sr-only">(current)</span></a>
      </li>
     <li class="nav-item ">
        <a class="nav-link disabled" href="<%=request.getContextPath()%>/ViajeServlet?op=1">Viajes<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item ">
        <a class="nav-link disabled" href="<%=request.getContextPath()%>/BusesServlet?op=1">Buses<span class="sr-only">(current)</span></a>
      </li>
     
     <%}else{%>
        <li class="nav-item active">
        <a class="nav-link " href="<%=request.getContextPath()%>/EmpleadoServlet?op=1">Empleados<span class="sr-only">(current)</span></a>
      </li>
            <li class="nav-item active">
        <a class="nav-link " href="<%=request.getContextPath()%>/VentasServlet?op=1">Ventas<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
        <a class="nav-link " href="<%=request.getContextPath()%>/ClienteServlet?op=1">Clientes<span class="sr-only">(current)</span></a>
      </li>
     <li class="nav-item  active">
        <a class="nav-link " href="<%=request.getContextPath()%>/ViajeServlet?op=1">Viajes<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link " href="<%=request.getContextPath()%>/BusesServlet?op=1">Buses<span class="sr-only">(current)</span></a>
      </li>
     
     <%}%>
    </ul>
 
  </div>
</nav>
         
        

    <div class="d-flex justify-content-center">
    <form name="Clientes" class="form-container col-md-6 ">
        <input type="hidden" name="op" > 
        <div class="divContainer d-flex justify-content-center">
               <h1 class="display-4">Modificar</h1>

       </div>   
        <br>
     <div class="form-group">
    <label for="exampleInputEmail1">Codigo</label>
    <input type="text" value="<%=codigo%>" name="txtCodigo" class="form-control" readonly="readonly" >

  </div>
        
  <div class="form-group">
    <label for="exampleInputEmail1">Nombre</label>
    <input type="text" value="<%=nom%>" name="txtNombre" class="form-control" >
    <small id="emailHelp" class="form-text text-muted">Digite nombre y apellidos</small>
    <div style="float: right; color:red">
    <p> <%if (request.getAttribute("errorNombre")!=null) { String errorNombre =  (String)request.getAttribute("errorNombre"); out.print(errorNombre); } %>
    </p></div>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">DNI</label>
    <input type="text" value="<%=dni%>" name="txtDni" class="form-control"  >
    <small  class="form-text text-muted">Digite documento de identidad</small>
       <div style="float: right; color:red"><p><%if (request.getAttribute("errorDni")!=null) { String errorDni =  (String)request.getAttribute("errorDni"); out.print(errorDni); } %>
        </p></div>
  
  </div>      
  <div class="form-group">
    <label for="exampleInputEmail1">Sexo</label>
    <select name="cboSexo" class="custom-select custom-select-lg mb-3">
        <option><%=sexo%></option>
        <option >F</option>
  <option >M</option>
</select>
     
 </div> 

        
       
    
            <button  class=" btn btn-primary btn-block" onclick="actualizar('<%=request.getContextPath()%>/ClienteServlet')"> MODIFICAR</button><br>

</form>

    </div>
            <br><br>
            <footer>
                             <div class="row text-center" style='color:white;'>
                                 <div class="col-md-4" >
                                     <h5 class="text-uppercase">Social</h5>

        <ul class="list-unstyled">
          <li>
              <a href="#!"><img src="img/facebook_icon-icons.com_66092.ico" width="5%" alt='fb'> </a>
              <a href="www.facebook.com">/autonoma</a>
              
            
          </li>
          <li>
            <a href="#!"><img src="img/twitter_icon-icons.com_66093.ico" width="5%" alt='fb'> </a>
              <a href="www.twitter.com">/autonoma</a>
          </li>
                                     
                                 </div>
                                 <div class="col-md-4" style='color:white'>
                                                                          <p>Copyright © Autonoma 2020</p>

                                 </div>
                             
                             </div>
                             
                             
                         </footer>
            <script src="js/Clientes.js" type="text/javascript"></script>
            
        </body>
</html>
