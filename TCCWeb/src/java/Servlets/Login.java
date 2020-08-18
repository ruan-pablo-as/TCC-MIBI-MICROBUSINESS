/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Criptografia.Cript;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.EmpresaDAO;
import jdbc.UsuarioDAO;
import model.Empresa;
import model.Usuario;

/**
 *
 * @author r_pab
 */
public class Login extends HttpServlet {

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

        HttpSession sessao = request.getSession();

        Usuario usuario = null;
        String email = request.getParameter("email");
        String senha = Cript.criptografar(request.getParameter("senha"));
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario = dao.getLogin(email, senha);

        } catch (Exception ex) {
            System.out.print("Servlet Login ");
            System.out.println(ex.getMessage());
        }
        try {
            if (usuario == null) {
                sessao.invalidate();
                String mensagem = "Login ou Senha incorretos. Tente novamente";
                request.setAttribute("mensagem", mensagem);
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            } else {
                long idUsuario = usuario.getPkidusuario();
                String nomeUsuario = usuario.getNome();
                String sobrenomeUsuario = usuario.getSobrenome();
                String emailUsuario = usuario.getEmail();
                long cidadeUsuario = usuario.getFkidmunicipio();
                long estadoUsuario = usuario.getFkidestado();
                String senhaUsuario = usuario.getSenha();
                sessao.setAttribute("idUsuarioLogado", idUsuario);
                sessao.setAttribute("nomeUsuario", nomeUsuario);
                sessao.setAttribute("sobrenomeUsuario", sobrenomeUsuario);
                sessao.setAttribute("emailUsuario", emailUsuario);
                sessao.setAttribute("cidadeUsuario", cidadeUsuario);
                sessao.setAttribute("estadoUsuario", estadoUsuario);
                sessao.setAttribute("senhaUsuario", senhaUsuario);
                Empresa emp = EmpresaDAO.selectEmpUser(idUsuario);
                    sessao.setAttribute("idEmpresa", emp.getPkidempresa());
                    sessao.setAttribute("nomeEmpresa", emp.getNomeemp());
                    sessao.setAttribute("cnpj", emp.getCnpj());
                    sessao.setAttribute("emailEmpresa", emp.getEmailemp());
                    sessao.setAttribute("dddfEmpresa", emp.getDddf());
                    sessao.setAttribute("numeroFixoEmpresa", emp.getNumerofixoemp());
                    sessao.setAttribute("dddwEmpresa", emp.getDddw());
                    sessao.setAttribute("numeroWhatsEmpresa", emp.getNumerowhats());
                    sessao.setAttribute("enderecoEmpresa", emp.getEnderecoemp());
                    sessao.setAttribute("numeroEnderecoEmpresa", emp.getNumendereco());
                    sessao.setAttribute("complementoEmpresa", emp.getComplemento());
                    sessao.setAttribute("cidadeEmpresa", emp.getFkidmunicipio());
                    sessao.setAttribute("estadoEmpresa", emp.getFkidestado());
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
            System.out.println(e.getMessage());
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
