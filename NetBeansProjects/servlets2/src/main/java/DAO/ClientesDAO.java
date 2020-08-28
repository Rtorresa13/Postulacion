/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import BEAN.ClientesBean;
import java.sql.*;
import java.util.ArrayList;
import Util.ConnectionBD;
import javax.swing.JOptionPane;
public class ClientesDAO {
     Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ClientesBean objClientes= new ClientesBean();
    ArrayList<ClientesBean> lista=null;

public ArrayList ListarClientes()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from clientes where eliminado='no'");
     rs=pt.executeQuery();
     lista=new ArrayList<ClientesBean>();
     while(rs.next()){
     objClientes= new ClientesBean();
      objClientes.setIdCliente(rs.getInt("IdCliente"));
     objClientes.setNombre(rs.getString("nombre"));
     objClientes.setSexo(rs.getString("sexo"));
     objClientes.setDni(rs.getInt("dni"));
     objClientes.setEliminado(rs.getString("eliminado"));
     
     lista.add(objClientes);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }

return lista;}
public ArrayList FiltrarClientes(String opcion,String criterio)
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select * from clientes where eliminado='no' ORDER BY CASE WHEN "+opcion+" LIKE '%"+criterio+"%' THEN 1 ELSE 2 END");
     rs=pt.executeQuery();
     lista=new ArrayList<ClientesBean>();
     while(rs.next()){
     objClientes= new ClientesBean();
      objClientes.setIdCliente(rs.getInt("IdCliente"));
     objClientes.setNombre(rs.getString("nombre"));
     objClientes.setSexo(rs.getString("sexo"));
     objClientes.setDni(rs.getInt("dni"));
     objClientes.setEliminado(rs.getString("eliminado"));
     
     lista.add(objClientes);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){JOptionPane.showMessageDialog(null,e);
     }

return lista;}

public ArrayList ListarClientes1()
  {
     try{
     cn=ConnectionBD.getConexionBD();
     pt=cn.prepareStatement("Select idCliente from clientes ");
     rs=pt.executeQuery();
     lista=new ArrayList<ClientesBean>();
     while(rs.next()){
     objClientes= new ClientesBean();
      objClientes.setIdCliente(rs.getInt("IdCliente"));

     
     lista.add(objClientes);
     }
     pt.close();
     rs.close();
     cn.close();
     }
     catch(Exception e){
     }

return lista;}


  public void EliminarCliente(int codigo){  
        try { 

            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE clientes SET eliminado='si' WHERE idCliente="+codigo+"   ");
          
            pt.executeUpdate();
            pt.close();
            cn.close();
                                

            
        } catch (Exception e) {
        }
    }
  public void ModificarClientes(ClientesBean objClientesBean){  
        try { 
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("UPDATE `clientes` SET `nombre`=?,`sexo`=?,`dni`=? WHERE idCliente = ?");
            pt.setString(1,objClientesBean.getNombre());
            pt.setString(2,objClientesBean.getSexo());
            pt.setInt(3,objClientesBean.getDni());
            pt.setInt(4,objClientesBean.getIdCliente());
            
           
            
            pt.executeUpdate();
            pt.close();
            cn.close();
        } catch (Exception e) {JOptionPane.showMessageDialog(null, "Error al modificar clientes");
        }
    }
  
   public void AgregarClientes(ClientesBean objClientesBean){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `clientes`(`idCliente`, `nombre`, `sexo`, `dni`, `eliminado`) VALUES (?,?,?,?,'no')");
         pt.setInt(1, objClientesBean.getIdCliente());
            pt.setString(2,objClientesBean.getNombre());
            pt.setString(3,objClientesBean.getSexo());
     
           pt.setInt(4,objClientesBean.getDni());
        
           
           
         
            pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    
    }

}