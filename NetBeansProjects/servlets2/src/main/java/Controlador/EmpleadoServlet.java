
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.empleadoDAO;
import BEAN.EmpleadoBean;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.swing.JOptionPane;



@MultipartConfig

public class EmpleadoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
           String opcad=request.getParameter("op");
            int op=Integer.parseInt(opcad);
            switch (op)
            {
                case 1:{
//                LISTAR EMPLEADOS
                 empleadoDAO empleado = new empleadoDAO();
        ArrayList<EmpleadoBean> lista=empleado.ListarEmpleados();
        request.setAttribute("lista",lista);
        
        getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);

                
                break;}
               
                case 2:{
//                REGISTRAR EMPLEADOS
    
                            String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");
                            String dn = new String(request.getParameter("txtDni").getBytes("ISO-8859-1"), "UTF-8");
                            String direccion = new String(request.getParameter("txtDireccion").getBytes("ISO-8859-1"), "UTF-8");
                            String telefono = new String(request.getParameter("txtTel").getBytes("ISO-8859-1"), "UTF-8");
                           
                            String cargo = new String(request.getParameter("cboCargo").getBytes("ISO-8859-1"), "UTF-8");
                            String sexo = new String(request.getParameter("cboSexo").getBytes("ISO-8859-1"), "UTF-8");
                            
                            String usuario = new String(request.getParameter("txtUsuario").getBytes("ISO-8859-1"), "UTF-8");
                            String clave = new String(request.getParameter("txtClave").getBytes("ISO-8859-1"), "UTF-8");
                          
                           
                            String errorNombre="Ingrese Nombre";
                            String errorDni="Ingrese DNI";
                            String errorDireccion="Ingrese direccion";
                            String errorCargo="Seleccione Cargo";
                            String errorSexo="Seleccione sexo";
                            String errorUsuario="Ingrese usuario";
                            String errorTelefono="Ingrese telefono";
                            String errorClave="Ingrese clave";
                               

                            
                            
                            if (nombre.length()==0) {
                     request.setAttribute("errorNombre", errorNombre);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
       break;
                            }if (dn.length()==0) {
                     request.setAttribute("errorDni", errorDni);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                    break;}
        if (direccion.length()==0) {
                     request.setAttribute("errorDireccion", errorDireccion);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                        
                    break;}if (cargo.equals("0")) {
                     request.setAttribute("errorCargo", errorCargo);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                        
                   break; }if (sexo.equals("0")) {
                     request.setAttribute("errorSexo", errorSexo);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                        break;
                    }if (usuario.length()==0) {
                     request.setAttribute("errorUsuario", errorUsuario);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                      break;  
                    }if (clave.length()==0) {
                     request.setAttribute("errorClave", errorClave);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                        
                    break;}if (telefono.length()==0) {
                     request.setAttribute("errorTelefono", errorTelefono);
                      getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
                        
                    break;}
                            
                            
                            
                            int dni =Integer.parseInt(dn);
                          int tel =Integer.parseInt(telefono);
                          int car =Integer.parseInt(cargo);
                     
                         
                          
                          
                          
                          empleadoDAO objEmpleadoDAO = new empleadoDAO();
                       ArrayList lista= objEmpleadoDAO.ListarEmpleados1();
                                  int cod = lista.size();
                             EmpleadoBean objEmpleadoBean = new EmpleadoBean();
                            
                             objEmpleadoBean.setIdEmpleado(cod+1);
                             objEmpleadoBean.setNombre(nombre);
                            objEmpleadoBean.setUsuario(usuario);
                            objEmpleadoBean.setDireccion(direccion);
                            objEmpleadoBean.setDni(dni);
                            objEmpleadoBean.setClave(clave);
                            objEmpleadoBean.setTelefono(tel);
                            objEmpleadoBean.setIdCargo(car);
                            objEmpleadoBean.setSexo(sexo);
                            objEmpleadoBean.setContrato("si");
               
                            
                           
                            objEmpleadoDAO.AgregarEmpleado(objEmpleadoBean);
                            objEmpleadoDAO.AgregarTelefono(objEmpleadoBean);
                            objEmpleadoDAO.AgregarLogin(objEmpleadoBean);
                          
                          
                            getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);
              
              break;  }
                case 3:{
                
                  String codigo= new String(request.getParameter("codigo").getBytes("ISO-8859-1"), "UTF-8");
      
       
                          
              
                            int cod = Integer.parseInt(codigo);
                            EmpleadoBean objEmpleadoBean = new EmpleadoBean();
                            objEmpleadoBean.setIdEmpleado(cod);
                            empleadoDAO objEmpleadoDAO = new empleadoDAO();
                            objEmpleadoDAO.EliminarTelefono(objEmpleadoBean);
                            objEmpleadoDAO.EliminarEmpleado(objEmpleadoBean);
                            objEmpleadoDAO.EliminarLogin(objEmpleadoBean);

                            ArrayList lista = objEmpleadoDAO.ListarEmpleados();
                            request.setAttribute("lista", lista);
                          
                            getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                            
               break; }
                
                case 4:{
                    String codigo= request.getParameter("codigo");
                    
                    String nombre= request.getParameter("nombre");
                    String dni= request.getParameter("dni");
                    String direccion= request.getParameter("direccion");
                    String cargo= request.getParameter("idCargo");
                    String telefono= request.getParameter("telefono");
                     String sexo = request.getParameter("sexo");
                    
                    request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("dni", dni);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("cargo", cargo);
                    request.setAttribute("telefono", telefono);
                    request.setAttribute("sexo", sexo);

                  getServletContext().getRequestDispatcher("/FrmModificarEmpleados.jsp").forward(request, response);               
      
                
                
                break;
                }
                
                case 5:
                
                {
                    
                            getServletContext().getRequestDispatcher("/FrmEmpleados.jsp").forward(request, response);               
          
                
                
                break;}
                case 6:{
                String codigo= request.getParameter("txtCodigo");
                    int cod = Integer.parseInt(codigo);
                    String nombre= request.getParameter("txtNombre");
                    String dni= request.getParameter("txtDni");
                    String direccion= request.getParameter("txtDireccion");
                    String cargo= request.getParameter("cboCargo");
                    String telefono= request.getParameter("txtTel");
                    String sexo=request.getParameter("cboSexo");
                     String errorNombre="Ingrese Nombre";
                            String errorDni="Ingrese DNI";
                            String errorDireccion="Ingrese direccion";
      
                            String errorTelefono="Ingrese telefono";
                    
                         if (nombre.length()==0) {
                             
                     request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("dni", dni);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("cargo", cargo);
                    request.setAttribute("telefono", telefono);
                   
                     request.setAttribute("errorNombre", errorNombre);
                      getServletContext().getRequestDispatcher("/FrmModificarEmpleados.jsp").forward(request, response);               
       break;   }if (dni.length()==0) {
                                 request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("dni", dni);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("cargo", cargo);
                    request.setAttribute("telefono", telefono);
                   
                     request.setAttribute("errorDni", errorDni);
                      getServletContext().getRequestDispatcher("/FrmModificarEmpleados.jsp").forward(request, response);               
                    break;}
        if (direccion.length()==0) {
             request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("dni", dni);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("cargo", cargo);
                    request.setAttribute("telefono", telefono);
                   
                     request.setAttribute("errorDireccion", errorDireccion);
                      getServletContext().getRequestDispatcher("/FrmModificarEmpleados.jsp").forward(request, response);               
                        
                    break;}
        if (telefono.length()==0) {
             request.setAttribute("codigo", codigo);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("dni", dni);
                    request.setAttribute("direccion", direccion);
                    request.setAttribute("cargo", cargo);
                    request.setAttribute("telefono", telefono);
                   
                     request.setAttribute("errorTelefono", errorTelefono);
                      getServletContext().getRequestDispatcher("/FrmModificarEmpleados.jsp").forward(request, response);               
                        
                    break;}
                    
                   int idCargo=1; 
                   int tel=Integer.parseInt(telefono);
                   int dn = Integer.parseInt(dni);
                    if ("Administrador".equals(cargo)) {
                        idCargo=2;
                    }else {
                        if("Vendedor".equals(cargo)){
                            idCargo=1;
                        }
                    }
                      EmpleadoBean objEmpleadoBean = new EmpleadoBean();
                      objEmpleadoBean.setIdEmpleado(cod);
                    objEmpleadoBean.setNombre(nombre);
                    objEmpleadoBean.setDni(dn);
                    objEmpleadoBean.setDireccion(direccion);
                    objEmpleadoBean.setSexo(sexo);                    
                    
                     objEmpleadoBean.setIdCargo(idCargo);
                   objEmpleadoBean.setTelefono(tel);
                
                empleadoDAO objEmpleadoDao = new empleadoDAO();
                 objEmpleadoDao.ModificarTelefono(objEmpleadoBean);
                objEmpleadoDao.ModificarEmpleado(objEmpleadoBean);
           
                ArrayList<EmpleadoBean> lista=objEmpleadoDao.ListarEmpleados();
         request.setAttribute("lista",lista);
        
        getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);        

                break;} case 7:{
                
                
        getServletContext().getRequestDispatcher("/FrmCambiarClave.jsp").forward(request, response);        

            break;    } case 8 :{
                HttpSession session = request.getSession();
                String clave1=request.getParameter("clave1");
                String clave2=request.getParameter("clave2");
                String idEmpleado =(String) session.getAttribute("idEmpleado");
                String clave =(String)session.getAttribute("clave");
                
                if (clave1.length()==0) {
                    String errorClave1 ="Ingrese clave nueva";
                    request.setAttribute("errorClave1", errorClave1);
                                       getServletContext().getRequestDispatcher("/FrmCambiarClave.jsp").forward(request, response);        

                break;}else if (clave2.length()==0) {
                    String errorClave2 ="Ingrese clave antigua";
                    request.setAttribute("errorClave2", errorClave2);
                                       getServletContext().getRequestDispatcher("/FrmCambiarClave.jsp").forward(request, response);        

                break;}else
                
                if (!clave1.equals(clave)) {
                    
                    String mensaje ="Su clave no coincide!";
                    request.setAttribute("mensaje", mensaje);
                   getServletContext().getRequestDispatcher("/FrmCambiarClave.jsp").forward(request, response);        
break;}else{
                int id = Integer.parseInt(idEmpleado);
                EmpleadoBean objEmpleadoBean = new EmpleadoBean();
                empleadoDAO objEmpleadoDAO = new empleadoDAO();
                
                objEmpleadoBean.setIdEmpleado(id);
                objEmpleadoDAO.ModificarClave(objEmpleadoBean, clave2);
                
               getServletContext().getRequestDispatcher("/FrmCambiarClave.jsp").forward(request, response);        

                
                }   break; }
            
            case 9:{
                //FILTRANDO EMPLEADOS
            String opcion = request.getParameter("cboOpcion");
            String criterio=request.getParameter("criterio");
            
            empleadoDAO objEmpleadoDAO= new empleadoDAO();
            
            int opCriterio= Integer.parseInt(opcion);
            switch (opCriterio){
                case 0:{
                                         request.setAttribute ("error","Caracter invalido");
       ArrayList lista= objEmpleadoDAO.ListarEmpleados();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                      
                
                break;}
                case 1:{
                                  if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objEmpleadoDAO.ListarEmpleados();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                        
                     break;}
           ArrayList lista= objEmpleadoDAO.FiltrarEmpleados("idCargo", criterio);
           request.setAttribute("lista", lista);
                    
         
           
          getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                            
                break;}
                case 2:{
                           if (criterio.matches("[a-zA-Z]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objEmpleadoDAO.ListarEmpleados();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                        
                     break;}
                    
              ArrayList lista= objEmpleadoDAO.FiltrarEmpleados("idEmpleado", criterio);
           request.setAttribute("lista", lista);
          getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
            break;
                }
                case 3:{
                     if (criterio.matches("[0-9]+")|| criterio.length()==0) {
                     request.setAttribute ("error","Caracter invalido");
                ArrayList lista= objEmpleadoDAO.ListarEmpleados();
                  
                request.setAttribute("lista", lista);
            
                     getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
                        
                     break;}
                  ArrayList lista= objEmpleadoDAO.FiltrarEmpleados("nombre", criterio);
                  
           request.setAttribute("lista", lista);
            getServletContext().getRequestDispatcher("/FrmListadoEmpleados.jsp").forward(request, response);               
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
