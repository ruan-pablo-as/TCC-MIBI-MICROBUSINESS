<%-- 
    Document   : CadastroUsuario
    Created on : 25/06/2020, 15:05:46
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
        <title>MIBI — Cadastro de Empresa</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="maximum-scale=1, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
        <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script type="text/javascript" src="mask/dist/jquery.mask.min.js"></script>
        <script type="text/javascript" src="js/validar.js"></script>
        <script type="text/javascript" src="js/cidadezinha.js"></script>
        <script type="text/javascript" src="mask/dist/jquery.mask.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/est.css">
    </head>



    <body style="background-color: rgb(196, 212, 220)">
        <nav class="navbar bg-dark">
            <a class="navbar-brand h1" href="index.jsp"><b>MIBI - MicroBusiness</b></a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <%

                        out.println("<li classs='nav-item'><a class='nav-link' href='Disconect'>"
                                + "<BUTTON type='button' class='btn btn-info'><b>DESCONECTAR-SE</b></button></a>");
                        out.println(" </li>");
                    %>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 mt-5" style="background-color:
                     transparent; margin-bottom: 7rem;">
                    <div class="card" style="width: auto; background-color:
                         rgba(0, 0, 0, 0.514);">
                        <div style="margin: 1rem" id="bobE">
                            <h3 class="text-center">Cadastre-se</h3>
                        </div>
                        <div class="card-body">
                            <form id="frmE" class="mr-3 ml-3" role="form"
                                  method="post">
                                <div class="form-group">
                                    <div class="form-row">
                                        <div class="col-md-6 radio">
                                            <input type="text"
                                                   class="form-control" id="nome"
                                                   name="nomeE" minlength="3"
                                                   required
                                                   placeholder="Nome Fantasia *">
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
                                           required>
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
                                                   style="text-align: center">
                                            <input type="text" class="form-control" 
                                                   id="telfix"  name="telfix" 
                                                   minlength="9" maxlength="9"
                                                   pattern="^[0-9]{4}-[0-9]{4}$"
                                                   placeholder="Telefone fixo: ____-____"
                                                   style="width: 55%">
                                        </div>
                                        <error class="feedback" name="er"
                                               id="4">Somente 2 dígitos no DDD</error>
                                    </div>

                                    <div class="form-group mb-3">
                                        <div class="input-group">
                                            <input type="text" class="form-control" 
                                                   id="DDDw" name="DDDw" 
                                                   maxlength="4" 
                                                   pattern="^\([0-9]{2}\)$"
                                                   placeholder="(DDD)"
                                                   style="text-align: center">
                                            <input type="text" class="form-control" 
                                                   id="whats" name="whats" 
                                                   minlength="10" maxlength="10"
                                                   pattern="^\9+[0-9]{3}-[0-9]{5}$"
                                                   placeholder="Whatsapp: 9___-_____"
                                                   style="width: 55%">
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
                                                <option selected >Seu Estado...</option>
                                                <%List<Estado> es = EstadoMunicipioDAO.getEstado();
                                                    for (int i = 0; i < es.size(); i++) {
                                                        out.println("<option value='" + es.get(i).getPkidestado() + "'>"
                                                                + es.get(i).getNomeestado() + "</option>");
                                                    }%>
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
                                                   minlength="5" required>
                                        </div>
                                        <div class="col-md 3">
                                            <input type="text"
                                                   class="form-control" id="numendereco"
                                                   name="numendereco"
                                                   placeholder="Nº *"
                                                   maxlength="7"
                                                   required>
                                        </div>
                                        <div class="col-md 3">
                                            <input type="text"
                                                   class="form-control" id="complemento"
                                                   name="complemento"
                                                   placeholder="Complemento">
                                        </div>
                                    </div>
                                    <error class="help-block
                                           with-errors"
                                           name="er" id="8">
                                    </error>
                                </div>
                                <div class="form-group" style="margin: 1rem;
                                     margin-top:
                                     0rem;">
                                    <button type="button" class="btn
                                            btn-outline-info btn-lg btn-block"
                                            id="emps"
                                            onclick="validEmpresa()">Cadastrar Empresa</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-3"></div>
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
