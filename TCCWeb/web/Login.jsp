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
        <title>MIBI — Entrar</title>
        <meta charset="utf-8">
        <meta name="viewport" content="maximum-scale=1, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/est.css">
    </head>



    <body style="background-color: rgb(196, 212, 220)">
        <nav class="navbar bg-dark">
            <a class="navbar-brand h1" href="Index"><b>MIBI - MicroBusiness</b></a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <%
                        out.println("<li class='nav-item'>");
                        out.println("<center><a class='nav-link active' href='CadastroUsuario.jsp'>");
                        out.println("<button class='btn btn-info'><B>SEJA MIBI</B></button></a></center>");
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

                            <h3 class="text-center">Entrar</h3>

                        </div>

                        <div class="card-body">
                            <form id="frm" class="mr-3 ml-3" role="form"
                                  method="POST" action="Login">

                                <div class="form-group">
                                    <input type="email" class="form-control"
                                           id="email" name="email"
                                           placeholder="Seu e-mail"
                                           pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+.[a-zA-Z0-9.-]{2,}$"
                                           required>
                                </div>

                                <div class="form-group">
                                    <input type="password"
                                           class="form-control" id="senha"
                                           name="senha"
                                           placeholder="Sua senha"
                                           minlength="6" required>

                                    <error class="feedback" name="er"
                                           id="1" style="color: rgb(252, 0, 0)">
                                        <%try {
                                                String msg = request.getAttribute("mensagem").toString();
                                                if (msg != null) {
                                                    out.print("<p>" + msg + "</p>");
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        %></error>
                                </div>
                                <button type="submit" class="btn
                                        btn-outline-info btn-lg btn-block">
                                    Conectar-se</button>
                            </form>
                        </div>
                    </div>

                </div>

            </div>

            <div class="col-md-3"></div>
        </div>
    </div>

</body>



</html>