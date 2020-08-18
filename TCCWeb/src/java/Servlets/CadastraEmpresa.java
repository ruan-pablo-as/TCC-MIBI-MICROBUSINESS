/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.EmpresaDAO;
import model.Empresa;

/**
 *
 * @author r_pab
 */
public class CadastraEmpresa extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sessao = request.getSession();
            /* Mandando os dados do cadastro para o DB. */
            String nome = (String) request.getParameter("nomeE");

            String cnpj = (String) request.getParameter("cnpj");

            String email = (String) request.getParameter("emailE");
            //converter String para int
            String dddf = (String) request.getParameter("DDDf");
            int df = -1;
            if (!dddf.equals("")) {
                df = parseInt(dddf.replaceAll("[\\p{Ps}\\p{Pe}]", ""));
            }
            //converter String para Long
            String tf = (String) request.getParameter("telfix");
            long telfix = -1;
            if (!tf.equals("")) {
                telfix = parseLong(tf.replaceAll("[\\p{Ps}\\p{Pe}\\-]", ""));
            }
            //converter String para int
            String dddw = (String) request.getParameter("DDDw");
            int dw = -1;
            if (!dddw.equals("")) {
                dw = parseInt(dddw.replaceAll("[\\p{Ps}\\p{Pe}]", ""));
            }
            //converter String para Long
            String w = (String) request.getParameter("whats");
            long whats = -1;
            if (!w.equals("")) {
                whats = parseLong(w.replaceAll("[\\p{Ps}\\p{Pe}\\-]", ""));
            }
            //converter String para Long
            String cidade = (String) request.getParameter("municipioE");
            long municipio = parseLong(cidade);

            String est = (String) request.getParameter("estadoE");
            long estado = parseLong(est);

            String endereco = (String) request.getParameter("endereco");

            String num = (String) request.getParameter("numendereco");

            String compl = (String) request.getParameter("complemento");
            //Obj do usuario para enviar os dados pelo DAO
            Empresa emp = new Empresa();
            emp.setNomeemp(nome);
            emp.setCnpj(cnpj);
            emp.setEmailemp(email);
            emp.setDddf(df);
            emp.setNumerofixoemp(telfix);
            emp.setDddw(dw);
            emp.setNumerowhats(whats);
            emp.setFkidmunicipio(municipio);
            emp.setFkidestado(estado);
            emp.setEnderecoemp(endereco);
            emp.setNumendereco(num);
            emp.setComplemento(compl);
            long id = parseLong(sessao.getAttribute("idUsuarioLogado").toString());
            //Executar método do DAO
            EmpresaDAO.insereEmpresa(emp, id);
            emp = EmpresaDAO.selectEmpUser(id);
            sessao.setAttribute("idEmpresa", emp.getPkidempresa());
            sessao.setAttribute("nomeEmpresa", emp.getNomeemp());
            sessao.setAttribute("cnpj", cnpj);
            sessao.setAttribute("emailEmpresa", emp.getEmailemp());
            sessao.setAttribute("dddfEmpresa", emp.getDddf());
            sessao.setAttribute("numeroFixoEmpresa", tf);
            sessao.setAttribute("dddwEmpresa", emp.getDddw());
            sessao.setAttribute("numeroWhatsEmpresa", w);
            sessao.setAttribute("enderecoEmpresa", emp.getEnderecoemp());
            sessao.setAttribute("numeroEnderecoEmpresa", emp.getNumendereco());
            sessao.setAttribute("complementoEmpresa", emp.getComplemento());
            sessao.setAttribute("cidadeEmpresa", emp.getFkidmunicipio());
            sessao.setAttribute("estadoEmpresa", emp.getFkidestado());
            //Recarregar para a tela de usuário
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
