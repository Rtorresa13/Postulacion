<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>

<%@page import="numeros_a_letras.Numero_a_Letra"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String idVenta = (String)request.getAttribute("numventa");
 String fecha= (String)request.getAttribute("fecha");
String nomCliente=(String) request.getAttribute("cliente");
String nomVendedor=(String) request.getAttribute("vendedor");
String lugarSalida=(String) request.getAttribute("lugarSalida");
String lugarDestino=(String) request.getAttribute("lugarDestino");
 String matricula=(String)request.getAttribute("matricula");
String precioTotal= (String)request.getAttribute("precioTotal");
String cantidad=(String) request.getAttribute("cantidad");
 String cargo =(String) session.getAttribute("cargo");
 

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<link href="css/default1.css" rel="stylesheet" type="text/css"/>
         <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
             <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
             <title>Boleta</title>
   
    </head>
    <body style="background-image: url(img/fondo.jpg);">
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
            <li class="nav-item ">
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
         
       
                    </header>
      
      <div class="d-flex justify-content-center">
      <div class="divContainer col-md-6 justify-content-center " style="background-color: white"> 
        
                <div class="divContainer d-flex justify-content-center">
               <h1 class="display-4">Boleta</h1>

                  </div> 
          
         <img src="img/cds_log_02-8789373f-c85b-45bc-b2a9-90d863ff3262.png" class="rounded mx-auto d-block" width="100%">
        <table class="table">

  <tbody>
    <tr>
      <td>Numero de venta: </td>
      <td><%=idVenta%></td>
    </tr>
      
    <tr>
      <td>Fecha </td>
      <td><%=fecha%></td>
    </tr>
    <tr>
      <td>Cliente:</td>
      <td><%=nomCliente%></td>
    </tr>
    <tr>
      <td>Vendedor:</td>
        <td><%=nomVendedor%></td>
    </tr>
    <tr>
      <td>Desde :</td>
        <td><%=lugarSalida%></td>
    </tr><tr>
      <td>Destino:</td>
        <td><%=lugarDestino%></td>
    </tr>
    <tr>
      <td>Transporte</td>
        <td><%=matricula%></td>
    </tr>
    <tr>
      <td>Cantidad</td>
        <td><%=cantidad%></td>
    </tr>
     <tr>
      <td>Importe</td>
        <td>S/<%=precioTotal%></td>
    </tr>
    
  </tbody>
</table>
        <center>
IMPORTE TOTAL:
<%Numero_a_Letra d = new Numero_a_Letra();
        
String letras= d.Convertir( precioTotal, true);
 %><%=letras%> </center></div>
      </div>
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
</body>
</html>
