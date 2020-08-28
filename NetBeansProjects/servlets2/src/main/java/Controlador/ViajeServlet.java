/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.ViajesBean;
import DAO.BusesDAO;
import DAO.ViajesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rody_
 */
public class ViajeServlet extends HttpServlet {

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
          int op=Integer.parseInt(opcad);
              
          
          switch (op){
              //LISTANDO VIAJES
              case 1:{
              ViajesDAO viaje = new ViajesDAO();
        ArrayList<ViajesBean> lista=viaje.ListarViajes();
        request.setAttribute("lista",lista);
        
        getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);
          
        
        break;}
            
              case 3:{
              //ELIMINAR VIAJES
              String codigo= new String(request.getParameter("codigo").getBytes("ISO-8859-1"), "UTF-8");
      
              
              int cod=Integer.parseInt(codigo);
              
                            ViajesDAO objViajesDAO = new ViajesDAO();
                           ViajesBean objViajesBean = new ViajesBean();
                           objViajesBean.setIdViaje(cod);
                           
                            objViajesDAO.EliminarViaje(objViajesBean);
                          
                            ArrayList lista = objViajesDAO.ListarViajes();
                            
                            
                            request.setAttribute("lista", lista);
                          
                            getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
              break;    }
          case 2:{
                  //AGREGAR VIAJE
                  
                  
                  
                  String LugarSalida= new String(request.getParameter("txtLugarSalida").getBytes("ISO-8859-1"), "UTF-8");
                           
                  String LugarDestino = new String(request.getParameter("txtLugarDestino").getBytes("ISO-8859-1"), "UTF-8");
                        
                       
                       String Precio= new String(request.getParameter("txtPrecio").getBytes("ISO-8859-1"), "UTF-8");
                  
                       String cboBus=new String(request.getParameter("cboBus").getBytes("ISO-8859-1"), "UTF-8");
                       String year=new String(request.getParameter("year").getBytes("ISO-8859-1"), "UTF-8");
                       String dia=new String(request.getParameter("dia").getBytes("ISO-8859-1"), "UTF-8");
                       String mes=new String(request.getParameter("mes").getBytes("ISO-8859-1"), "UTF-8");
                       
                       String fecha=year+"/"+mes+"/"+dia;
                       
                       String errorSalida="Ingrese lugar de salida";
                       String errorDestino="Ingrese lugar de Destino";
                       String errorPrecio="Ingrese precio";
                       String errorBus="Seleccione el autobus";
                       String errorYear="Seleccione el año";
                       String errorDia="Seleccione el dia";
                       String errorMes="Seleccione el mes";                       
                      BusesDAO objBusesDAO = new BusesDAO();

                       if (LugarSalida.length()==0) {
                request.setAttribute("errorSalida", errorSalida);
         
           ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
                getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
              break;}
                       if (LugarDestino.length()==0) {
                           
                request.setAttribute("errorDestino", errorDestino);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;}if (Precio.length()==0) {
                request.setAttribute("errorPrecio", errorPrecio);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;}
                      if (cboBus.equals("0")) {
                          
                request.setAttribute("errorBus", errorBus);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;} if (year.equals("0")) {
                request.setAttribute("errorYear", errorYear);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;} if (mes.equals("0")) {
                request.setAttribute("errorMes", errorMes);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;}if (dia.equals("0")) {
                request.setAttribute("errorDia", errorDia);
                   ArrayList lista1 = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista1);
         getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                  
              break;} else{ 
                      
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       
                       Double precio =Double.parseDouble(Precio);
                         int bus= Integer.parseInt(cboBus);
                          ViajesDAO objViajesDAO = new ViajesDAO();
                             ArrayList lista = objViajesDAO.ListarViajes1();
                             
                             int cod=lista.size();
                             ViajesBean objViajesBean = new ViajesBean();
                            
                            objViajesBean.setIdViaje(cod+1);
       
                            objViajesBean.setDisponibilidad("1");
                            objViajesBean.setIdBus(bus);
                            objViajesBean.setLugarSalida(LugarSalida); 
                            objViajesBean.setLugarDestino(LugarDestino);
                            objViajesBean.setPrecio(precio);
                            objViajesBean.setNumVendidos(0);
                           objViajesBean.setFecha(fecha);
                            objViajesDAO.AgregarViaje(objViajesBean);
                           
                            
           ArrayList lista1 = objBusesDAO.ListarMatriculas();
           
              request.setAttribute("listaMatricula", lista1);
                            
                            
                            getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
                           
                break;} }
          
          case 4:{
          
              String codigo=request.getParameter("codigo");
              String salida=request.getParameter("salida");
              String destino=request.getParameter("destino");
              String bus=request.getParameter("bus");
              String asientos=request.getParameter("asientos");
              String fecha=request.getParameter("fecha");
              String idBus=request.getParameter("idbus");
String precio=request.getParameter("precio");

              request.setAttribute("codigo", codigo);          
              request.setAttribute("salida", salida);          
              request.setAttribute("destino",destino);          
              request.setAttribute("bus", bus);
              request.setAttribute("asientos",asientos);
              request.setAttribute("fecha",fecha);
              request.setAttribute("idbus",idBus);
               request.setAttribute("precio",precio);
             
              
              
                BusesDAO objBusesDAO = new BusesDAO();
           ArrayList lista1 = objBusesDAO.ListarMatriculas();
           
              request.setAttribute("lista", lista1);
          
          getServletContext().getRequestDispatcher("/FrmModificarViajes.jsp").forward(request, response);

          break;}
          
          case 5:
          {

              BusesDAO objBusesDAO = new BusesDAO();
           ArrayList lista = objBusesDAO.ListarMatriculas();
              request.setAttribute("listaMatricula", lista);
              
getServletContext().getRequestDispatcher("/FrmViajes.jsp").forward(request, response);
          break;}
          
          case 6:
          {
          
                      String codigo= request.getParameter("codigo");
                    int cod = Integer.parseInt(codigo);
                    String LugarSalida= request.getParameter("txtLugarSalida");
                    String LugarDestino= request.getParameter("txtLugarDestino");
                    String bus= request.getParameter("cboBus");
                    String year= request.getParameter("year");
                    String dia= request.getParameter("dia");
                    String mes= request.getParameter("mes");
                       String fecha=year+"/"+mes+"/"+dia;
                    String precio= request.getParameter("txtPrecio");
                    String asientos = request.getParameter("asientos");
                 int asiento = Integer.parseInt(asientos);
                 int   bus1 = Integer.parseInt(bus);
                 double precio1 = Double.parseDouble(precio);
          
                 
                 
                 
                 
                 ViajesBean objViajesBean = new ViajesBean();
                      objViajesBean.setIdViaje(cod);
                    objViajesBean.setLugarSalida(LugarSalida);
                  objViajesBean.setLugarDestino(LugarDestino);
                  objViajesBean.setIdBus(bus1);
                  objViajesBean.setFecha(fecha);
                  objViajesBean.setPrecio(precio1);
                  objViajesBean.setNumVendidos(asiento);
                    
                   
                ViajesDAO objViajesDao = new ViajesDAO();
                 
                objViajesDao.ModificarViaje(objViajesBean);
           
                ArrayList<ViajesBean> lista=objViajesDao.ListarViajes();
        request.setAttribute("lista",lista);
        
        getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);        

          
          
          
          
          
          
         break; }
          case 7:{
          
                //FILTRANDO VIAJES
            String opcion = request.getParameter("cboOpcion");
            String criterio=request.getParameter("criterio");
            
            ViajesDAO objViajesDAO= new ViajesDAO();
            
            int opCriterio= Integer.parseInt(opcion);
            switch (opCriterio){
                case 0:{
                                         request.setAttribute ("error","Caracter invalido");
       ArrayList lista= objViajesDAO.ListarViajes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
                      
                
                break;}
                case 1:{
                 if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objViajesDAO.ListarViajes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
                        
                     break;}
                 
                 
           ArrayList lista= objViajesDAO.FiltrarViajes("idViaje", criterio);
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
                            
                break;}
                case 2:{
                           if ( criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objViajesDAO.ListarViajes();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
                        
                     break;}
                    
              ArrayList lista= objViajesDAO.FiltrarViajes("matricula", criterio);
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
            break;
                }
                case 3:{
                     if (criterio.matches("[a-zA-Z]+")||criterio.length()==0 ) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objViajesDAO.ListarViajes();
                request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
                        
                     break;}
                  ArrayList lista= objViajesDAO.FiltrarViajes("precio", criterio);
                  
           request.setAttribute("lista", lista);
                     getServletContext().getRequestDispatcher("/FrmListadoViajes.jsp").forward(request, response);               
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
