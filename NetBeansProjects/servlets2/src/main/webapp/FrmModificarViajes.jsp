<%-- 
    Document   : FrmPrincipal
    Created on : 1 jun. 2020, 19:25:39
    Author     : rody_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BEAN.BusesBean"%>
<%@page import="java.util.ArrayList"%>
<%
  String codigo =(String) request.getAttribute("codigo") ;
 String salida=(String) request.getAttribute("salida") ;         
  String destino =(String)request.getAttribute("destino");          
 String bus = (String)request.getAttribute("bus");
 String asientos=(String) request.getAttribute("asientos");
 String fecha =(String) request.getAttribute("fecha");
String idBus=(String) request.getAttribute("idbus");
String precio=(String) request.getAttribute("precio");


String [] fecha1 = fecha.split("-");
String year= fecha1[0];
int mes= Integer.parseInt(fecha1[1]);
String dia= fecha1[2];
String mes1="";
switch(mes){
    case 1:{
mes1="Enero";
break;}
    case 2:{
mes1="Febrero";
break;}
    case 3:{
mes1="Marzo";
break;}
    case 4:{
mes1="Abril";
break;}
    case 5:{
mes1="Mayo";
break;}
    case 6:{
mes1="Junio";
break;}
    case 7:{
mes1="Julio";
break;}
    case 8:{
mes1="Agosto";
break;}
    case 9:{
mes1="Setiembre";
break;}
    case 10:{
mes1="Octubre";
break;}
    case 11:{
mes1="Noviembre";
break;}
    case 12:{
mes1="Diciembre";
break;}
    
}


%>
<%! BusesBean bus = null;
   
ArrayList<BusesBean> listaMatricula =null;

%> 

<%
listaMatricula=(ArrayList<BusesBean>)request.getAttribute("lista");
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
          <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
             <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
             <title>Viajes</title>
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
        <form name="Viajes" class="form-container col-md-4">
         <input type="hidden" name="op">

                <div class="divContainer d-flex justify-content-center">
         
                    <h1 class="display-4">Registrar Viajes</h1>

       </div> 
          
             <div class="form-group">
                 <label>Codigo</label>  
                 <input type="text" value ="<%=codigo%>" readonly="readonly" class="form-control" name="codigo">
              </div>
             <div class="form-group">
                 <label>Lugar Salida:</label>  
                 <input type="text" value ="<%=salida%>" class="form-control" name="txtLugarSalida">
              </div>
             
             <div class="form-group">
                    <label>Lugar Destino:</label>
                    <input type="text" value ="<%=destino%>" class="form-control" name="txtLugarDestino">  
             </div>
               <div class="form-group">
                 <label>Asientos:</label>  
                 <input type="text" value ="<%=asientos%>" class="form-control" name="asientos">
              </div>
             <div class="form-group">
                    <label>Precio:</label>
                    <input value="<%=precio%>" type="text" class="form-control" name="txtPrecio">  
             </div>
             <div class="form-group">
                    <label>Bus:</label>
            <select  name="cboBus" class="custom-select custom-select-lg mb-3">
                <option value="<%=idBus%>" style="background-color: lightblue" selected><%=bus%></option>
                
                <%for (BusesBean obj :listaMatricula){  %>
                
<option value="<%=obj.getIdBus()%>" ><%=obj.getMatricula()%></option>
            <%}%>
            </select>
            </div>
                                        <label>Fecha:</label>

            <div class="form-row">
                
    <div class="form-group col-md-2.5">
        

     <select id="inputState" name="mes" class="form-control">
         <option selected style="background-color: lightblue" value="<%=mes%>"><%=mes1%></option>
        <option value="1">Enero</option>
        <option value="2">Febrero</option>
        <option value="3">Marzo</option>
        <option value="4">Abril</option>
        <option value="5">Mayo</option>
        <option value="6">Junio</option>
        <option value="7">Julio</option>
        <option value="8">Agosto</option>
        <option value="9">Setiembre</option>
        <option value="10">Octubre</option>
        <option value="11">Noviembre</option>
        <option value="12">Diciembre</option>
    
 
     </select>
    </div>
                                <label style="font-size: 24px">/</label>

    <div class="form-group col-md-2.5">
   
      <select id="inputState" name="dia" class="form-control">
        <option selected style="background-color: lightblue"><%=dia%></option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
        <option>6</option>
        <option>7</option>
        <option>8</option>
        <option>9</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
        <option>22</option>
        <option>23</option>
        <option>24</option>
        <option>25</option>
        <option>26</option>
        <option>27</option>
        <option>28</option>
        <option>29</option>
        <option>30</option>
        <option>31</option>
      
      </select>
    </div>
                <label style="font-size: 24px">/</label>
                
    <div class="form-group col-md-2.5">
      <select id="inputState" name="year" class="form-control">
        <option selected style="background-color: lightblue"><%=year%></option>
        <option>2020</option>
        <option>2021</option>
        <option>2022</option>
        <option>2023</option>
        <option>2024</option>
        <option>2025</option>
        <option>2026</option>
        <option>2027</option>
        <option>2028</option>
        <option>2029</option>
      
      </select>
    </div>
  </div>
            
            
             
  <button class="btn btn-info btn-block" onclick="actualizar('<%=request.getContextPath()%>/ViajeServlet')"> MODIFICAR</button><br>

        </form>
   </div>
  <script src="js/Viaje.js" type="text/javascript"></script>
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
