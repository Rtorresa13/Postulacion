  function Registrar(ruta){
                  
                window.document.bus.action=ruta;
                window.document.bus.method="GET";
                window.document.bus.op.value="2";
                window.document.bus.submit();
                
            }
 function  Eliminar(ruta,codigo)
{
    window.document.ListadoBus.action=ruta;
    window.document.ListadoBus.method="GET";
    window.document.ListadoBus.op.value="3";
    window.document.ListadoBus.codigo.value=codigo;
    window.document.ListadoBus.submit();   
    
    
}function IrFrmBus(ruta){
    
    window.document.ListadoBus.action=ruta;
    window.document.ListadoBus.method="GET";
    window.document.ListadoBus.op.value="5";
    window.document.ListadoBus.submit();    
    
}

function Editar(ruta,codigo,matricula,asientos){

    window.document.ListadoBus.action=ruta;
    window.document.ListadoBus.method="GET";
    window.document.ListadoBus.op.value="6";
    window.document.ListadoBus.codigo.value=codigo;
    document.ListadoBus.matricula.value=matricula;
    document.ListadoBus.asientos.value=asientos;
    
    window.document.ListadoBus.submit();     
    
}
function actualizar(ruta){
 
    window.document.bus.action=ruta;
    window.document.bus.method="GET";
    window.document.bus.op.value="7";
    window.document.bus.submit();   
  
    
}