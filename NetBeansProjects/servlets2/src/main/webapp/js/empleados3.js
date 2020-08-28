

  function Registrar(ruta)
  {
      
 
                window.document.empleados.action=ruta;
                window.document.empleados.method="POST";
                window.document.empleados.op.value="2";
                window.document.empleados.enctype="multipart/form-data";
                
                window.document.empleados.submit();
  }
            
function  Eliminar(ruta,code)
{
    document.ListadoEmpleados.action=ruta;
    document.ListadoEmpleados.method="GET";
    document.ListadoEmpleados.op.value="3";
    document.ListadoEmpleados.codigo.value=code;
    document.ListadoEmpleados.submit();   
    
    
}


function IrFrmEmpleado(ruta){
    
    window.document.ListadoEmpleados.action=ruta;
    window.document.ListadoEmpleados.method="GET";
    window.document.ListadoEmpleados.op.value="5";
    window.document.ListadoEmpleados.submit();   
}
function  modificar(ruta,codigo,nombre,dni,direccion,idCargo,telefono,sexo)
{
  window.document.ListadoEmpleados.action=ruta;
    window.document.ListadoEmpleados.method="GET";
    window.document.ListadoEmpleados.op.value="4";
    window.document.ListadoEmpleados.codigo.value=codigo;
    window.document.ListadoEmpleados.nombre.value=nombre;
    window.document.ListadoEmpleados.dni.value=dni;
    window.document.ListadoEmpleados.direccion.value=direccion;
    window.document.ListadoEmpleados.idCargo.value=idCargo;
    window.document.ListadoEmpleados.telefono.value=telefono;
    window.document.ListadoEmpleados.sexo.value=sexo;

    window.document.ListadoEmpleados.submit();   
}


function Cambiar(ruta){
 
    window.document.clave.action=ruta;
    window.document.clave.method="GET";
    window.document.clave.op.value="8";
    window.document.clave.submit();   
  
    
}
function Filtrar(ruta){
 
    window.document.ListadoEmpleados.action=ruta;
    window.document.ListadoEmpleados.method="GET";
    window.document.ListadoEmpleados.op.value="9";
    window.document.ListadoEmpleados.submit();   
  
    
}
