      function  Eliminar(ruta,code)
{
    window.document.ListadoViaje.action=ruta;
    window.document.ListadoViaje.method="GET";
        window.document.ListadoViaje.codigo.value=code;

    window.document.ListadoViaje.op.value="3";
    window.document.ListadoViaje.submit();   
    
    
}
  function Registrar(ruta){
                  
                window.document.Viajes.action=ruta;
                window.document.Viajes.method="GET";
                window.document.Viajes.op.value="2";
                window.document.Viajes.submit();
                
            }
function IrFrmViaje(ruta){
    
    window.document.ListadoViaje.action=ruta;
    window.document.ListadoViaje.method="GET";
    window.document.ListadoViaje.op.value="5";
    window.document.ListadoViaje.submit();   
    
    
    
    
}
function Modificar(ruta, codigo, salida, destino, bus, asientos, fecha, idbus, precio) {

    window.document.ListadoViaje.action = ruta;
    window.document.ListadoViaje.method = "GET";
    window.document.ListadoViaje.op.value = "4";
    window.document.ListadoViaje.codigo.value = codigo;
    window.document.ListadoViaje.salida.value = salida;
    window.document.ListadoViaje.destino.value = destino;
    window.document.ListadoViaje.bus.value = bus;
    window.document.ListadoViaje.asientos.value = asientos;
    window.document.ListadoViaje.fecha.value = fecha;
    window.document.ListadoViaje.idbus.value = idbus;
    window.document.ListadoViaje.precio.value = precio;
    window.document.ListadoViaje.submit();

}
function actualizar(ruta){
 
    window.document.Viajes.action=ruta;
    window.document.Viajes.method="GET";
window.document.Viajes.op.value="6";
    window.document.Viajes.submit();   
  
    
}