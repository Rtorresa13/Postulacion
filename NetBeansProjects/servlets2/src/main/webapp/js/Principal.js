function Registrar(ruta)
  {
             
                window.document.Principal.action=ruta;
                window.document.Principal.method="GET";
                window.document.Principal.op.value="5";
                window.document.Principal.submit();
            }
  function Reservar(ruta,codigo,matricula,idEmpleado,numVendidos,numAsientos,nomEmpleado,lugarSalida,lugarDestino,precio)
  {
      
      

            window.document.Principal.action=ruta;
          window.document.Principal.method="GET";
          window.document.Principal.codigo.value=codigo;
          window.document.Principal.matricula.value=matricula;
          window.document.Principal.idEmpleado.value=idEmpleado;
          window.document.Principal.numVendidos.value=numVendidos;
          window.document.Principal.numAsientos.value=numAsientos;
          window.document.Principal.nomEmpleado.value=nomEmpleado;
          window.document.Principal.lugarSalida.value=lugarSalida;
          window.document.Principal.lugarDestino.value=lugarDestino;
          window.document.Principal.precio.value=precio;
          window.document.Principal.submit();
  }