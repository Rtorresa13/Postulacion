<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.BusesBean"%>
<%@page import="java.util.ArrayList"%>

<%! BusesBean empleados = null;
    ArrayList<BusesBean> lista =null; %> 

<%
lista=(ArrayList<BusesBean>)request.getAttribute("lista");
String cargo =(String) session.getAttribute("cargo");

%>

<!DOCTYPE html>
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
             <title>Listado de Buses</title>
             <script>
             function Filtrar(ruta){
 
    window.document.ListadoBus.action=ruta;
    window.document.ListadoBus.method="GET";
    window.document.ListadoBus.op.value="8";
    window.document.ListadoBus.submit();  }
  </script>
    </head>
    <body style="background-image: url(img/fondo.jpg);""
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
      <div class=" d-flex justify-content-center">
         <div class="divContainer d-flex justify-content-center col-md-5">
               
             <h1 class="display-3">Listado de Buses</h1>

       </div>    
          </div>
       
  
      
      
      
      <div class="d-flex justify-content-center">
         <form name="ListadoBus" class="form-container col-md-5">
             
             
             <input type="hidden" name="codigo">
             <input type="hidden" name="op">
             
             
                <br>
             

             
                <button class="btn btn-outline-dark btn-block" onclick="IrFrmBus('<%=request.getContextPath()%>/BusesServlet')" >Registrar Buses</button>
 <div  class="form-inline my-2 my-lg-0" style="float: center">
          <input class="form-control mr-sm-2 <%if (request.getAttribute("error")!=null) {out.print("is-invalid");}%>" name="criterio" type="search" placeholder="Filtrar por:" aria-label="Search">

        <select name="cboOpcion" class="form-control col-md-3 mr-sm-2">
  <option value="0">Seleccione</option>
 
            <option value="1">Matricula</option>
    <option value="2">Codigo</option>
</select>
        
         <button class="btn btn-outline-success my-2 my-sl-0" onclick="Filtrar('<%=request.getContextPath()%>/BusesServlet')" type="submit">Filtrar</button>
        </div>
                <div style="float: top; color:red" >

         <%if (request.getAttribute("error")!=null) {
               out.print("Caracter invalido!");
             }
         %>
      </div>
    
                
                 <table class="table tableContainer">
                    <tr>    
                          <thead class="thead-dark">    
                    <th scope="row">Codigo</th>
                    <th  scope="row">Asientos</th>
                    <th  scope="row">Matricula</th>
                    <th  scope="row">Borrar</th>
                    <th  scope="row">Modificar</th>

                    </tr>
                    
                  <% for ( BusesBean obj: lista) { %>
                  
                        <tr class="table-info">
                        <td><%=obj.getIdBus()%> </td>
 
                    
                        <td> <%=obj.getNumAsientos()%></td>
                    
                        <td> <%=obj.getMatricula()%></td>
                        
       
                        <td><button class="btn btn-outline-dark" onclick="Eliminar('<%=request.getContextPath()%>/BusesServlet',<%=obj.getIdBus()%>)">Borrar </td>
                   <td><button class="btn btn-outline-dark" onclick="Editar('<%=request.getContextPath()%>/BusesServlet','<%=obj.getIdBus()%>','<%=obj.getMatricula()%>','<%=obj.getNumAsientos()%>')">Modificar</td>
                   
                        
                       
                        </tr>
                         <% } %>
                        
                    
                    
                    
                </table>

             <input type="hidden" name="matricula">
             <input type="hidden" name="asientos">
                
    </form>
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
                             
                  <script src="js/Buses.js" type="text/javascript"></script>

             </body>
</html>
