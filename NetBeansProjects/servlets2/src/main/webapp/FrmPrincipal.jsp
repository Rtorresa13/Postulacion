<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.ViajesBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ClientesBean"%>

<%! ViajesBean viaje = null;
   
ArrayList<ViajesBean> listaViajes =null;
ArrayList<ClientesBean> listaClientes = null;

%> 

<%
//listaDestino=(ArrayList<ViajesBean>)session.getAttribute("listaDestino");

//listaSalida=(ArrayList<ViajesBean>)session.getAttribute("listaSalida");
listaClientes=(ArrayList<ClientesBean>)request.getAttribute("listaClientes");
listaViajes=(ArrayList<ViajesBean>)request.getAttribute("listaViajes");
String cargo =(String) session.getAttribute("cargo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script> 

         <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
             <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
             <link href="css/default1.css" rel="stylesheet" type="text/css"/>

             
             <title>VENTA DE BOLETOS</title>
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

        <form name="Principal">
        <input type="hidden" name="codigo" >    
            
        <input type="hidden" name="matricula">    
            
        <input type="hidden" name="idEmpleado">    
        <input type="hidden" name="numVendidos">    
        <input type="hidden" name="numAsientos">    
        <input type="hidden" name="nomEmpleado">    
        <input type="hidden" name="lugarSalida">    
    
        <input type="hidden" name="lugarDestino">    
        <input type="hidden" name="precio">    

        
            
      <div class="d-flex justify-content-center">
<div class="form-container col-md-5 " >
    <input type="hidden" name="op" >
     <div class="divContainer d-flex justify-content-center">    
    <h1 class="display-3" style="font-size: 32px; text-decoration: underline  #0067B1 solid; letter-spacing: 5px;font-weight:400;">Clientes</h1>
    </div>
    <div class="form-row">
    <div class="col">
      <label for="formGroupExampleInput">Clientes registrados:</label>
  <select name ="cboCliente" class="form-control" id="inlineFormCustomSelectPref">
      
    <option selected  value="0" >Elegir...</option>
     <%for(ClientesBean obj: listaClientes){ %>
     <option value="<%=obj.getIdCliente()%>"><%=obj.getIdCliente()%>-<%=obj.getNombre()%></option>

    <%}%>
    
  </select>
      <div style="float: right; color:red">
  <p><%if (request.getAttribute("errorCliente")!=null) { String errorCliente =  (String)request.getAttribute("errorCliente"); out.print(errorCliente); } %>
  </p></div>
    </div>
    <div class="col">
      <div class="form-group">
    <label for="formGroupExampleInput">Cantidad:</label>
    <input name="txtCantidad" type="text" class="form-control" id="formGroupExampleInput" placeholder="">
        <div style="float: right; color:red">
  <p><%if (request.getAttribute("errorCantidad")!=null) { String errorCantidad =  (String)request.getAttribute("errorCantidad"); out.print(errorCantidad); } %>
  </p></div> <div style="float: right; color:red">
  <p><%if (request.getAttribute("errorBoleto")!=null) { String errorBoleto=  (String)request.getAttribute("errorBoleto"); out.print(errorBoleto); } %>
  </p></div> </div>
    </div>
  </div>
        
    
    
   


    <br>
    <section >
       <div style="background-color: #D6EAF8" class="divContainer d-flex justify-content-center">  
               <label for="formGroupExampleInput">¿No esta registrado?</label>

           
       </div>
    </section>
    
    
    
    <div class="form-group">
    <label for="formGroupExampleInput">Nombre:</label>
    <input name="txtNombre" type="text" class="form-control" id="formGroupExampleInput" placeholder="Nombre y apellido del cliente">
    <div style="float: right; color:red">
    <p> <%if (request.getAttribute("errorNombre")!=null) { String errorNombre =  (String)request.getAttribute("errorNombre"); out.print(errorNombre); } %>
    </p></div>
    </div>
        <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Sexo:</label>
  <select name="cboSexo" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
      
    <option selected value="0">Elegir...</option>
   
    <option value="M">Masculino </option>

    <option value="F">Femenino</option>
  </select>
        <div style="float: right; color:red">
  <p><%if (request.getAttribute("errorSexo")!=null) { String errorSexo =  (String)request.getAttribute("errorSexo"); out.print(errorSexo); } %>
  </p></div>   <div class="form-group">
    <label for="formGroupExampleInput">DNI:</label>
    <input type="text" name="txtDni" class="form-control" id="formGroupExampleInput" placeholder="Documento de identidad del cliente:">
    <div style="float: right; color:red"><p><%if (request.getAttribute("errorDni")!=null) { String errorDni =  (String)request.getAttribute("errorDni"); out.print(errorDni); } %>
        </p></div>
      </div>
    
        
            <button type="button" class="btn btn-dark btn-block" onclick="Registrar('<%=request.getContextPath()%>/ClienteServlet')">Registrar</button>
            
</div>  
            
            
    <section class="col-md-1">
    </section>
    <div class="form-container col-md-5  " >
    <div class="divContainer d-flex justify-content-center">    
    <h1 class="display-3 " style="font-size: 32px; text-decoration: underline  #0067B1 solid; letter-spacing: 5px;font-weight:400;">Viajes</h1>
    </div>
    
     <%for (ViajesBean obj: listaViajes ) {%>
         <div class="form-row my-3  ">
             
             
    <div class="col divContainer d-flex form-row  ">
        <div class="divContainer d-flex  my-auto " style=" box-shadow:0px 0px 0px 0px lightblue; border-radius:  3px;  ">
              <label for="formGroupExampleInput" class="my-auto badge badge-light" >De:</label>
              <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="<%=obj.getLugarSalida()%>">
        
        </div>
        <div class="divContainer d-flex  my-auto " style=" box-shadow:0px 0px 0px 0px lightblue; border-radius:  3px;  ">
              <label for="formGroupExampleInput" class="my-auto badge badge-light">A:</label>
                      <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="<%=obj.getLugarDestino()%>">
        
        </div>
    </div>
                      <div class="col divContainer d-flex form-row  ">
                      
                <div class="divContainer d-flex  my-auto " style=" box-shadow:0px 0px 0px 0px lightblue; border-radius:  3px;  ">
              <label for="formGroupExampleInput" class=" my-auto float-right badge badge-light">Fecha: </label>
                      <input type="text" readonly class="form-control-plaintext " id="staticEmail" value="<%=obj.getFecha()%>">
        
        </div>
                  
                      <div class="divContainer d-flex   my-auto  "style=" box-shadow:0px 0px 0px 0px lightblue; border-radius:  3px;  "  >
                                        <label for="formGroupExampleInput" class="my-auto float-right badge badge-light">Costo: </label>

<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="S/ <%=obj.getPrecio()%>">

                    </div>

                    <div class="d-flex   my-auto "  >
<h6> <span class="badge badge-secondary" ><%=obj.getNumVendidos()%>/<%=obj.getNumAsientos()%></span></h6>

                    </div>
                      </div>
      
  
             
<button type="button" onclick="Reservar('<%=request.getContextPath()%>/ServletPrincipal','<%=obj.getIdViaje()%>','<%=obj.getMatricula()%>','<%=session.getAttribute("idEmpleado")%>','<%=obj.getNumVendidos()%>','<%=obj.getNumAsientos()%>','<%=session.getAttribute("empleadonombre")%>','<%=obj.getLugarSalida()%>','<%=obj.getLugarDestino()%>','<%=obj.getPrecio()%>')" class="btn btn-dark btn-sm float-right">Reservar</button>

  </div>
         
         <%}%>
    
</div>
      </div>
        </form>
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

         <script src="js/Principal.js" type="text/javascript"></script>
      </body>
  </html>
