/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.BusesBean;
import DAO.BusesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BusesServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
             String opcad=request.getParameter("op");
            int op=Integer.parseInt(opcad);
            switch (op){   
                case 1:{  
                    
            BusesDAO buses= new BusesDAO();
        ArrayList<BusesBean> lista= buses.ListarBuses();
        
        request.setAttribute("lista",lista);
       
        getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);
        
        
            break;
                }
                case 2: {

                    String matricula = new String(request.getParameter("txtMatricula").getBytes("ISO-8859-1"), "UTF-8");
                    String asientos = new String(request.getParameter("txtnumAsientos").getBytes("ISO-8859-1"), "UTF-8");

                    String errorMatricula="Ingrese la matricula";
                    String errorAsientos="Ingrese el numero de asientos";
                    if (matricula.length()==0) {
                    request.setAttribute("errorMatricula", errorMatricula);
                        getServletContext().getRequestDispatcher("/FrmBuses.jsp").forward(request, response);

                    break;}else if(asientos.length()==0){
                    
                    request.setAttribute("errorAsientos", errorAsientos);
                        getServletContext().getRequestDispatcher("/FrmBuses.jsp").forward(request, response);

                    break;}else{
                    
                    int asiento = Integer.parseInt(asientos);

                    BusesDAO objBusesDAO = new BusesDAO();
                    ArrayList lista = objBusesDAO.ListarBuses1();
                    int cod = lista.size();
                    BusesBean objBusesBean = new BusesBean();
                    objBusesBean.setIdBus(cod + 1);
                    objBusesBean.setMatricula(matricula);
                    objBusesBean.setNumAsientos(asiento);
                    objBusesBean.setDisponibilidad("1");

                    objBusesDAO.AgregarBus(objBusesBean);

                            getServletContext().getRequestDispatcher("/FrmBuses.jsp").forward(request, response);
                    }      
                break;}
                case 3:
                {
                
                String codigo= new String(request.getParameter("codigo").getBytes("ISO-8859-1"), "UTF-8");
      
       
                          
              
                            int cod = Integer.parseInt(codigo);
                            
                            BusesBean objBusesBean = new BusesBean();
                            objBusesBean.setIdBus(cod);
                            BusesDAO objBusesDAO = new BusesDAO();
                            objBusesDAO.EliminarBus(objBusesBean);
                          
                            ArrayList lista = objBusesDAO.ListarBuses();
                            request.setAttribute("lista", lista);
                          
                            getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
          
                
                
                
                
                break;}
                
                case 4:{
                    
                   String matricula = new String(request.getParameter("txtMatricula").getBytes("ISO-8859-1"), "UTF-8");
                   String asientos = new String(request.getParameter("txtnumAsientos").getBytes("ISO-8859-1"), "UTF-8");
                   String disponibilidad = new String(request.getParameter("disponibilidad").getBytes("ISO-8859-1"), "UTF-8");
                   String   idBus = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
                   int id = Integer.parseInt(idBus);
                   int numAsientos=Integer.parseInt(asientos);
                   BusesBean objBusesBean = new BusesBean();
                
                objBusesBean.setDisponibilidad(disponibilidad);
                objBusesBean.setMatricula(matricula);
                objBusesBean.setNumAsientos(numAsientos);
                objBusesBean.setIdBus(id);
                BusesDAO objBusesDAO = new BusesDAO();
                objBusesDAO.ModificarBus(objBusesBean);
               
                getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               

                
                break;}
                case 5:{
               
                     
                     getServletContext().getRequestDispatcher("/FrmBuses.jsp").forward(request, response);               
          
                
                
                break;}
                case 6:{
                String codigo=request.getParameter("codigo");
                String matricula=request.getParameter("matricula");
                String asientos=request.getParameter("asientos");
                
                request.setAttribute("codigo", codigo);
                
                request.setAttribute("matricula", matricula);
                
                request.setAttribute("asientos", asientos);
                
                getServletContext().getRequestDispatcher("/FrmModificarBuses.jsp").forward(request, response);               

             break;   }
                case 7:{
                
                String codigo= request.getParameter("txtCodigo");
                    int cod = Integer.parseInt(codigo);
                    String matricula= request.getParameter("txtMatricula");
                    String asientos= request.getParameter("txtnumAsientos");
                    
                    String errorMatricula="Ingrese la matricula";
                    String errorAsientos="Ingrese el numero de asientos";
                    if (matricula.length()==0) {
                    request.setAttribute("errorMatricula", errorMatricula);
                             request.setAttribute("codigo", codigo);
                
                request.setAttribute("matricula", matricula);
                
                request.setAttribute("asientos", asientos);
                        getServletContext().getRequestDispatcher("/FrmModificarBuses.jsp").forward(request, response);

                    break;}else if(asientos.length()==0){
                                 request.setAttribute("codigo", codigo);
                
                request.setAttribute("matricula", matricula);
                
                request.setAttribute("asientos", asientos);
                    
                    request.setAttribute("errorAsientos", errorAsientos);
                        getServletContext().getRequestDispatcher("/FrmModificarBuses.jsp").forward(request, response);

                    break;}
                    
                int asiento =Integer.parseInt(asientos);
                
                    BusesDAO buses = new BusesDAO();
                    
                    BusesBean objbuses= new BusesBean();
                    
                    objbuses.setIdBus(cod);
                    objbuses.setMatricula(matricula);
                    objbuses.setNumAsientos(asiento);
                   objbuses.setDisponibilidad("1");
                    buses.ModificarBus(objbuses);
                    ArrayList lista = buses.ListarBuses();
                            request.setAttribute("lista", lista);
                          
                            getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
          
                
                
getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               

                    
                break;}
                case 8:{
                
                //FILTRANDO BUSES
            String opcion = request.getParameter("cboOpcion");
            String criterio=request.getParameter("criterio");
            
            BusesDAO objBusDAO = new BusesDAO();
            int opCriterio= Integer.parseInt(opcion);
            switch (opCriterio){
                case 0:{
                                         request.setAttribute ("error","Caracter invalido");
       ArrayList lista= objBusDAO.ListarBuses();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
                      
                
                break;}
                case 1:{
                    if ( criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objBusDAO.ListarBuses();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
                        
                     break;}
                    
           ArrayList lista= objBusDAO.FiltrarBuses("matricula", criterio);
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
                            
                break;}
                
                
                
                case 2:{
                           if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objBusDAO.ListarBuses();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
                        
                     break;}
                    
              ArrayList lista= objBusDAO.FiltrarBuses("idBus", criterio);
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoBuses.jsp").forward(request, response);               
            break;
                }
          
            }
                break;} 
            
            
        }}
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
