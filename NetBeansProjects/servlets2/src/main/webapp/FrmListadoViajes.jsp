<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.ViajesBean"%>
<%@page import="java.util.ArrayList"%>

<%! ViajesBean viajes = null;
    ArrayList<ViajesBean> lista =null; %> 

<%
    String cargo =(String) session.getAttribute("cargo");

lista=(ArrayList<ViajesBean>)request.getAttribute("lista");
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
             <title>Listado de Viajes</title>
          
           <script>
             function Filtrar(ruta){
 
    window.document.ListadoViaje.action=ruta;
    window.document.ListadoViaje.method="GET";
    window.document.ListadoViaje.op.value="7";
    window.document.ListadoViaje.submit();  }
  </script>
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
         
     
      
      <div class="d-flex justify-content-center">
                <form name="ListadoViaje" class="form-container col-md-8" >
                    <input type="hidden" name="op">
                    <input type="hidden" name="codigo">
                    <input type="hidden" name="salida">

                    <input type="hidden" name="destino">

                    <input type="hidden" name="bus">

                    <input type="hidden" name="asientos">

                    <input type="hidden" name="fecha">
                                        <input type="hidden" name="idbus">
                                        <input type="hidden" name="precio">
                                        


          <div class="divContainer d-flex justify-content-center">
               <h1 class="display-3">Viajes:</h1>
       </div>   
         <button class="btn btn-block btn-outline-dark" onclick="IrFrmViaje('<%=request.getContextPath()%>/ViajeServlet')" >Registrar viajes</button>
    <div  class="form-inline my-2 my-lg-0" style="float: center">
          <input class="form-control mr-sm-2 <%if (request.getAttribute("error")!=null) {out.print("is-invalid");}%>" name="criterio" type="search" placeholder="Filtrar por:" aria-label="Search">

        <select name="cboOpcion" class="form-control col-md-3 mr-sm-2">
     <option value="0" selected>Seleccione</option>

            <option value="1">Codigo</option>
    <option value="2">Matricula</option>
      <option value="3">Precio</option>
</select>
        
         <button class="btn btn-outline-success my-2 my-sl-0" onclick="Filtrar('<%=request.getContextPath()%>/ViajeServlet')" type="submit">Filtrar</button>
        </div>
                <div style="float: top; color:red" >

         <%if (request.getAttribute("error")!=null) {
               out.print("Caracter invalido!");
             }
         %>
      </div>
         
                    <table class="table tableContainer" style="border-color: black">
                    <thead class="thead-dark">    
                    <th>Codigo</th>
                    <th>Salida</th>
                  
                    <th>Destino</th>
                    <th>Bus</th>
                    <th>Vendidos</th>
                    <th >Fecha </th>
                    <th >Precio </th>
                    
                    <th>Borrar</th>
                    <th>Modificar</th>

                    </thead>
                    
                  <% for (ViajesBean obj: lista) { %>
                        <tr class="table-info">
                        <td> <%=obj.getIdViaje()%></td>
                    
                   
                       
                    
                        <td> <%=obj.getLugarSalida()%></td>
                    
                        <td> <%=obj.getLugarDestino()%></td>
                    
                        <td> <%=obj.getMatricula()%></td>
                        
                        <td><%=obj.getNumVendidos()%></td>
                        
                        <td ><%=obj.getFecha()%></td>
                        
                        <td ><%=obj.getPrecio()%></td>
                        
                        
                        
                        <td><button onclick="Eliminar('<%=request.getContextPath()%>/ViajeServlet','<%=obj.getIdViaje()%>')" class="btn btn-outline-dark btn-block">Borrar</button></td>
                      <td><button onclick="Modificar('<%=request.getContextPath()%>/ViajeServlet','<%=obj.getIdViaje()%>','<%=obj.getLugarSalida()%>','<%=obj.getLugarDestino()%>','<%=obj.getMatricula()%>','<%=obj.getNumVendidos()%>','<%=obj.getFecha()%>','<%=obj.getIdBus()%>','<%=obj.getPrecio()%>')" class="btn btn-outline-dark btn-block">Modificar</button></td>
                      
                        
                        </tr>
                         <% } %>
                        
                    
                    
                    
                </table>
                    
                       
    </form>
    </div>
                         <script src="js/viajeJs.js" type="text/javascript"></script>
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
