<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.EmpleadoBean"%>
<%@page import="java.util.ArrayList"%>

<%! EmpleadoBean empleados = null;
    ArrayList<EmpleadoBean> lista =null; %> 

<%
lista=(ArrayList<EmpleadoBean>)request.getAttribute("lista");
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
             <script>
             function Filtrar(ruta){
 
    window.document.ListadoEmpleados.action=ruta;
    window.document.ListadoEmpleados.method="GET";
    window.document.ListadoEmpleados.op.value="9";
    window.document.ListadoEmpleados.submit();  }
  </script>
    

             
             <title>EMPLEADOS</title>
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
            <li class="nav-item">
        <a class="nav-link disabled " href="<%=request.getContextPath()%>/VentasServlet?op=1">Ventas<span class="sr-only">(current)</span></a>
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
      
     
                        
            
             
       
     <div class="d-flex justify-content-center ">
         
      <form name="ListadoEmpleados" class="form-container col-md-9" >
          
          <input type="hidden" name="codigo">
       <input type="hidden" name="op">
       <input type="hidden" name="nombre">
       <input type="hidden" name="dni">
       <input type="hidden" name="direccion">
       <a href="FrmModificarEmpleados.jsp"></a>
       
       <input type="hidden" name="idCargo">
              <input type="hidden" name="sexo">

       <input type="hidden" name="telefono">
       <div class="divContainer d-flex justify-content-center">
               <h1 class="display-3">Listado de Empleados</h1>

       </div>   
       <br>
    <button type="button" onclick ="IrFrmEmpleado('<%=request.getContextPath()%>/EmpleadoServlet')" class="btn btn-block btn-outline-dark">Registrar Empleado</button>
    <div  class="form-inline my-2 my-lg-0" style="float: center">
          <input class="form-control mr-sm-2 <%if (request.getAttribute("error")!=null) {out.print("is-invalid");}%>" name="criterio" type="search" placeholder="Filtrar por:" aria-label="Search">

        <select name="cboOpcion" class="form-control col-md-3 mr-sm-2">
     <option value="0" selected>Seleccione</option>

            <option value="1">Cargo</option>
    <option value="2">Codigo</option>
      <option value="3">Nombre</option>
</select>
        
         <button class="btn btn-outline-success my-2 my-sl-0" onclick="Filtrar('<%=request.getContextPath()%>/EmpleadoServlet')" type="submit">Filtrar</button>
        </div>
                <div style="float: top; color:red" >

         <%if (request.getAttribute("error")!=null) {
               out.print("Caracter invalido!");
             }
         %>
      </div>
        <table class="table tableContainer" style="border-color: black">
                    <thead class="thead-dark">    
                        
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">sexo</th>
                    
                    <th scope="col">Dni</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">idCargo</th>
                    
                    <th scope="col">Telefono</th>
                    
                    <th scope="col">Borrar</th>
                    <th scope="col">Modificar</th>

                    </thead>
                  <% for (EmpleadoBean obj: lista) { %>
                        <tr class="table-info">
                        <td> <%=obj.getIdEmpleado()%></td>
                    
                   
                        <td> <%=obj.getNombre()%></td>
                    
                      <td><%=obj.getSexo()%></td>
                        
                     
                        <td> <%=obj.getDni()%></td>
                    
                        <td> <%=obj.getDireccion()%></td>
                    
                        <td> <%=obj.getNomCargo()%></td>
                        
                        <td><%=obj.getTelefono()%></td>
                        
                        
                        <td><button class="btn btn-outline-dark"onclick="Eliminar('<%=request.getContextPath()%>/EmpleadoServlet','<%=obj.getIdEmpleado()%>')">borrar</button> </td>
                        <td><button class="btn btn-outline-dark" OnClick= "modificar('<%=request.getContextPath()%>/EmpleadoServlet','<%=obj.getIdEmpleado()%>','<%=obj.getNombre()%>','<%=obj.getDni()%>','<%=obj.getDireccion()%>','<%=obj.getNomCargo()%>','<%=obj.getTelefono()%>','<%=obj.getSexo()%>')">Modificar</button></td>    
                    
                     
                       
                         <% } %>
                        
                    
                    
                    
                </table>

    
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
                             
                             
                         </footer>
                         <script src="js/empleados3.js" type="text/javascript"></script>
    </body>
</html>
