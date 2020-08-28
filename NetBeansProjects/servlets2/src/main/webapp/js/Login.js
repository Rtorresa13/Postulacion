 function Ingreso(ruta){
window.document.login.action=ruta;
      window.document.login.method="GET";
      window.document.login.op.value="1";
      
      window.document.login.submit();
}
