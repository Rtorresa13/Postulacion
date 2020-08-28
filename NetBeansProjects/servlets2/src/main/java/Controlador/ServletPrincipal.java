/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BEAN.ClientesBean;
import BEAN.VentasBean;
import BEAN.ViajesBean;
import DAO.ClientesDAO;
import DAO.VentasDAO;
import DAO.ViajesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author rody_
 */
public class ServletPrincipal extends HttpServlet {

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
            
            String codCliente = request.getParameter("cboCliente");
            String codViaje = request.getParameter("codigo");
            String codEmpleado = request.getParameter("idEmpleado");
            String numVendidos=request.getParameter("numVendidos");
            String numAsientos=request.getParameter("numAsientos");
            String cantidad=request.getParameter("txtCantidad");
            String nomEmpleado = request.getParameter("nomEmpleado");
            String matricula = request.getParameter("matricula");
            String lugarSalida = request.getParameter("lugarSalida");
            String lugarDestino = request.getParameter("lugarDestino");
            String precio = request.getParameter("precio");
String errorCliente ="Seleccione Cliente";
String errorCantidad="Ingrese la cantidad";
              ClientesDAO cliente = new ClientesDAO();
              ViajesDAO viaje = new ViajesDAO();
             
            if (codCliente.equals("0") ) {
                request.setAttribute("errorCliente",errorCliente);    
                ArrayList<ClientesBean> listaClientes= cliente.ListarClientes();         
            ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaViajes",listaViajes);
                        
              getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

               }else if (cantidad.length()==0) {
                         request.setAttribute("errorCantidad",errorCantidad);    
                ArrayList<ClientesBean> listaClientes= cliente.ListarClientes();         
            ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaViajes",listaViajes);
                        
              getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

            }else      if (Integer.parseInt(cantidad)+Integer.parseInt(numVendidos)>50) {
                    
                    String errorBoleto="Boletos insuficientes";
                    
              ArrayList<ClientesBean> listaClientes= cliente.ListarClientes();         
            ArrayList<ViajesBean> listaViajes =  viaje.ListarViajes();
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaViajes",listaViajes);
                request.setAttribute("errorBoleto",errorBoleto);
                        
              getServletContext().getRequestDispatcher("/FrmPrincipal.jsp").forward(request, response);

                    
                 }else{
            
            
            


             double precioParcial = Double.parseDouble(precio);
            int cantida =Integer.parseInt(cantidad);
            
            int numVendido=Integer.parseInt(numVendidos);
            
           
            int numAsiento = Integer.parseInt(numAsientos);
            int idCliente= Integer.parseInt(codCliente);
            
            int idViaje= Integer.parseInt(codViaje);
            
            int idEmpleado= Integer.parseInt(codEmpleado);
            double precioTotal=precioParcial*cantida;
            String total = String.valueOf(precioTotal);
            
                Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
    String fecha = formateador.format(ahora);
            VentasBean objVentasBean = new VentasBean();
    
            VentasDAO objVentasDAO = new VentasDAO();
           ClientesBean objClienteBean = new ClientesBean();
           objClienteBean.setIdCliente(idCliente);
           
          String nombreCliente  =objVentasDAO.NombreCliente(objClienteBean);
            
            ArrayList lista = objVentasDAO.ListarVenta();
            int cod = lista.size();
            objVentasBean.setIdVenta(cod+1);
      
            objVentasBean.setIdCliente(idCliente);
            
            objVentasBean.setIdEmpleado(idEmpleado);
            objVentasBean.setIdViaje(idViaje);
            objVentasBean.setCantidad(cantida);
            objVentasBean.setPrecioTotal(precioTotal);

            objVentasBean.setFecha(fecha);

            objVentasDAO.AgregarVenta(objVentasBean);
            
            ViajesBean objViajeBean = new ViajesBean();
            

            objViajeBean.setNumVendidos(numVendido+cantida);
            objViajeBean.setIdViaje(idViaje);

            viaje.NuevoViaje(objViajeBean);
 
            
            int num = objViajeBean.getNumVendidos();
            
            
            
            if (num == numAsiento) {
              objVentasDAO.DeshabilitarViaje(objViajeBean);
            }
            String codventa =String.valueOf(cod+1);
            String cantidaad = String.valueOf(cantida);
            request.setAttribute("numventa",codventa);
            request.setAttribute("fecha",fecha);
            request.setAttribute("cliente",nombreCliente);
            request.setAttribute("vendedor",nomEmpleado);
            request.setAttribute("lugarSalida",lugarSalida);
            request.setAttribute("lugarDestino",lugarDestino);
            request.setAttribute("matricula",matricula);
            request.setAttribute("precioTotal", total);
            request.setAttribute("cantidad",cantidaad);   
         
   
                            getServletContext().getRequestDispatcher("/FrmBoleta.jsp").forward(request, response);               

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
