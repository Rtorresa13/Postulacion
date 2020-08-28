package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BEAN.BusesBean;
import BEAN.ClientesBean;
import BEAN.EmpleadoBean;
import BEAN.ViajesBean;
import DAO.BusesDAO;
import DAO.ClientesDAO;
import DAO.ViajesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.empleadoDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            String opcad=request.getParameter("op");
            int op =Integer.parseInt(opcad);
           
            
           switch(op) {
               case 1:{
            String usuario = new String(request.getParameter("usuario").getBytes("ISO-8859-1"), "UTF-8");
                    String clave = new String(request.getParameter("clave").getBytes("ISO-8859-1"), "UTF-8");
              String errorUser = "Ingrese Usuario";
                    String errorClave ="Ingrese Clave";
                       
                   if (usuario.length()==0 && clave.length()==0) {
                       request.setAttribute("errorUser", errorUser);
                      request.setAttribute("errorClave",errorClave);
                      
                 getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

                   }
                   if (usuario.length()==0 && clave.length()>0) {
 
                       request.setAttribute("errorUser", errorUser);
                       request.setAttribute("user",usuario);

                 getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                      
                   }if (usuario.length()>0 && clave.length()==0) {
                       request.setAttribute("user",usuario);

                       request.setAttribute("errorClave", errorClave);
                 getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                      
                   }
                   
                    
                    empleadoDAO objEmpleadoDAO = new empleadoDAO();
                    EmpleadoBean objEmpleadoBean = new EmpleadoBean();
              
                    objEmpleadoBean.setUsuario(usuario);
                    objEmpleadoBean.setClave(clave);


                 



                    
                    
                 
                                        int valido = objEmpleadoDAO.ValidarEmpleado(objEmpleadoBean);
                    if (valido == 0) {
                        String mensaje = "Las credenciales no son correctas.";
                      
                        request.setAttribute("mensaje", mensaje);
                        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    } else {
                           String nombre= objEmpleadoDAO.NombreEmpleado(objEmpleadoBean);

                    String idEmpleado = objEmpleadoDAO.idEmpleado(objEmpleadoBean);
                                      int id = Integer.parseInt(idEmpleado);
                                       objEmpleadoBean.setIdEmpleado(id);
                                 String cargo = objEmpleadoDAO.Cargo(objEmpleadoBean);

                   
               HttpSession EmpleadoSesion =request.getSession(true);
               
               EmpleadoSesion.setAttribute("empleadonombre",nombre);
               EmpleadoSesion.setAttribute("idEmpleado",idEmpleado);
               EmpleadoSesion.setAttribute("cargo", cargo);
               EmpleadoSesion.setAttribute("clave", clave);
               
  ClientesDAO cliente = new ClientesDAO();
  BusesDAO buses = new BusesDAO();
 ArrayList<BusesBean> listaBuses= buses.ListarBuses();
  
  ArrayList<ClientesBean> listaClientes= cliente.ListarClientes(); 
                            ViajesDAO viaje = new ViajesDAO();
                      ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
                        
                             request.setAttribute("listaClientes", listaClientes);
                                                   request.setAttribute("listaViajes",listaViajes);
                                                   request.setAttribute("listaBuses",listaBuses);

                                                   
                                                   
                                                   
                             getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);
                    }
               
               break;}
               
               case 2:{
                     ClientesDAO cliente = new ClientesDAO();
                        ArrayList<ClientesBean> listaClientes= cliente.ListarClientes(); 
                        
                        ViajesDAO viaje = new ViajesDAO();
                      ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
                        
                        
                        
                             request.setAttribute("listaClientes", listaClientes);
                             request.setAttribute("listaViajes",listaViajes);
               
                                       getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

              
               
               
               
               break;}
               case 3:{
               HttpSession sesion =request.getSession(); 
               sesion.invalidate();
               
                          getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

              
               }
               
               
               
               
        }
    
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
