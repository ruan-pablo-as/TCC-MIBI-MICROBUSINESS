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
import javax.servlet.http.HttpSession;
import jdbc.UsuarioDAO;
import model.Usuario;
/**
 *
 * @author r_pab
 */
public class AltConta extends HttpServlet {

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
            HttpSession sessao = request.getSession();
            long id = Long.parseLong(sessao.getAttribute("idUsuarioLogado").toString());
            
            String nome = (String) request.getParameter("nome");
            System.out.println("oi "+nome);
            String sobrenome = (String) request.getParameter("sobrenome");

            String email = (String) request.getParameter("email");
            //converter String para Long
            String cidade = (String) request.getParameter("municipio");
            long muni = parseLong(cidade);

            String est = (String) request.getParameter("estado");
            long estado = parseLong(est);

            String senha = Cript.criptografar(request.getParameter("senha"));
            //Obj do usuario para enviar os dados pelo DAO
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setSobrenome(sobrenome);
            user.setEmail(email);
            user.setFkidmunicipio(muni);
            user.setFkidestado(estado);
            user.setSenha(senha);
            //Executar método do DAO
            UsuarioDAO.alterarUsuario(user, id);
            
            
            long idUsuario = user.getPkidusuario();
            String nomeUsuario = user.getNome();
            String sobrenomeUsuario = user.getSobrenome();
            String emailUsuario = user.getEmail();
            long cidadeUsuario = user.getFkidmunicipio();
            long estadoUsuario = user.getFkidestado();
            String senhaUsuario = user.getSenha();
            sessao.setAttribute("idUsuarioLogado", idUsuario);
            sessao.setAttribute("nomeUsuario", nomeUsuario);
            sessao.setAttribute("sobrenomeUsuario", sobrenomeUsuario);
            sessao.setAttribute("emailUsuario", emailUsuario);
            sessao.setAttribute("cidadeUsuario", cidadeUsuario);
            sessao.setAttribute("estadoUsuario", estadoUsuario);
            sessao.setAttribute("senhaUsuario", senhaUsuario);
            
            RequestDispatcher rd = request.getRequestDispatcher("TelaUsuario.jsp");
            rd.forward(request, response);
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
