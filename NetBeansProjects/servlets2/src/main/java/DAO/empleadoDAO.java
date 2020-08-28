/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import java.util.ArrayList;
import BEAN.EmpleadoBean;
import Util.ConnectionBD;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author rody_
 */
public class empleadoDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    EmpleadoBean objEmpleado= new EmpleadoBean();
    ArrayList<EmpleadoBean> lista=null;
  public ArrayList ListarEmpleados()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT empleados.idEmpleado,empleados.nombre, empleados.sexo,empleados.dni,empleados.direccion, cargos.nomCargo,telefono.telefono from empleados inner JOIN telefono on empleados.idEmpleado=telefono.idEmpleado INNER JOIN cargos on empleados.idcargo=cargos.idCargo WHERE contrato ='si' ORDER by idEmpleado");
     rs=pt.executeQuery();
     lista=new ArrayList<EmpleadoBean>();
     while(rs.next()){
     objEmpleado= new EmpleadoBean();
      objEmpleado.setIdEmpleado(rs.getInt("IdEmpleado"));
     objEmpleado.setNombre(rs.getString("nombre"));
        objEmpleado.setDni(rs.getInt("dni"));
     objEmpleado.setDireccion(rs.getString("direccion"));
          objEmpleado.setNomCargo(rs.getString("nomCargo"));
     objEmpleado.setTelefono(rs.getInt("telefono"));
     objEmpleado.setSexo(rs.getString("sexo"));
     
     lista.add(objEmpleado);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null, "error");
     }
  
  
  return lista;}
   
   public ArrayList ListarEmpleados1()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT idEmpleado from empleados");
     rs=pt.executeQuery();
     lista=new ArrayList<EmpleadoBean>();
     while(rs.next()){
     objEmpleado= new EmpleadoBean();
      objEmpleado.setIdEmpleado(rs.getInt("IdEmpleado"));
     
     
     lista.add(objEmpleado);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }
  
  
  return lista;}
  
  
  
  
  
  
  
    public void EliminarEmpleado(EmpleadoBean objEmpleadoBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE empleados set contrato='no' where idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
    }
    public void EliminarTelefono(EmpleadoBean objEmpleadoBean){
    try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE telefono set disponible ='no' where idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
    
    
    
    }
       public void EliminarLogin(EmpleadoBean objEmpleadoBean){
   try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE login set disponible ='no' where idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
   }
    public void AgregarEmpleado(EmpleadoBean objEmpleadoBean){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `empleados`(`idEmpleado`, `nombre`, `dni`, `direccion`, `idCargo`, `sexo`, `contrato`) VALUES (?,?,?,?,?,?,?)");
         pt.setInt(1, objEmpleadoBean.getIdEmpleado());
            pt.setString(2,objEmpleadoBean.getNombre());
           pt.setInt(3,objEmpleadoBean.getDni());
           pt.setString(4,objEmpleadoBean.getDireccion());
           pt.setInt(5,objEmpleadoBean.getIdCargo());
           pt.setString(6,objEmpleadoBean.getSexo());
           pt.setString(7,objEmpleadoBean.getContrato());
           
           
         
            pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null, "error");}
    
    }
    
    
    
   public void AgregarTelefono(EmpleadoBean objEmpleadoBean){
   try{
   cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO telefono(idEmpleado,telefono,disponible) \n" +
"  VALUES (?,?,'si')");
            
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.setInt(2,objEmpleadoBean.getTelefono());
           
            pt.executeUpdate();
            pt.close();
            cn.close();
   
   }catch(Exception e){JOptionPane.showMessageDialog(null,"Error telefono");
   
   
   }
   
   }
   

   public void AgregarLogin(EmpleadoBean objEmpleadoBean){
   try{
   cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO login(idEmpleado,usuario,clave,disponible) \n" +
"  VALUES (?,?,?,'si')");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.setString(2,objEmpleadoBean.getUsuario());
            pt.setString(3,objEmpleadoBean.getClave());
           
            pt.executeUpdate();
            pt.close();
            cn.close();
   
   }catch(Exception e){JOptionPane.showMessageDialog(null,"Error login");
   
   
   }
   
   
   }
   public int ValidarEmpleado(EmpleadoBean objEmpleadoBean){
        int val=0;
        try {
            
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("select empleados.nombre, login.usuario, login.clave FROM empleados INNER JOIN login on login.idEmpleado=empleados.idEmpleado WHERE login.usuario=? and login.clave =? and login.disponible='si'");
            pt.setString(1, objEmpleadoBean.getUsuario());
            pt.setString(2, objEmpleadoBean.getClave());
            rs=pt.executeQuery();
            if(rs.next())
            {
                val= val+1;
                objEmpleado.setNombre(rs.getString("nombre"));
                objEmpleado.setUsuario(rs.getString("usuario"));
                objEmpleado.setClave(rs.getString("clave"));
            }
            if (val==1) {
                return 1;
            }else{
            return 0;}
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
         return 0;   
        }
        
        }
     public String NombreEmpleado(EmpleadoBean objEmpleadoBean){
                String nombre="";

         try {
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("select empleados.nombre, login.usuario, login.clave FROM empleados INNER JOIN login on login.idEmpleado=empleados.idEmpleado WHERE login.usuario=? and login.clave =?");
            pt.setString(1, objEmpleadoBean.getUsuario());
            pt.setString(2, objEmpleadoBean.getClave());
            rs=pt.executeQuery();
            if(rs.next())
            {
               
               nombre = (rs.getString("nombre"));
                objEmpleado.setUsuario(rs.getString("usuario"));
                objEmpleado.setClave(rs.getString("clave"));
            
            }
       
            
            
        } catch (Exception e) {
            
        }
        
        return nombre ;}
     
          public String idEmpleado(EmpleadoBean objEmpleadoBean){
                String id="";

         try {
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("select empleados.idEmpleado ,empleados.nombre, login.usuario, login.clave FROM empleados INNER JOIN login on login.idEmpleado=empleados.idEmpleado WHERE login.usuario=? and login.clave =?");
            pt.setString(1, objEmpleadoBean.getUsuario());
            pt.setString(2, objEmpleadoBean.getClave());
            rs=pt.executeQuery();
            if(rs.next())
            {
               
               id = (rs.getString("idEmpleado"));
                objEmpleado.setUsuario(rs.getString("usuario"));
                objEmpleado.setClave(rs.getString("clave"));
            
            }
       
            
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
            
        }
        
        return id ;}
               public String Cargo(EmpleadoBean objEmpleadoBean){
                String cargo="";

         try {
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT empleados.idEmpleado,cargos.nomCargo FROM empleados INNER JOIN cargos on empleados.idCargo = cargos.idCargo WHERE idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
         
            rs=pt.executeQuery();
            if(rs.next())
            {
               
               cargo = (rs.getString("nomCargo"));
            
            }
       
            
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
            
        }
        
        return cargo ;}
       public void ModificarEmpleado(EmpleadoBean objEmpleadoBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE `empleados` SET `nombre`=?,`dni`=?,`direccion`=?,`idCargo`=?,`sexo`=? WHERE idEmpleado=?");
            pt.setString(1,objEmpleadoBean.getNombre());
            pt.setInt(2,objEmpleadoBean.getDni());
            pt.setString(3,objEmpleadoBean.getDireccion());
            pt.setInt(4,objEmpleadoBean.getIdCargo());
            pt.setString(5,objEmpleadoBean.getSexo());
            
            pt.setInt(6,objEmpleadoBean.getIdEmpleado());
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ModificarTelefono(EmpleadoBean objEmpleadoBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE telefono SET telefono=? WHERE idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getTelefono());
            pt.setInt(2,objEmpleadoBean.getIdEmpleado() );
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {
        }
    }
     public void ModificarClave(EmpleadoBean objEmpleadoBean,String clave){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE login set clave="+clave+"  where idEmpleado=?");
            pt.setInt(1,objEmpleadoBean.getIdEmpleado());
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
        }
    }
        public ArrayList FiltrarEmpleados(String opcion, String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("SELECT empleados.idEmpleado,empleados.nombre, empleados.sexo,empleados.dni,empleados.direccion, cargos.nomCargo,telefono.telefono from empleados inner JOIN telefono on empleados.idEmpleado=telefono.idEmpleado INNER JOIN cargos on empleados.idcargo=cargos.idCargo WHERE contrato ='si' ORDER BY CASE WHEN empleados."+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
     rs=pt.executeQuery();
     lista=new ArrayList<EmpleadoBean>();
     while(rs.next()){
     objEmpleado= new EmpleadoBean();
      objEmpleado.setIdEmpleado(rs.getInt("IdEmpleado"));
     objEmpleado.setNombre(rs.getString("nombre"));
        objEmpleado.setDni(rs.getInt("dni"));
     objEmpleado.setDireccion(rs.getString("direccion"));
          objEmpleado.setNomCargo(rs.getString("nomCargo"));
     objEmpleado.setTelefono(rs.getInt("telefono"));
     objEmpleado.setSexo(rs.getString("sexo"));
     
     lista.add(objEmpleado);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null, e);
     }
  
  
  return lista;}
    
    }
    
    

