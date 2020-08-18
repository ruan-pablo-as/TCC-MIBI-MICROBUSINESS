<%-- 
    Document   : CadastroCliente
    Created on : 21/05/2020, 12:03:22
    Author     : r_pab
--%>

<%@page import="model.Cidade"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.EstadoMunicipioDAO"%>
<%@page import="model.Estado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>MIBI — Cadastro de Usuario</title>
        <meta charset="utf-8">
        <meta name="viewport" content="maximum-scale=1, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script type="text/javascript" src="mask/dist/jquery.mask.min.js"></script>
        <script type="text/javascript" src="js/validar.js"></script>
        <script type="text/javascript" src="js/cidadezinha.js"></script>
        <link rel="stylesheet" type="text/css" href="css/est.css">
    </head>



    <body style="background-color: rgb(196, 212, 220)">
        <nav class="navbar bg-dark">
            <a class="navbar-brand h1" href="Index"><b>MIBI - MicroBusiness</b></a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <%
                        out.println("<li class='nav-item'>");
                        out.println("<a class='nav-link active' href='Login.jsp'"
                                + " id='aaa'><button class='btn btn-info'><b>ENTRAR</b></button></a>");
                        out.println("</li>");
                    %>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">

                <div class="col-md-3"></div>

                <div class="col-md-6 mt-5" style="background-color:
                     transparent; margin-bottom: 7rem;">

                    <div class="card" style="width: auto; background-color:
                         rgba(0, 0, 0, 0.514);">

                        <div style="margin: 1rem" id="bob">

                            <h3 class="text-center">Cadastre-se</h3>

                        </div>

                        <div class="card-body">

                            <form id="frm" class="mr-3 ml-3" role="form"
                                  method="post">

                                <div class="form-group">

                                    <div class="form-row">

                                        <div class="col-md-6 radio">
                                            <input type="text"
                                                   class="form-control" id="nome"
                                                   name="nome" minlength="3"
                                                   required
                                                   placeholder="Nome">
                                            <error class="feedback" name="er"
                                                   id="1"></error>
                                        </div>

                                        <div class="col-md-6 radio">
                                            <input type="text"
                                                   class="form-control"
                                                   id="sobrenome"
                                                   name="sobrenome" minlength="3"
                                                   required
                                                   placeholder="Sobrenome">
                                            <error class="feedback" name="er"
                                                   id="2"></error>
                                        </div>

                                    </div>

                                </div>

                                <div class="form-group">
                                    <input type="email" class="form-control"
                                           id="email" name="email"
                                           placeholder="Email: e-mail@exemplo.com"
                                           pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+.[a-zA-Z0-9.-]{2,}$"
                                           required>
                                    <error class="feedback" name="er"
                                           id="3"></error>
                                </div>

                                <div class="form-group">

                                    <div class="form-row">

                                        <div class="col-md-6 radio">

                                            <select class="custom-select" id="estado" name="estado" pattern="[a-zA-Z]" required>
                                                <option selected value="0" >Seu Estado...</option>
                                                <%List<Estado> es = EstadoMunicipioDAO.getEstado();
                                                    for (int i = 0; i < es.size(); i++) {
                                                        out.println("<option value='" + es.get(i).getPkidestado() + "'>"
                                                                + es.get(i).getNomeestado() + "</option>");
                                                    }%>
                                            </select>
                                            <error class="feedback" name="er"
                                                   id="4"></error>
                                        </div>

                                        <div class="col-md-6 radio">
                                            <select class="custom-select" id="municipio" name="municipio" 
                                                    value!="Sua Cidade..." required disabled>
                                            </select>
                                            <error class="feedback" name="er"
                                                   id="5"></error>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">

                                    <div class="form-row">

                                        <div class="col-md-6 radio">
                                            <input type="password"
                                                   class="form-control" id="senha"
                                                   name="senha"
                                                   placeholder="Senha"
                                                   minlength="6" required>

                                            <error class="feedback" name="er"
                                                   id="6"></error>
                                        </div>

                                        <div class="col-md-6">
                                            <input type="password"
                                                   class="form-control" id="rsenha"
                                                   name="rsenha"
                                                   placeholder="Repita a senha"
                                                   minlength="6" oninvalid="o()"
                                                   required>

                                            <error class="help-block
                                                   with-errors"
                                                   name="er" id="7" minlength="6"
                                                   required></error>

                                        </div>

                                    </div>

                                </div>
                                <div class="form-group" style="margin: 1rem;
                                     margin-top:
                                     0rem;">

                                    <button type="button" class="btn
                                            btn-outline-info btn-lg btn-block"
                                            id="users" onclick="validUser()">Cadastrar</button>
                                </div>
                            </form>

                        </div>

                    </div>

                </div>

                <div class="col-md-3"></div>

            </div>



        </div>

    </body>



</html>