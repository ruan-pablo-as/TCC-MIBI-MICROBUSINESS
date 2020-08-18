/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Criptografia.Cript;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author r_pab
 */
public class CadastraCliente extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* Mandando os dados do cadastro para o DB. */
            String nome = (String) request.getParameter("nome");
            String sobrenome = (String) request.getParameter("sobrenome");
            
            String email = (String) request.getParameter("email");
            //converter String para Long
            String cidade = (String) request.getParameter("municipio");
            long municipio = parseLong(cidade);
            
            String est = (String) request.getParameter("estado");
            long estado = parseLong(est);
            
            String senha = Cript.criptografar(request.getParameter("senha"));
            System.out.println(senha);
            //Obj do usuario para enviar os dados pelo DAO
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setSobrenome(sobrenome);
            user.setEmail(email);
            user.setFkidmunicipio(municipio);
            user.setFkidestado(estado);
            user.setSenha(senha);
            //Executar método do DAO
            UsuarioDAO.insereUsuario(user);
            //Recarregar para a tela de usuário
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }catch(IOException e){
            e.getStackTrace();
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
