<%-- 
    Document   : TelaUsuario
    Created on : 04/07/2020, 14:49:48
    Author     : r_pab
--%>
<%@page import="jdbc.EstadoMunicipioDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="model.Cidade"%>
<%@page import="model.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>MIBI — Tela de Usuario</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="crossorigin="anonymous"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="css/est.css" />
        <script type="text/javascript" src="js/validar.js"></script>
        <script type="text/javascript" src="js/cidadezinha.js"></script>
        <script type="text/javascript" src="js/AlterGoing.js"></script>
        <script type="text/javascript" src="mask/dist/jquery.mask.min.js"></script>
        <%
            HttpSession sessao = request.getSession();
            long est = Long.parseLong(sessao.getAttribute("estadoUsuario").toString());
            long cid = Long.parseLong(sessao.getAttribute("cidadeUsuario").toString());
            long estE = Long.parseLong(sessao.getAttribute("estadoEmpresa").toString());
            long cidE = Long.parseLong(sessao.getAttribute("cidadeEmpresa").toString());
            String dddf;
            if (!sessao.getAttribute("dddfEmpresa").toString().equals("-1")) {
                dddf = "(" + sessao.getAttribute("dddfEmpresa").toString() + ")";
            } else {
                dddf = null;
            }
            String dddw;
            if (!sessao.getAttribute("dddwEmpresa").toString().equals("-1")) {
                dddw ="(" + sessao.getAttribute("dddwEmpresa").toString() + ")";
            } else {
                dddw = null;
            }
            String telfix;
            if (!sessao.getAttribute("numeroFixoEmpresa").toString().equals("-1")) {
                telfix =sessao.getAttribute("numeroFixoEmpresa").toString();
            } else {
                telfix = null;
            }
            String whats;
            if (!sessao.getAttribute("numeroWhatsEmpresa").toString().equals("-1")) {
                whats =sessao.getAttribute("numeroWhatsEmpresa").toString();
            } else {
                whats = null;
            }
        %>
    </head>
    <body style="background-color: rgb(196, 212, 220)">
        <nav class="navbar bg-dark">
            <a class="navbar-brand h1" href="index.jsp" style="color : white"><b>MIBI - MicroBusiness</b></a>
            <ul class="nav justify-content-end">
                <p class="nav-link">
                    <%
                        if (sessao.isNew()) {
                            sessao.invalidate();
                            try {
                                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                                rd.forward(request, response);
                            } catch (Exception e) {
                                System.out.println("alooo");
                                System.out.println(e.getMessage());
                            }
                        } else {
                            out.println("<li classs='nav-item'><a class='nav-link' href='Disconect'>"
                                    + "<BUTTON type='button' class='btn btn-info'><b>DESCONECTAR-SE</b></button></a>");
                            out.println(" </li>");
                        }
                    %>
                </p>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <div class="card mt-3" style="width: auto; background-color:
                         rgba(0, 0, 0, 0.514);">
                        <form id="frm" type="POST">
                            <div style="margin: 1rem" id="bob">

                                <h3 class="text-center">Dados Pessoais&nbsp;
                                    <button class='btn btn-info' type='button'
                                            id="altU">Editar
                                        <img src='images/pencil.svg'></button></h3>
                            </div>

                            <div class="card-body">
                                <div class="mr-3 ml-3">
                                    <div class="form-group">
                                        <input type="text"
                                               class="form-control" id="nome"
                                               name="nome" minlength="3"
                                               required value="<%out.print(sessao.getAttribute("nomeUsuario").toString());%>">
                                        <error class="feedback" name="er"
                                               id="1"></error>
                                    </div>
                                    <div class="form-group">
                                        <input type="text"
                                               class="form-control"
                                               id="sobrenome"
                                               name="sobrenome" minlength="3"
                                               required
                                               value="<%out.print(sessao.getAttribute("sobrenomeUsuario").toString());%>">
                                        <error class="feedback" name="er"
                                               id="2"></error>
                                    </div>

                                    <div class="form-group">
                                        <input type="email" class="form-control"
                                               id="email" name="email"
                                               value="<%out.print(sessao.getAttribute("emailUsuario").toString());%>"
                                               pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+.[a-zA-Z0-9.-]{2,}$"
                                               required>
                                        <error class="feedback" name="er"
                                               id="3"></error>
                                    </div>

                                    <div class="form-group">
                                        <select class="custom-select" 
                                                id="estado" name="estado" 
                                                pattern="[a-zA-Z]" required
                                                >
                                            <%
                                                List<Estado> estados = EstadoMunicipioDAO.getEstado();
                                                int qtde = estados.size();
                                                for (int i = 0; i < qtde; i++) {
                                                    if (est == estados.get(i).getPkidestado()) {
                                                        out.print("<option value='" + estados.get(i).getPkidestado() + "' selected>" + estados.get(i).getNomeestado());
                                                        out.println("</option>");
                                                    } else {
                                                        out.print("<option value='" + estados.get(i).getPkidestado() + "'>" + estados.get(i).getNomeestado());
                                                        out.println("</option>");
                                                    }
                                                }
                                            %>

                                        </select>
                                        <error class="feedback" name="er"
                                               id="4"></error>
                                    </div>

                                    <div class="form-group">
                                        <select class="custom-select" id="municipio" name="municipio" 
                                                required >
                                            <%
                                                List<Cidade> cidades = EstadoMunicipioDAO.getCidade(est);
                                                int qutde = cidades.size();
                                                try {
                                                    for (int i = 0; i < qutde; i++) {
                                                        if (cid == cidades.get(i).getPkidmunicipio()) {
                                                            out.print("<option value='" + cidades.get(i).getPkidmunicipio() + "' selected>" + cidades.get(i).getNomemunicipio());
                                                            out.println("</option>");
                                                        } else {
                                                            out.print("<option value='" + cidades.get(i).getPkidmunicipio() + "'>" + cidades.get(i).getNomemunicipio());
                                                            out.println("</option>");
                                                        }
                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            %>
                                        </select>
                                        <error class="feedback" name="er"
                                               id="5"></error>
                                    </div>

                                    <div class="form-group">
                                        <input type="password"
                                               class="form-control" id="senha"
                                               name="senha"
                                               placeholder="Senha"
                                               minlength="6" required
                                               value="<%out.print(sessao.getAttribute("senhaUsuario").toString());%>">

                                        <error class="feedback" name="er"
                                               id="6"></error>
                                    </div>
                                    <div id='btnsAlt' class='input-group mb-3'>
                                        <button id="users" type='button' class='btn btn-outline-info btn-lg btn-block'
                                                onclick='validAUser()'>Alterar</button>
                                        <button id="cancel" type="reset" class='btn btn-outline-danger btn-lg btn-block'
                                                >Cancelar</button>
                                    </div>
                                    <div id='del' class='input-group'>
                                        <button id="delU" type="submit" class='btn btn-outline-danger btn-lg btn-block'
                                                >Deletar Conta</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card mt-3" 
                         style="width: auto; background-color: rgba(0, 0, 0, 0.514);">
                        <%
                            try {
                                if (sessao.getAttribute("idEmpresa").toString().equals("0")
                                        || sessao.getAttribute("idEmpresa").toString().equals(null)) {  %>
                        <form id="frmE" type="POST">
                            <div style="margin: 1rem" id="bobE">

                                <h3 class="text-center">Dados Empresariais&nbsp;
                                </h3>
                            </div>
                            <div class="card-body">
                                <div class="mr-3 ml-3">
                                    <center>
                                        <h5>Parece que você ainda não cadastrou sua empresa... <img src="images/nights_stay-black-24dp.svg"></h5>
                                        <button class='btn btn-info mb-3' type='button'
                                                id='criar'><img src="images/triangle-right.svg">
                                            <b>CADASTRAR</b><img src="images/triangle-left.svg"></button>
                                    </center>
                                    <% } else { %>
                                    <form id="frmE" type="POST">
                                        <div style="margin: 1rem" id="bobE">

                                            <h3 class="text-center">Dados Empresariais&nbsp;
                                                <button class='btn btn-info' type='button'
                                                        id="altE">
                                                    Editar <img src='images/pencil.svg'></button>
                                            </h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="mr-3 ml-3">
                                                <div class="form-group">
                                                    <div class="form-row">
                                                        <div class="col-md-6 radio">
                                                            <input type="text"
                                                                   class="form-control" id="nome"
                                                                   name="nomeE" minlength="3"
                                                                   required
                                                                   placeholder="Nome Fantasia *"
                                                                   required value="<%out.print(sessao.getAttribute("nomeEmpresa").toString());%>">
                                                            <error class="feedback" name="er"
                                                                   id="1"></error>
                                                        </div>
                                                        <div class="col-md-6 radio">
                                                            <input type="text"
                                                                   class="form-control"
                                                                   id="cnpj" name="cnpj" 
                                                                   minlength="18" maxlength="18"
                                                                   pattern="^(\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2})$"
                                                                   required 
                                                                   value="<%out.print(sessao.getAttribute("cnpj").toString());%>"
                                                                   placeholder="CNPJ: __.___.___/0001-__ *">
                                                            <error class="feedback" name="er"
                                                                   id="2"></error>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <input type="email" class="form-control"
                                                           id="email" name="emailE"
                                                           placeholder="Email empresarial: e-mail@exemplo.com *"
                                                           pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+.[a-zA-Z0-9.-]{2,}$"
                                                           required value="<%out.print(sessao.getAttribute("emailEmpresa").toString());%>">
                                                    <error class="feedback" name="er"
                                                           id="3"></error>
                                                </div>
                                                <div id="babalu">
                                                    <label>É obrigatório uma das formas de contato:</label>
                                                    <div class="form-group mb-3">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" 
                                                                   id="DDDf" name="DDDf" 
                                                                   maxlength="4" 
                                                                   pattern="^\([0-9]{2}\)$"
                                                                   placeholder="(DDD)"
                                                                   style="text-align: center"
                                                                   <%if(dddf != null){
                                                                       out.print("value='"+dddf+"'");
                                                                   } %>>
                                                            <input type="text" class="form-control" 
                                                                   id="telfix"  name="telfix" 
                                                                   minlength="9" maxlength="9"
                                                                   pattern="^[0-9]{4}-[0-9]{4}$"
                                                                   placeholder="Telefone fixo: ____-____"
                                                                   style="width: 55%"
                                                                   <%if(telfix != null){
                                                                       out.print("value='"+telfix+"'");
                                                                   } %>>
                                                        </div>
                                                        <error class="feedback" name="er"
                                                               id="4">Somente 2 dígitos no DDD</error>
                                                    </div>

                                                    <div class="form-group mb-3" id="ctt">
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" 
                                                                   id="DDDw" name="DDDw" 
                                                                   maxlength="4" 
                                                                   pattern="^\([0-9]{2}\)$"
                                                                   placeholder="(DDD)"
                                                                   style="text-align: center"
                                                                   <%if(dddw != null){
                                                                       out.print("value='"+dddw+"'");
                                                                   } %>>
                                                            <input type="text" class="form-control" 
                                                                   id="whats" name="whats" 
                                                                   minlength="10" maxlength="10"
                                                                   pattern="^9+[0-9]{3}-[0-9]{5}$"
                                                                   placeholder="Whatsapp: 9___-_____"
                                                                   style="width: 55%"
                                                                   <%if(whats != null){
                                                                       out.print("value='"+whats+"'");
                                                                   } %>>
                                                        </div>
                                                        <error class="feedback" name="er"
                                                               id="5">Somente 2 dígitos no DDD</error>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="form-row">
                                                        <div class="col-md-6 radio">
                                                            <select class="custom-select" 
                                                                    id="estado" 
                                                                    name="estadoE" 
                                                                    value!="Seu Estado..." required>
                                                                <%
                                                                    for (int i = 0; i < qtde; i++) {
                                                                        if (estE == estados.get(i).getPkidestado()) {
                                                                            out.print("<option value='" + estados.get(i).getPkidestado() + "' selected>" + estados.get(i).getNomeestado());
                                                                            out.println("</option>");
                                                                        } else {
                                                                            out.print("<option value='" + estados.get(i).getPkidestado() + "'>" + estados.get(i).getNomeestado());
                                                                            out.println("</option>");
                                                                        }
                                                                    }
                                                                %>
                                                            </select>
                                                            <error class="feedback" name="er"
                                                                   id="6"></error>
                                                        </div>
                                                        <div class="col-md-6 radio">
                                                            <select class="custom-select" 
                                                                    id="municipio" 
                                                                    name="municipioE" 
                                                                    value!="Sua Cidade..."
                                                                    required disabled>
                                                                <%
                                                                    try {
                                                                        for (int i = 0; i < qutde; i++) {
                                                                            if (cidE == cidades.get(i).getPkidmunicipio()) {
                                                                                out.print("<option value='" + cidades.get(i).getPkidmunicipio() + "' selected>" + cidades.get(i).getNomemunicipio());
                                                                                out.println("</option>");
                                                                            } else {
                                                                                out.print("<option value='" + cidades.get(i).getPkidmunicipio() + "'>" + cidades.get(i).getNomemunicipio());
                                                                                out.println("</option>");
                                                                            }
                                                                        }
                                                                    } catch (Exception e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                %>
                                                            </select>
                                                            <error class="feedback" name="er"
                                                                   id="7"></error>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="form-group" id="halls">
                                                    <div class="form-row">
                                                        <div class="col-md-6 radio">
                                                            <input type="text"
                                                                   class="form-control" id="endereco"
                                                                   name="endereco"
                                                                   placeholder="Endereço *"
                                                                   minlength="5" required
                                                                   value="<%out.print(sessao.getAttribute("enderecoEmpresa").toString());%>">
                                                        </div>
                                                        <div class="col-md 3">
                                                            <input type="text"
                                                                   class="form-control" id="numendereco"
                                                                   name="numendereco"
                                                                   placeholder="Nº *"
                                                                   maxlength="7"
                                                                   required
                                                                   value="<%out.print(sessao.getAttribute("numeroEnderecoEmpresa").toString());%>">
                                                        </div>
                                                        <div class="col-md 3">
                                                            <input type="text"
                                                                   class="form-control" id="complemento"
                                                                   name="complemento"
                                                                   placeholder="Complemento"
                                                                   value="<%out.print(sessao.getAttribute("complementoEmpresa").toString());%>">
                                                        </div>
                                                    </div>
                                                    <error class="help-block
                                                           with-errors"
                                                           name="er" id="8">
                                                    </error>
                                                </div>
                                                <div id='btnsAltE' class='input-group mb-3'>
                                                    <button id="emps" type='button' class='btn btn-outline-info btn-lg btn-block'
                                                            onclick='validAEmp()'>Alterar</button>
                                                    <button id="cancelE" type="reset" class='btn btn-outline-danger btn-lg btn-block'
                                                            >Cancelar</button>
                                                </div>
                                                <div id='de' class='input-group'>
                                                    <button id="delE" type="submit" class='btn btn-outline-danger btn-lg btn-block'
                                                            >Deletar Empresa</button>
                                                </div>
                                                <%
                                                        }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                        e.getStackTrace();
                                                        System.out.println(e.getMessage());
                                                    }%>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                    </div>
                </div>

                <script type="text/javascript">
                    $("#cnpj").mask("99.999.999/0001-99");
                    $("#DDDf").mask("(99)");
                    $("#DDDw").mask("(99)");
                    $("#whats").mask("9999-99999");
                    $("#telfix").mask("9999-9999");
                </script>
                </body>
                </html>
