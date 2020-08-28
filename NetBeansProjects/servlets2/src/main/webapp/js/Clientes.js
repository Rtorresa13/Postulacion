function  modificar(ruta,codigo,nombre,dni,sexo)
{
  window.document.ListadoClientes.action=ruta;
    window.document.ListadoClientes.method="GET";
    window.document.ListadoClientes.op.value="3";
    window.document.ListadoClientes.codigo.value=codigo;
    window.document.ListadoClientes.nombre.value=nombre;
    window.document.ListadoClientes.dni.value=dni;
    window.document.ListadoClientes.sexo.value=sexo;
    window.document.ListadoClientes.submit();   
}
function  Eliminar(ruta,code)
{
    document.ListadoClientes.action=ruta;
    document.ListadoClientes.method="GET";
    document.ListadoClientes.op.value="2";
    document.ListadoClientes.codigo.value=code;
    document.ListadoClientes.submit();   
}
function actualizar(ruta){
 
    window.document.Clientes.action=ruta;
    window.document.Clientes.method="GET";
    window.document.Clientes.op.value="4";
    window.document.Clientes.submit();   
  
    
}  
