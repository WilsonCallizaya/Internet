
package com.emergentes.controlador;

import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOimpl;
import com.emergentes.modelo.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "InternetController", urlPatterns = {"/InternetController"})
public class InternetController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            AvisoDAO dao= new AvisoDAOimpl();
            Aviso avi = new Aviso();
            int id;
            String action=(request.getParameter("action") != null)? request.getParameter("action"): "view";
            switch(action){
                case "add":
                    request.setAttribute("avisos", avi);
                    request.getRequestDispatcher("formulario.jsp").forward(request, response);
                    
                    break;
                case "edit":
                    id=Integer.parseInt(request.getParameter("id"));
                    try {
                        avi=dao.getById(id);
                    
                    } catch (Exception e) {
                        System.out.println("Error al obtener registro");
                    }
                    request.setAttribute("avisos", avi);
                    request.getRequestDispatcher("formulario.jsp").forward(request, response);                    
                    break;
                case "delete":
                    id=Integer.parseInt(request.getParameter("id"));
                    try {
                        dao.delete(id);
                    } catch (Exception e) {
                        System.out.println("Error al eliminar");
                    }                   
                    response.sendRedirect("InternetController");
                    break;
                case "view":
                    List<Aviso> lista= new ArrayList<Aviso>();
                    try {
                        lista= dao.getAll();
                    } catch (Exception e) {
                        System.out.println("Error al listar");
                    }
                    
                    
                    request.setAttribute("avisos",lista);
                    request.getRequestDispatcher("internet.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        }   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String idParameter = request.getParameter("id");
int id = 0;
if (idParameter != null && !idParameter.isEmpty()) {
    id = Integer.parseInt(idParameter);
}
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String seminario= request.getParameter("seminario");
        String confirmado= request.getParameter("confirmado");
        String fecha= request.getParameter("fecha");
        
        Aviso avi= new Aviso();
        
        avi.setId(id);
        avi.setNombre(nombre);
        avi.setApellido(apellido);
        avi.setSeminario(seminario);
        avi.setConfirmado(confirmado);
        avi.setFecha(fecha);
        
        AvisoDAO dao= new AvisoDAOimpl();
            if(id==0){
            try {
                dao.insert(avi);
            } catch (Exception ex) {
                System.out.println("Error al insertar");
            }
            }
            else{
            try {
                dao.update(avi);
            } catch (Exception ex) {
                System.out.println("Error al editar");
            }
            }
            response.sendRedirect("InternetController");
        }
        }
    

   

  
