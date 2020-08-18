<%-- 
    Document   : index
    Created on : 21/05/2020, 11:54:40
    Author     : r_pab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>MIBI — MicroBusiness</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="css/estilo.css" />
    </head>
    <body style="background-color: rgb(196, 212, 220)">
        <nav class="navbar navbar-expand-md bg-dark">
            <a class="navbar-brand h1" href="index.jsp" style="color : white"><b>MIBI - MicroBusiness</b></a>
            <!--Colocando aquelas barrinhas que fica no cantinho dos sites/aplicativos, tá ligado?-->
            <button class="navbar-toggler mb-3" type="button" data-toggle="collapse" data-target="#conteudoDaBarra">
                <img class="navbar-toggler-icon" src="images/view_headline-white-48dp.svg">
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="conteudoDaBarra">
                <ul class="nav justify-content-end">
                        <%
                            HttpSession sessao = request.getSession();
                            String nome = sessao.getAttribute("nomeUsuario").toString();
                            if (nome.equals("null")) {
                                out.println("<li class='nav-item'>");
                                out.println("<center><a class='nav-link active' href='CadastroUsuario.jsp'>");
                                out.println("<button class='btn btn-info'><B>SEJA MIBI</B></button></a></center>");
                                out.println("</li>");

                                out.println("<li class='nav-item nav-link'>");
                                out.println("<span class='align-middle'>ou</span>");
                                out.println("</li>");

                                out.println("<li class='nav-item'>");
                                out.println("<a class='nav-link active' href='Login.jsp'"
                                        + " id='aaa'><button class='btn btn-info'><b>ENTRAR</b></button></a>");
                                out.println("</li>");
                            } else {
                                out.println("<li class='nav-item'><a class='nav-link active' href='TelaUsuario.jsp'>"
                                        + "<button class='btn btn-info' type='button'><b>Olá  "
                                        + sessao.getAttribute("nomeUsuario").toString() + "!</b></button></a>");
                                out.println(" </li>");

                                out.println("<li classs='nav-item'><a class='nav-link' href='Disconect'>"
                                        + "<button class='btn btn-info' type='button'><b>DESCONECTAR-SE</b></button></a>");
                                out.println(" </li>");
                            }
                        %>
                </ul>
            </div>
        </nav>
        <div class="container-fluid">
            <div class='row' style='background-color:rgb(52, 58, 64); height: 100%;'>
                <div class='col-md-9'>
                </div>
                <div class='col-md-3'>
                    <form id="frm" role="form"
                          method="POST" action="#">
                        <div class="input-group mb-3">
                            <input type="text"
                                   class="form-control" id="pesquisa"
                                   name="pesquisa"
                                   placeholder="Pesquisar" required>&nbsp;
                            <button class="btn btn-info" type="button"><span><img src="images/search.svg"></span></button>
                        </div> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

