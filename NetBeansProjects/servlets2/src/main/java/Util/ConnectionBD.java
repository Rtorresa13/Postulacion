/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.*;


/**
 *
 * @author rody_
 */
public class ConnectionBD {

   
   public static Connection getConexionBD(){
    Connection cn=null;
        try{
  
            Class.forName("com.mysql.jdbc.Driver");
          // cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/bdtransporte","root","");
               cn=DriverManager.getConnection("jdbc:mysql://node1175-env-7822199.usermia-j.elasticserver.co:3306/bdtransporte","root","gG1Z5s2JHm");

            System.out.println("Conectado");
        
        }
        
        
        catch(Exception e){
        
            System.out.println("No conectado");
    
    }
  return cn; }
    public static void main(String[] args) {
    getConexionBD();
    }
    
}
