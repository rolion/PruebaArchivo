/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.Controlador;

import GestionUsuario.Entidades.EUsuario;
import GestionUsuario.Entidades.EPerfil;
import GestionUsuario.Negocio.NUsuario;
import GestionUsuario.Negocio.NPerfil;
import GestionUsuario.Util.GV;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lion
 */
@WebServlet(name = "cLogIn", urlPatterns = {"/cLogIn"})
public class cLogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private NUsuario nUsuario;
    private NPerfil nPerfil;
    private EPerfil ePerfil;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispacher;
        try
        {
            EUsuario user=new EUsuario();
            user.setUsername(request.getParameter("nickname"));
            user.setPassword(request.getParameter("password"));
            String error="";
            String redir="";
            HttpSession session =request.getSession(true);
            if(user!=null && !user.getUsername().equals("") && !user.getPassword().equals("")){
                //Todo
                nUsuario= new NUsuario();
                if(nUsuario.existeUsuario(user)){
                    nPerfil=new NPerfil();
                    ePerfil=nPerfil.getPerfilByUsername(user);
                    session.setAttribute(GV.nameEUsuario, user);
                    session.setAttribute(GV.nameNUsuario, nUsuario);
                    session.setAttribute(GV.nameEPerfil, ePerfil);
                    session.setAttribute(GV.nameNPerfil, nPerfil);
                    redir=GV.redirSuccessLogIn;
                }else{
                    redir=GV.redirFailLogIn;
                    error="El datos que introdujo son incorrectos";
                }
            }else{
                error="Debe ingresar todos lo datos";
                redir=GV.redirFailLogIn;
            }
            dispacher=getServletContext().getRequestDispatcher(redir);
            session.setAttribute(GV.nameError, error);
            dispacher.forward(request, response);
        }catch(Exception e)
        {
            System.out.println("Error--->> "+e.getMessage());
            e.printStackTrace();
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
