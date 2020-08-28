/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ClientesBean;
import BEAN.VentasBean;
import BEAN.ViajesBean;
import Util.ConnectionBD;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
 
public class VentasDAO {
    
          Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    VentasBean objVenta= new VentasBean();
    ArrayList<VentasBean> lista=null;
    public void AgregarVenta(VentasBean objVentaBean){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `venta`(`idVenta`, `idCliente`, `idViaje`, `idEmpleado`, `fecha`,`cantidad`,`precioTotal`) VALUES (?,?,?,?,?,?,?)");
         pt.setInt(1, objVentaBean.getIdVenta());
         pt.setInt(2, objVentaBean.getIdCliente());
         pt.setInt(3, objVentaBean.getIdViaje());
         pt.setInt(4, objVentaBean.getIdEmpleado());       
         pt.setString(5, objVentaBean.getFecha());
                pt.setInt(6, objVentaBean.getCantidad());
                pt.setDouble(7, objVentaBean.getPrecioTotal());

            pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
    }
     public ArrayList ListarVenta()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from venta");
     rs=pt.executeQuery();
     lista=new ArrayList<VentasBean>();
     while(rs.next()){
     objVenta= new VentasBean();
     
      objVenta.setIdVenta(rs.getInt("idVenta"));

      objVenta.setIdCliente(rs.getInt("idCliente"));

      objVenta.setIdViaje(rs.getInt("idViaje"));

      objVenta.setIdEmpleado(rs.getInt("idEmpleado"));

      objVenta.setFecha(rs.getString("fecha"));
      objVenta.setCantidad(rs.getInt("cantidad"));
            objVenta.setPrecioTotal(rs.getDouble("precioTotal"));


        
     lista.add(objVenta);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
     
     
           public void DeshabilitarViaje(ViajesBean objViajeBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE viaje set disponibilidad=0 where idViaje=?");
            
            pt.setInt(1,objViajeBean.getIdViaje());
       
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e+"VentaDAO");
        }
    }
                public String NombreCliente(ClientesBean objClienteBean){
                String nombre="";

         try {
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("select idCliente,nombre from clientes where idCliente=?");
            pt.setInt(1, objClienteBean.getIdCliente());
            rs=pt.executeQuery();
            if(rs.next())
            { nombre = (rs.getString("nombre"));
             
            }
       
            
            
        } catch (Exception e) {
            
        }
        
        return nombre ;}
       public ArrayList ListarVentas()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from vistaventas");
     rs=pt.executeQuery();
     lista=new ArrayList<VentasBean>();
     while(rs.next()){
     objVenta= new VentasBean();
     
      objVenta.setIdVenta(rs.getInt("idVenta"));

      objVenta.setCliente(rs.getString("nombre"));

      objVenta.setLugarSalida(rs.getString("lugarSalida"));

      objVenta.setLugarDestino(rs.getString("lugarDestino"));
      objVenta.setMatricula(rs.getString("matricula"));

      objVenta.setNomEmpleado(rs.getString("nomEmpleado"));
      
      objVenta.setPrecio(rs.getDouble("precio"));

      objVenta.setFecha(rs.getString("fecha"));
            objVenta.setCantidad(rs.getInt("cantidad"));
            objVenta.setPrecioTotal(rs.getDouble("precioTotal"));

        
     lista.add(objVenta);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
          public ArrayList FiltrarVentas(String opcion, String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("select `venta`.`idVenta` AS `idVenta`,`clientes`.`nombre` AS `nombre`,`viaje`.`lugarSalida` AS `lugarSalida`,`viaje`.`lugarDestino` AS `lugarDestino`,`autobuses`.`matricula` AS `matricula`,`empleados`.`nombre` AS `nomEmpleado`,`viaje`.`precio` AS `precio`,`venta`.`fecha` AS `fecha`,`venta`.`cantidad` AS `cantidad`,`venta`.`precioTotal` AS `precioTotal` from ((((`venta` join `clientes` on(`clientes`.`idCliente` = `venta`.`idCliente`)) join `viaje` on(`viaje`.`idViaje` = `venta`.`idViaje`)) join `autobuses` on(`viaje`.`idViaje` = `autobuses`.`idBus`)) join `empleados` on(`empleados`.`idEmpleado` = `venta`.`idEmpleado`)) ORDER BY CASE WHEN venta."+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
     rs=pt.executeQuery();
     lista=new ArrayList<VentasBean>();
     while(rs.next()){
     objVenta= new VentasBean();
     
      objVenta.setIdVenta(rs.getInt("idVenta"));

      objVenta.setCliente(rs.getString("nombre"));

      objVenta.setLugarSalida(rs.getString("lugarSalida"));

      objVenta.setLugarDestino(rs.getString("lugarDestino"));
      objVenta.setMatricula(rs.getString("matricula"));

      objVenta.setNomEmpleado(rs.getString("nomEmpleado"));
      
      objVenta.setPrecio(rs.getDouble("precio"));

      objVenta.setFecha(rs.getString("fecha"));
            objVenta.setCantidad(rs.getInt("cantidad"));
            objVenta.setPrecioTotal(rs.getDouble("precioTotal"));

        
     lista.add(objVenta);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
                   public ArrayList FiltrarVentasEmpleado(String opcion, String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("select `venta`.`idVenta` AS `idVenta`,`clientes`.`nombre` AS `nombre`,`viaje`.`lugarSalida` AS `lugarSalida`,`viaje`.`lugarDestino` AS `lugarDestino`,`autobuses`.`matricula` AS `matricula`,`empleados`.`nombre` AS `nomEmpleado`,`viaje`.`precio` AS `precio`,`venta`.`fecha` AS `fecha`,`venta`.`cantidad` AS `cantidad`,`venta`.`precioTotal` AS `precioTotal` from ((((`venta` join `clientes` on(`clientes`.`idCliente` = `venta`.`idCliente`)) join `viaje` on(`viaje`.`idViaje` = `venta`.`idViaje`)) join `autobuses` on(`viaje`.`idViaje` = `autobuses`.`idBus`)) join `empleados` on(`empleados`.`idEmpleado` = `venta`.`idEmpleado`)) ORDER BY CASE WHEN empleados."+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
     rs=pt.executeQuery();
     lista=new ArrayList<VentasBean>();
     while(rs.next()){
     objVenta= new VentasBean();
     
      objVenta.setIdVenta(rs.getInt("idVenta"));

      objVenta.setCliente(rs.getString("nombre"));

      objVenta.setLugarSalida(rs.getString("lugarSalida"));

      objVenta.setLugarDestino(rs.getString("lugarDestino"));
      objVenta.setMatricula(rs.getString("matricula"));

      objVenta.setNomEmpleado(rs.getString("nomEmpleado"));
      
      objVenta.setPrecio(rs.getDouble("precio"));

      objVenta.setFecha(rs.getString("fecha"));
            objVenta.setCantidad(rs.getInt("cantidad"));
            objVenta.setPrecioTotal(rs.getDouble("precioTotal"));

        
     lista.add(objVenta);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}         public ArrayList FiltrarVentasCliente(String opcion, String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("select `venta`.`idVenta` AS `idVenta`,`clientes`.`nombre` AS `nombre`,`viaje`.`lugarSalida` AS `lugarSalida`,`viaje`.`lugarDestino` AS `lugarDestino`,`autobuses`.`matricula` AS `matricula`,`empleados`.`nombre` AS `nomEmpleado`,`viaje`.`precio` AS `precio`,`venta`.`fecha` AS `fecha`,`venta`.`cantidad` AS `cantidad`,`venta`.`precioTotal` AS `precioTotal` from ((((`venta` join `clientes` on(`clientes`.`idCliente` = `venta`.`idCliente`)) join `viaje` on(`viaje`.`idViaje` = `venta`.`idViaje`)) join `autobuses` on(`viaje`.`idViaje` = `autobuses`.`idBus`)) join `empleados` on(`empleados`.`idEmpleado` = `venta`.`idEmpleado`)) ORDER BY CASE WHEN clientes."+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
     rs=pt.executeQuery();
     lista=new ArrayList<VentasBean>();
     while(rs.next()){
     objVenta= new VentasBean();
     
      objVenta.setIdVenta(rs.getInt("idVenta"));

      objVenta.setCliente(rs.getString("nombre"));

      objVenta.setLugarSalida(rs.getString("lugarSalida"));

      objVenta.setLugarDestino(rs.getString("lugarDestino"));
      objVenta.setMatricula(rs.getString("matricula"));

      objVenta.setNomEmpleado(rs.getString("nomEmpleado"));
      
      objVenta.setPrecio(rs.getDouble("precio"));

      objVenta.setFecha(rs.getString("fecha"));
            objVenta.setCantidad(rs.getInt("cantidad"));
            objVenta.setPrecioTotal(rs.getDouble("precioTotal"));

        
     lista.add(objVenta);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
    
}
