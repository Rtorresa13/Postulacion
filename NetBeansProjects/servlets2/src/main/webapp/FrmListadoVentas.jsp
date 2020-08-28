<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.VentasBean"%>
<%@page import="java.util.ArrayList"%>

<%! VentasBean viajes = null;
    ArrayList<VentasBean> lista =null; %> 

<%
lista=(ArrayList<VentasBean>)request.getAttribute("lista");

String cargo =(String) session.getAttribute("cargo");%>

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
                 
                 function irBoleta(ruta,codigo,nombre,lugarSalida,lugarDestino,matricula,nomEmpleado,precio,fecha,cantidad,precioTotal)
{
    
                window.document.ventas.action=ruta;
                window.document.ventas.method="GET";
                window.document.ventas.op.value="2";
                window.document.ventas.codigo.value=codigo;
                window.document.ventas.nombre.value=nombre;
                window.document.ventas.lugarSalida.value=lugarSalida;
                window.document.ventas.lugarDestino.value=lugarDestino;
                window.document.ventas.matricula.value=matricula;
                window.document.ventas.nomEmpleado.value=nomEmpleado;
                window.document.ventas.precio.value=precio;
                window.document.ventas.fecha.value=fecha;
                window.document.ventas.cantidad.value=cantidad;
                window.document.ventas.precioTotal.value=precioTotal;
                window.document.ventas.submit();
}
             </script>
                 <script>
             function Filtrar(ruta){
 
    window.document.ventas.action=ruta;
    window.document.ventas.method="GET";
    window.document.ventas.op.value="3";
    window.document.ventas.submit();  }
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
                <form name="ventas" class="form-container col-md-8" >
                    
                    
                         <input type="hidden" name="op">
                    <input type="hidden" name="codigo">
                    <input type="hidden" name="nombre">
                    <input type="hidden" name="lugarSalida">
                    <input type="hidden" name="lugarDestino">
                    <input type="hidden" name="matricula">
                    <input type="hidden" name="nomEmpleado">
                    <input type="hidden" name="precio">
                    <input type="hidden" name="fecha">
                    <input type="hidden" name="cantidad">
                    <input type="hidden" name="precioTotal">
                  
                                        

          <div class="divContainer d-flex justify-content-center">
               <h1 class="display-3">Ventas:</h1>
       </div>
                    
       <div  class="form-inline my-2 my-lg-0" style="float: center">
          <input class="form-control mr-sm-2 <%if (request.getAttribute("error")!=null) {out.print("is-invalid");}%>" name="criterio" type="search" placeholder="Filtrar por:" aria-label="Search">

        <select name="cboOpcion" class="form-control col-md-3 mr-sm-2">
     <option value="0" selected>Seleccione</option>

            <option value="1">Codigo</option>
    <option value="2">Empleado</option>
      <option value="3">Cliente</option>
</select>
        
         <button class="btn btn-outline-success my-2 my-sl-0" onclick="Filtrar('<%=request.getContextPath()%>/VentasServlet')" type="submit">Filtrar</button>
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
                    <th>Cliente</th>
                    <th>Lugar Salida</th>
                    <th>Lugar Destino</th>
                    <th>Matricula</th>
                    <th >Empleado</th>
                      <th >Precio</th>
                    <th >Fecha </th>
                    

                      <th >Boleta</th>

                    </thead>
                    
                  <% for (VentasBean obj: lista) { %>
                        <tr class="table-info">
                        <td> <%=obj.getIdVenta()%></td>
                    
                        <td> <%=obj.getCliente()%></td>
        
                        
                        <td> <%=obj.getLugarSalida()%></td>
                    
                        <td> <%=obj.getLugarDestino()%></td>
                    
                        
                        <td><%=obj.getMatricula()%></td>
                        
                        <td><%=obj.getNomEmpleado()%></td>
                        
                        
                        <td ><%=obj.getPrecio()%></td>
                        
                        <td ><%=obj.getFecha()%></td>
                        
                        
                        
                        <td><button onclick="irBoleta('<%=request.getContextPath()%>/VentasServlet',<%=obj.getIdVenta()%>,'<%=obj.getCliente()%>','<%=obj.getLugarSalida()%>','<%=obj.getLugarDestino()%>','<%=obj.getMatricula()%>','<%=obj.getNomEmpleado()%>','<%=obj.getPrecio()%>','<%=obj.getFecha()%>','<%=obj.getCantidad()%>','<%=obj.getPrecioTotal()%>')" class="btn btn-outline-dark btn-block">Ver Boleta</button></td>
                      
                        </tr>
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
        </body>
</html>
