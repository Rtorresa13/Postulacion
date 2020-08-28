function irBoleta(ruta,codigo,nombre,lugarSalida,lugarDestino,matricula,nomEmpleado,precio,fecha,cantidad,precioTotal)
{
    
                window.document.ventas.action=ruta;
                window.document.ventas.method="POST";
                window.document.ventas.op.value="2";
                window.document.ventas.codigo=codigo;
                window.document.ventas.nombre=nombre;
                window.document.ventas.lugarSalida=lugarSalida;
                window.document.ventas.lugarDestino=lugarDestino;
                window.document.ventas.matricula=matricula;
                window.document.ventas.nomEmpleado=nomEmpleado;
                window.document.ventas.precio=precio;
                window.document.ventas.fecha=fecha;
                window.document.ventas.cantidad=cantidad;
                window.document.ventas.precioTotal=precioTotal;
                window.document.ventas.submit();
}