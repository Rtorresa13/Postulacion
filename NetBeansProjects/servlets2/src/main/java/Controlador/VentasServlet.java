/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.VentasDAO;
import BEAN.VentasBean;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author rody_
 */
public class VentasServlet extends HttpServlet {

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

            switch (op){
                
                case 1:{
            VentasDAO objVentaDAO = new VentasDAO();
            
           ArrayList lista = objVentaDAO.ListarVentas();
           
           request.setAttribute("lista",lista);
            
        getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                
                
              break;  }
                
                case 2:{
                
                
              String codigo= request.getParameter("codigo");
              String nombre= request.getParameter("nombre");
              String lugarSalida= request.getParameter("lugarSalida");
              String lugarDestino= request.getParameter("lugarDestino");
              String matricula= request.getParameter("matricula");
                 String nomEmpleado= request.getParameter("nomEmpleado");
              String precio= request.getParameter("precio");
              String fecha= request.getParameter("fecha");
              String cantidad= request.getParameter("cantidad");
              String precioTotal= request.getParameter("precioTotal");
              request.setAttribute("numventa",codigo);
              request.setAttribute("cliente",nombre);
              request.setAttribute("lugarSalida",lugarSalida);
              request.setAttribute("lugarDestino",lugarDestino);
              request.setAttribute("matricula",matricula);
             request.setAttribute("vendedor",nomEmpleado);
              request.setAttribute("precio",precio);
              request.setAttribute("fecha",fecha);
              request.setAttribute("cantidad",cantidad);
              request.setAttribute("precioTotal",precioTotal);
              
       
 
                
                
                        getServletContext().getRequestDispatcher("/FrmBoleta.jsp").forward(request, response);               

                break;
                
                }
                case 3:{
                
                //FILTRANDO VENTAS
            String opcion = request.getParameter("cboOpcion");
            String criterio=request.getParameter("criterio");
            
            VentasDAO objVentasDAO= new VentasDAO();
            
            int opCriterio= Integer.parseInt(opcion);
            switch (opCriterio){
                case 0:{
       request.setAttribute ("error","Caracter invalido");
       ArrayList lista= objVentasDAO.ListarVentas();
                  
                request.setAttribute("lista", lista);
            
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                      
                
                break;}
                case 1:{
                                  if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objVentasDAO.ListarVentas();
                  
                request.setAttribute("lista", lista);
            
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                        
                     break;}
           ArrayList lista= objVentasDAO.FiltrarVentas("idVenta", criterio);
           request.setAttribute("lista", lista);
                    
         
           
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                            
                break;}
                case 2:{
                           if (criterio.matches("[0-9]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objVentasDAO.ListarVentas();
                  
                request.setAttribute("lista", lista);
            
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                        
                     break;}
                    
              ArrayList lista= objVentasDAO.FiltrarVentasEmpleado("nombre", criterio);
           request.setAttribute("lista", lista);
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
            break;
                }
                case 3:{
                     if (criterio.matches("[0-9]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objVentasDAO.ListarVentas();
                  
                request.setAttribute("lista", lista);
            
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
                        
                     break;}
                  ArrayList lista= objVentasDAO.FiltrarVentasCliente("nombre", criterio);
                  
           request.setAttribute("lista", lista);
          getServletContext().getRequestDispatcher("/FrmListadoVentas.jsp").forward(request, response);               
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
