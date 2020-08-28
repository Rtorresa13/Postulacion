/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ViajesBean;
import Util.ConnectionBD;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rody_
 */
public class ViajesDAO {
      Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ViajesBean objViaje= new ViajesBean();
    ArrayList<ViajesBean> lista=null;
    public ArrayList ListarViajes()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from vistaviajes order by idViaje");
     rs=pt.executeQuery();
     lista=new ArrayList<ViajesBean>();
     while(rs.next()){
     objViaje= new ViajesBean();
      objViaje.setIdViaje(rs.getInt("idViaje"));
       objViaje.setDisponibilidad(rs.getString("disponibilidad"));
        objViaje.setLugarSalida(rs.getString("lugarSalida"));
        objViaje.setLugarDestino(rs.getString("lugarDestino"));
        objViaje.setMatricula(rs.getString("matricula"));
        objViaje.setIdBus(rs.getInt("idBus"));
        objViaje.setNumAsientos(rs.getInt("numAsientos"));
        
        objViaje.setNumVendidos(rs.getInt("numVendidos"));
        objViaje.setFecha(rs.getString("fecha"));
        objViaje.setPrecio(rs.getDouble("precio"));
        
        
     lista.add(objViaje);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
       public ArrayList FiltrarViajes(String opcion,String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("select `viaje`.`idViaje` AS `idViaje`,`disponibilidad`(`viaje`.`disponibilidad`) AS `disponibilidad`,`viaje`.`lugarSalida` AS `lugarSalida`,`viaje`.`lugarDestino` AS `lugarDestino`,`autobuses`.`matricula` AS `matricula`,`viaje`.`idBus` AS `idBus`,`autobuses`.`numAsientos` AS `numAsientos`,`viaje`.`numVendidos` AS `numVendidos`,`viaje`.`fecha` AS `fecha`,`viaje`.`precio` AS `precio` from (`viaje` join `autobuses` on(`autobuses`.`idBus` = `viaje`.`idBus`)) where `viaje`.`disponibilidad` = '1' ORDER BY CASE WHEN "+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
    rs=pt.executeQuery();
     lista=new ArrayList<ViajesBean>();
     while(rs.next()){
     objViaje= new ViajesBean();
      objViaje.setIdViaje(rs.getInt("idViaje"));
       objViaje.setDisponibilidad(rs.getString("disponibilidad"));
        objViaje.setLugarSalida(rs.getString("lugarSalida"));
        objViaje.setLugarDestino(rs.getString("lugarDestino"));
        objViaje.setMatricula(rs.getString("matricula"));
        objViaje.setIdBus(rs.getInt("idBus"));
        objViaje.setNumAsientos(rs.getInt("numAsientos"));
        
        objViaje.setNumVendidos(rs.getInt("numVendidos"));
        objViaje.setFecha(rs.getString("fecha"));
        objViaje.setPrecio(rs.getDouble("precio"));
        
        
     lista.add(objViaje);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
    
    
    public ArrayList ListarViajes1()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select idViaje from viaje");
     rs=pt.executeQuery();
     lista=new ArrayList<ViajesBean>();
     while(rs.next()){
     objViaje= new ViajesBean();
      objViaje.setIdViaje(rs.getInt("idViaje"));

        
     lista.add(objViaje);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
     public void NuevoViaje(ViajesBean objViajeBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE viaje set numVendidos=? where idViaje=?");
        
            pt.setInt(1,objViajeBean.getNumVendidos());
            
            pt.setInt(2,objViajeBean.getIdViaje());
       
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "error"+ e);
        }
    }
    
    
    
    
       public ArrayList ListarDestinos()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT DISTINCT lugarDestino FROM viaje");
     rs=pt.executeQuery();
     lista=new ArrayList<ViajesBean>();
     while(rs.next()){
     objViaje= new ViajesBean();
     objViaje.setLugarDestino(rs.getString("lugarDestino"));
     lista.add(objViaje);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
       
    public ArrayList ListarSalidas()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT DISTINCT lugarSalida FROM viaje");
     rs=pt.executeQuery();
     lista=new ArrayList<ViajesBean>();
     while(rs.next()){
     objViaje= new ViajesBean();
     objViaje.setLugarSalida(rs.getString("lugarSalida"));
     lista.add(objViaje);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
    
    public void AgregarViaje(ViajesBean objViajesBean){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `viaje`(`idViaje`, `disponibilidad`, `lugarSalida`, `lugarDestino`, `idBus`, `numVendidos`, `precio`, `fecha`) VALUES (?,?,?,?,?,?,?,?)");
            pt.setInt(1,objViajesBean.getIdViaje());
            pt.setString(2,objViajesBean.getDisponibilidad());
            pt.setString(3,objViajesBean.getLugarSalida());
            pt.setString(4,objViajesBean.getLugarDestino());
            pt.setInt(5,objViajesBean.getIdBus());
            pt.setInt(6,objViajesBean.getNumVendidos());
            pt.setDouble(7,objViajesBean.getPrecio());
            pt.setString(8,objViajesBean.getFecha());
          
            pt.executeUpdate();
            pt.close();
            cn.close();
    
    
    }catch(Exception e){JOptionPane.showMessageDialog(null,"Error AgregarViajeDAO");}
    
    }
    
  public void EliminarViaje(ViajesBean objViajesBean){  
        try { 

            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE viaje SET disponibilidad=0 WHERE idViaje=?   ");
          pt.setInt(1, objViajesBean.getIdViaje());
            pt.executeUpdate();
            pt.close();
            cn.close();
                                

            
        } catch (Exception e) {JOptionPane.showMessageDialog(null,"Error eliminarviajeDAO");
        }
    }
    public void ModificarViaje(ViajesBean objViajesBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE `viaje` SET `disponibilidad`='1',`lugarSalida`=?,`lugarDestino`=?,`idBus`=?,`numVendidos`=?,`precio`=?,`fecha`=? WHERE idViaje=?");
            pt.setString(1,objViajesBean.getLugarSalida());
            pt.setString(2,objViajesBean.getLugarDestino());
            pt.setInt(3,objViajesBean.getIdBus());
            pt.setInt(4,objViajesBean.getNumVendidos());
            pt.setDouble(5,objViajesBean.getPrecio());
            pt.setString(6,objViajesBean.getFecha());
            pt.setInt(7,objViajesBean.getIdViaje());
           
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
        }
    }

   
    }
    
    
    

