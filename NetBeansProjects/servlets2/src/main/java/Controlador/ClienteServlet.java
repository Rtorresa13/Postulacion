/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.BusesBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import BEAN.ClientesBean;
import BEAN.ViajesBean;
import DAO.BusesDAO;
import DAO.ClientesDAO;
import DAO.ViajesDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author rody_
 */
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String opcad=request.getParameter("op");
            int op = Integer.parseInt(opcad);
            switch(op){
                case 1 :{
                      //LISTAR CLIENTES

                      ClientesDAO objClienteDAO = new ClientesDAO();
                      ArrayList lista = objClienteDAO.ListarClientes();
                      request.setAttribute("lista", lista);
                      getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
break;
                }
                case 2:{
                    
                        String codigo= new String(request.getParameter("codigo").getBytes("ISO-8859-1"), "UTF-8");
                    
                        int cod = Integer.parseInt(codigo);
                       ClientesBean objClientesBean = new ClientesBean();
                      
                       objClientesBean.setIdCliente(cod);
                          
                       ClientesDAO objClientesDAO = new ClientesDAO();
                          
                       objClientesDAO.EliminarCliente(cod);

                        ArrayList lista = objClientesDAO.ListarClientes();
                          request.setAttribute("lista", lista);
                        
                 getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
            break;
                }
                case 3:{
                //MODIFICAR
                
                
                String codigo= request.getParameter("codigo");
                  String nombre= request.getParameter("nombre");
                      String sexo= request.getParameter("sexo");
                      String dni= request.getParameter("dni");
                
                request.setAttribute("codigo", codigo);
                request.setAttribute("nombre", nombre);
                request.setAttribute("sexo",sexo);
                request.setAttribute("dni", dni);
                
                      
                 getServletContext().getRequestDispatcher("/FrmModificarClientes.jsp").forward(request, response);               
break ;
               }
                case 4:{
                 String codigo= request.getParameter("txtCodigo");
                    int cod = Integer.parseInt(codigo);
                    String nombre= request.getParameter("txtNombre");
                    String dni= request.getParameter("txtDni");
                    String sexo= request.getParameter("cboSexo");
                  String errorNombre = "Ingrese nombre";
                    String errorDni = "Ingrese DNI";

                    

                    if (nombre.length() == 0) {
                       request.setAttribute("codigo", codigo);
                request.setAttribute("nombre", nombre);
                request.setAttribute("sexo",sexo);
                request.setAttribute("dni", dni);
                                                request.setAttribute("errorNombre", errorNombre);

                      getServletContext().getRequestDispatcher("/FrmModificarClientes.jsp").forward(request, response);
        break; }

          
                    if (dni.length() == 0) {
                                request.setAttribute("codigo", codigo);
                request.setAttribute("nombre", nombre);
                request.setAttribute("sexo",sexo);
                request.setAttribute("dni", dni);
                        request.setAttribute("errorDni", errorDni);
                        
                      getServletContext().getRequestDispatcher("/FrmModificarClientes.jsp").forward(request, response);
                        break;}
                    
                    
                    
                    int dn=Integer.parseInt(dni);
                    
                    
                    
                    ClientesBean objClientesBean = new ClientesBean();
                      objClientesBean.setIdCliente(cod);
                    objClientesBean.setNombre(nombre);
                  objClientesBean.setSexo(sexo);
                  
                    objClientesBean.setDni(dn);
                    
                   
                ClientesDAO objClientesDao = new ClientesDAO();
                 
                objClientesDao.ModificarClientes(objClientesBean);
           
                ArrayList<ClientesBean> lista=objClientesDao.ListarClientes();
        request.setAttribute("lista",lista);
        
        getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);        

                
                
                
                break;
                
                }
                case 5:{
                    String nombre= request.getParameter("txtNombre");
                    String dni= request.getParameter("txtDni");
                    String sexo= request.getParameter("cboSexo");
                    String errorNombre = "Ingrese nombre";
                    String errorDni = "Ingrese DNI";
                    String errorSexo = "Seleccione sexo";
                    ClientesDAO cliente = new ClientesDAO();
                    ViajesDAO viaje = new ViajesDAO();

                    if (nombre.length() == 0) {
                        request.setAttribute("errorNombre", errorNombre);

                        ArrayList<ClientesBean> listaClientes = cliente.ListarClientes();

                        ArrayList<ViajesBean> listaViajes = viaje.ListarViajes();

                        request.setAttribute("listaClientes", listaClientes);
                        request.setAttribute("listaViajes", listaViajes);

                        getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

                        break;
                    }

                    if (sexo.equals("0")) {

                        request.setAttribute("errorSexo", errorSexo);

                        ArrayList<ClientesBean> listaClientes = cliente.ListarClientes();

                        ArrayList<ViajesBean> listaViajes = viaje.ListarViajes();

                        request.setAttribute("listaClientes", listaClientes);
                        request.setAttribute("listaViajes", listaViajes);

                        getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

                        break;
                    }
                    if (dni.length() == 0) {
                        request.setAttribute("errorDni", errorDni);

                        ArrayList<ClientesBean> listaClientes = cliente.ListarClientes();

                        ArrayList<ViajesBean> listaViajes = viaje.ListarViajes();

                        request.setAttribute("listaClientes", listaClientes);
                        request.setAttribute("listaViajes", listaViajes);

                        getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

                        break;
                    }
                                        int dn=Integer.parseInt(dni);


                    ArrayList lista= cliente.ListarClientes1();
                                  int cod = lista.size();
                    ClientesBean objClienteBean = new ClientesBean();
                    objClienteBean.setIdCliente(cod+1);
                    objClienteBean.setNombre(nombre);
                    objClienteBean.setDni(dn);
                    objClienteBean.setSexo(sexo);
                    
                    
                    
                    cliente.AgregarClientes(objClienteBean);
                    
                        ArrayList<ClientesBean> listaClientes= cliente.ListarClientes(); 
                        
                      ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
                        
                        
                        
                             request.setAttribute("listaClientes", listaClientes);
                             request.setAttribute("listaViajes",listaViajes);
               
                                       getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);


                    
                    break;}
                case 6:{
                
                //FILTRANDO EMPLEADOS
            String opcion = request.getParameter("cboOpcion");
            String criterio=request.getParameter("criterio");
            
            ClientesDAO objClienteDAO= new ClientesDAO();
            
            int opCriterio= Integer.parseInt(opcion);
            switch (opCriterio){
                case 0:{
                                         request.setAttribute ("error","Caracter invalido");
       ArrayList lista= objClienteDAO.ListarClientes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                      
                
                break;}
                case 1:{
                                  if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objClienteDAO.ListarClientes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                        
                     break;}
           ArrayList lista= objClienteDAO.FiltrarClientes("dni", criterio);
           request.setAttribute("lista", lista);
                    
         
           
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                            
                break;}
                case 2:{
                           if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objClienteDAO.ListarClientes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                        
                     break;}
                    
              ArrayList lista= objClienteDAO.FiltrarClientes("idCliente", criterio);
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
            break;
                }
                case 3:{
                     if (criterio.matches("[0-9]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objClienteDAO.ListarClientes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                        
                     break;}
                  ArrayList lista= objClienteDAO.FiltrarClientes("nombre", criterio);
                  
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoClientes.jsp").forward(request, response);               
                        break;
                }
            }
                
                break;}
                
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
