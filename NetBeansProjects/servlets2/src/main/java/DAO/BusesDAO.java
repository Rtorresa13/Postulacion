/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import java.util.ArrayList;
import BEAN.BusesBean;
import Util.ConnectionBD;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rody_
 */
public class BusesDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    BusesBean objBus= new BusesBean();
    ArrayList<BusesBean> lista=null;
    
 public ArrayList ListarBuses()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from autobuses where disponibilidad='1' ");
     rs=pt.executeQuery();
     lista=new ArrayList<BusesBean>();
     while(rs.next()){
     objBus= new BusesBean();
      objBus.setIdBus(rs.getInt("idBus"));
objBus.setNumAsientos(rs.getInt("numAsientos"));
        objBus.setMatricula(rs.getString("matricula"));
        objBus.setDisponibilidad(rs.getString("disponibilidad"));
  
     lista.add(objBus);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
 public ArrayList ListarBuses1()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select idBus from autobuses ");
     rs=pt.executeQuery();
     lista=new ArrayList<BusesBean>();
     while(rs.next()){
     objBus= new BusesBean();
      objBus.setIdBus(rs.getInt("idBus"));

  
     lista.add(objBus);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
 public void AgregarBus(BusesBean objBusesBean){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `autobuses`(`idBus`, `numAsientos`, `matricula`, `disponibilidad`) VALUES (?,?,?,?)");
            pt.setInt(1,objBusesBean.getIdBus());
            pt.setInt(2,objBusesBean.getNumAsientos());

            pt.setString(3,objBusesBean.getMatricula());
            pt.setString(4,objBusesBean.getDisponibilidad());
          
            pt.executeUpdate();
            pt.close();
            cn.close();
    
    
    }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    
    }
 
   public void EliminarBus(BusesBean objBusesBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE autobuses SET disponibilidad='0' WHERE idBus=?");
            pt.setInt(1,objBusesBean.getIdBus());
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) { }
    }
    
        public ArrayList ListarMatriculas()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT idBus,matricula FROM autobuses where disponibilidad = '1'");
     rs=pt.executeQuery();
     lista=new ArrayList<BusesBean>();
     while(rs.next()){
     objBus= new BusesBean();
     objBus.setIdBus(rs.getInt("idBus"));
     objBus.setMatricula(rs.getString("matricula"));
     lista.add(objBus);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){ JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
           public void ModificarBus(BusesBean objBusesBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE `autobuses` SET `numAsientos`=?,`matricula`=?,`disponibilidad`=? WHERE idBus = ?");
            pt.setInt(1,objBusesBean.getNumAsientos());
            pt.setString(2,objBusesBean.getMatricula());
            pt.setString(3,objBusesBean.getDisponibilidad());
            pt.setInt(4,objBusesBean.getIdBus());
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
    }
           
        public ArrayList ListarModificacion()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from autobuses where idBus=?");
    pt.setInt(1,objBus.getIdBus());
     rs=pt.executeQuery();
     lista=new ArrayList<BusesBean>();
     while(rs.next()){
     objBus= new BusesBean();
      objBus.setIdBus(rs.getInt("idBus"));
objBus.setNumAsientos(rs.getInt("numAsientos"));
        objBus.setMatricula(rs.getString("matricula"));
        objBus.setDisponibilidad(rs.getString("disponibilidad"));
  
     lista.add(objBus);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}    
        
         public ArrayList FiltrarBuses(String opcion, String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from autobuses where disponibilidad='1' ORDER BY CASE WHEN "+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");

     rs=pt.executeQuery();
     lista=new ArrayList<BusesBean>();
     while(rs.next()){
     objBus= new BusesBean();
      objBus.setIdBus(rs.getInt("idBus"));
objBus.setNumAsientos(rs.getInt("numAsientos"));
        objBus.setMatricula(rs.getString("matricula"));
        objBus.setDisponibilidad(rs.getString("disponibilidad"));
  
     lista.add(objBus);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null,e);
     }
  
  
  return lista;}
        
           
    
}
