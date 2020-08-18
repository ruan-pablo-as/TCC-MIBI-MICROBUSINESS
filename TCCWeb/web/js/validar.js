$(document).ready(function () {
    $("#u").attr("type", "button");
    $("#e").attr('type', 'button');
});
//Variável global
var y = 0;
//Funções para validar o cadastro do Usuário
function conferirUsuario() {
    //Variaveis para os métodos
    y = 0;
    console.log(y);
    f = $("#frm");
    var frm = document.getElementById('frm');
    var usuario = frm.email.value.substring(0, frm.email.value.indexOf("@"));

    var dominio = frm.email.value.substring(
            frm.email.value.indexOf("@") + 1,
            frm.email.value.length
            );
    Vnome(f.find("#nome"));
    Vsobrenome(f.find("#sobrenome"));
    Vemail(usuario, dominio);
    Vestado(f.find("#estado"));
    Vcidade(f.find("#municipio"));
    Vsenha(f.find("#senha"));
    Vrsenha(f.find("#senha"), f.find("#rsenha"));
    if (y === 7) {
        return "Cadastro realizado com sucesso!";
    } else {
    }
}

//Verificando nome e nome fantasia
function Vnome(nome) {
    if (nome.val().length < 3) {
        $('#nome').css("border-color", "rgb(190, 10, 10)");
        $('#nome').css("color", "rgb(190, 10, 10)");
        $('#1').css("color", "rgb(190, 10, 10)");
        $('#1').html("Deve ter no mínimo 3 letras");

        return "Nome";
    } else {
        $('#nome').css("border-color", "rgb(0, 211, 28)");
        $('#nome').css("color", "rgb(0, 211, 28)");
        $('#1').html("");
        y++;
        console.log(y);
    }
    ;
}
//Verificando sobrenome
function Vsobrenome(sobrenome) {
    if (sobrenome.val().length < 3) {
        $('#sobrenome').css("border-color", "rgb(190, 10, 10)");
        $('#sobrenome').css("color", "rgb(190, 10, 10)");
        $('#2').css("color", "rgb(190, 10, 10)");
        $('#2').html("Deve ter no mínimo 3 letras");

        return "Sobrenome";
    } else {
        $('#sobrenome').css("border-color", "rgb(0, 211, 28)");
        $('#sobrenome').css("color", "rgb(0, 211, 28)");
        $('#2').html("");
        y++;
        console.log(y);
    }
}
//Verificando E-mail
function Vemail(usuario, dominio) {
    if (
            usuario.length < 1 ||
            dominio.length < 3 ||
            usuario.search("@") != -1 ||
            dominio.search("@") != -1 ||
            usuario.search(" ") != -1 ||
            dominio.search(" ") != -1 ||
            dominio.search(".") == -1 ||
            dominio.indexOf(".") < 1 ||
            dominio.lastIndexOf(".") >= dominio.length - 1
            ) {
        $("#email").css("border-color", "rgb(252, 0, 0)");
        $('#email').css("color", "rgb(252, 0, 0)");
        $('#3').css("color", "rgb(190, 10, 10)");
        $('#3').html("Verifique o e-mail inserido, ele está inválido");
        return "E-mail";
    } else {
        $("#email").css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
        $('#3').html("");
        y++;
        console.log(y);
    }
}
//Verificando Estado
function Vestado(estado) {
    if (estado.val() === "0") {
        estado.css("border-color", "rgb(190, 10, 10)");
        estado.css("color", "rgb(190, 10, 10)");
        $('#4').css("color", "rgb(190, 10, 10)");
        $('#4').html("Escolha um Estado");

        return "Estado";
    } else {
        $('#estado').css("border-color", "rgb(0, 211, 28)");
        $('#estado').css("color", "rgb(0, 211, 28)");
        $('#4').html("");
        y++;
        console.log(y);
    }
}
//Verificando Cidade
function Vcidade(muni) {
    if (muni.val() == "Sua Cidade..." || muni.val() == null || muni.val() == "") {
        muni.css("border-color", "rgb(190, 10, 10)");
        muni.css("color", "rgb(190, 10, 10)");
        $('#5').css("color", "rgb(190, 10, 10)");
        $('#5').html("Escolha uma Cidade");
        return "Municipio";
    } else {

        muni.css("border-color", "rgb(0, 211, 28)");
        muni.css("color", "rgb(0, 211, 28)");
        $('#5').html("");
        y++;
        console.log(y);
    }
}
//Verificando senha
function Vsenha(senha) {
    if (senha.val().length < 6) {
        $('#senha').css("border-color", "rgb(252, 0, 0)");
        $('#senha').css("color", "rgb(252, 0, 0)");
        $("#6").css("color", "rgb(252, 0, 0)");
        $("#6").html("No mínimo 6 caracteres");
        return "senha";
    } else {
        $('#senha').css("border-color", "rgb(0, 211, 28)");
        $('#senha').css("color", "rgb(0, 211, 28)");
        $("#6").css("color", "rgb(0, 211, 28)");
        $("#6").html("").fadeIn(100);
        y++;
        console.log(y);
    }
}
function Vrsenha(senha, rsenha) {
    if (rsenha.val() != senha.val() || rsenha.val() == null || rsenha.val() == "") {
        $('#rsenha').css("border-color", "rgb(252, 0, 0)");
        $('#rsenha').css("color", "rgb(252, 0, 0)");
        $("#7").css("color", "red");
        $("#7").html("As senhas devem ser iguais.").fadeIn(100);
        event.preventDefault();
        return "rsenha";
    } else {
        $('#rsenha').css("border-color", "rgb(0, 211, 28)");
        $('#rsenha').css("color", "rgb(0, 211, 28)");
        $("#7").css("color", "rgb(0, 211, 28)");
        $("#7").html("").fadeIn(100);
        y++;
        console.log(y);
    }
}

//um método para a confirmação da senha
function o() {
    var rsenha = $('#rsenha');
    if (rsenha.val() !== $('#senha').val() || rsenha.val() === null || rsenha.val() === "") {
        rsenha.css("border-color", "rgb(252, 0, 0)");
        rsenha.css("color", "rgb(252, 0, 0)");
        $("#6").css("color", "red");
        $("#6").html("As senhas devem ser iguais.").fadeIn(100);
        event.preventDefault();
        return false;
    } else {
        rsenha.css("border-color", "rgb(0, 211, 28)");
        rsenha.css("color", "rgb(0, 211, 28)");
        $("#6").css("color", "rgb(0, 211, 28)");
        $("#6").html("").fadeIn(100);
        return true;
    }
}
//conferir o que aconteceu com a validação (mostrar o retorno)
function validUser() {
    $conferir = conferirUsuario();

    console.log($conferir);
    if ($conferir === "Cadastro realizado com sucesso!") {
        alert($conferir);
        $("#users").prop("type", "submit");
        $("#frm").attr("action", "CadastraCliente");
    } else {
        alert("Algo deu errado. Desculpe o transtorno.");
    }
}

//Funções para validar o cadastro da Empresa
function conferirEmpresa() {
    //Variaveis para os métodos
    y = 0;
    console.log(y);
    f = $("#frmE");
    var frm = document.getElementById('frmE');
    var usuario = frm.email.value.substring(0, frm.email.value.indexOf("@"));
    var dominio = frm.email.value.substring(
            frm.email.value.indexOf("@") + 1,
            frm.email.value.length
            );

    Vnome(f.find("#nome"));
    Vcnpj(f.find("#cnpj"));
    Vemail(usuario, dominio);
    Vcontato(f.find("#DDDf"), f.find("#DDDw"), f.find("#telfix"), f.find("#whats"));
    Vestado(f.find("#estado"));
    Vcidade(f.find("#municipio"));
    Vendereco(f.find("#endereco"), f.find("#numendereco"));
    if (y === 7) {
        return "Cadastro realizado com sucesso!";
    }
}

//Verificando CNPJ
function Vcnpj(cnpj) {
    if (cnpj.val() === "" || cnpj.val().length < 18) {
        cnpj.css("border-color", "rgb(190, 10, 10)");
        cnpj.css("color", "rgb(190, 10, 10)");
        cnpj.css("color", "rgb(190, 10, 10)");
        cnpj.html("Preencha o campo corretamente.");
        return console.log("CNPJ");
    } else {
        y++;
        $('#cnpj').css("border-color", "rgb(0, 211, 28)");
        $('#cnpj').css("color", "rgb(0, 211, 28)");
        $('#2').html("");
        console.log(y);
    }
}
//Verificando Contato
function Vcontato(Df, Dw, fixo, whats) {
    divctt = $("#babalu");
    divctt.find("input").attr("required", false);
    //se os dois campos para o contato estiverem vazios
    if (((Df.val() === null || Df.val() === "") && (fixo.val() === null || fixo.val() === ""))
            && ((Dw.val() === null || Dw.val() === "") && (whats.val() === null || whats.val() === ""))) {
        divctt.find("input").attr("required", true);
        divctt.find("input").css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
        divctt.find("label").css("color", "rgb(252, 0, 0)");
        return console.log("Nenhun contato");
        //se qualquer um dos campos do telefone fixo estiverem preenchidos e os do whatsapp vazios
    } else if (((Df.val() !== null || Df.val() !== "") || (fixo.val() !== null || fixo.val() !== ""))
            && ((Dw.val() === null || Dw.val() === "") && (whats.val() === null || whats.val() === ""))) {
        /*se o DDD do telefone fixo estiver vazio mas o número estiver preenchido,
         ou o oposto, ou se um ou os dois campos estiverem com o número de 
         caracteres abaixo/acima do correto*/
        if (((Df.val() === null || Df.val() === "") && (fixo.val() !== null || fixo.val() !== ""))
                || ((Df.val() !== null || Df.val() !== "") && (fixo.val() === null || fixo.val() === ""))
                || (Df.val().length !== 4 || fixo.val().length !== 9)) {
            Df.attr("required", true);
            fixo.attr("required", true);
            Df.css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            fixo.css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            $("#4").css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            $("#4").html("Preencha os dois campos corretamente.");
            return console.log("Campos do Telefone fixo incompletos");
            //se os campos do Telefone fixo estiverem com o número de caracteres corretos
        } else if (Df.val().length === 4 && fixo.val().length === 9) {
            y++;
            Df.css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
            fixo.css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
            $("#4").html("");
            console.log(y);
        } else {
            return console.log("Algo deu errado no Telefone fixo");
        }
    } else if (((Df.val() === null || Df.val() === "") && (fixo.val() === null || fixo.val() === ""))
            && ((Dw.val() !== null || Dw.val() !== "") || (whats.val() !== null || whats.val() !== ""))) {
        /*se o DDD do número de whatsapp estiver vazio mas o número estiver preenchido,
         ou o oposto, ou se um ou os dois campos estiverem com o número de caracteres
         abaixo/acima do correto*/
        if (((Dw.val() === null || Dw.val() === "") && (whats.val() !== null || whats.val() !== ""))
                || ((Dw.val() !== null || Dw.val() !== "") && (whats.val() === null || whats.val() === ""))
                || (Dw.val().length !== 4 || whats.val().length !== 10)) {
            Dw.attr("required", true);
            whats.attr("required", true);
            Dw.css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            whats.css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            $("#5").css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
            $("#5").html("Preencha os dois campos corretamente.");
            return console.log("Campos do Whatsapp incompletos ou incorretos");
            //se os campos do Whatsapp estiverem com o número de caracteres corretos
        } else if (Dw.val().length === 4 && whats.val().length === 10) {
            y++;
            Dw.css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
            whats.css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
            $("#5").html("");
            console.log(y);
        } else {
            return console.log("Algo deu errado no Whatsapp");
        }
    } else if (((Df.val() !== null || Df.val() !== "") || (fixo.val() !== null || fixo.val() !== ""))
            && ((Dw.val() !== null || Dw.val() !== "") || (whats.val() !== null || whats.val() !== ""))) {
        divctt.find("input").attr("required", true);
        if ((Df.val().length === 4 && fixo.val().length === 9)
                && (Dw.val().length === 4 && whats.val().length === 10)) {
            divctt.find("input").css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
            divctt.find("label").css("color", "white");
            divctt.find("error").html("");
            y++;
            console.log(y);
        }
    } else {
        return console.log("Deu algo errado no contato, ou esqueci de alguma coisa");
    }
}
//Verificando Endereço
function Vendereco(endereco, num) {
    var divendco = $("#halls");
    if (endereco.val().length > 4 && num.val().length <= 7) {
        y++;
        divendco.find("input").css("border-color", "rgb(0, 211, 28)").css("color", "rgb(0, 211, 28)");
        console.log(y);
    } else {
        divendco.find("input").css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
        divendco.find("error").css("border-color", "rgb(252, 0, 0)").css("color", "rgb(252, 0, 0)");
        return console.log("Endereço");
    }
}
//conferir o que aconteceu com a validação (mostrar o retorno)
function validEmpresa() {
    $conferir = conferirEmpresa();

    if ($conferir === "Cadastro realizado com sucesso!") {
        console.log($conferir);
        $("#emps").prop("type", "submit");
        $("#frmE").attr("action", "CadastraEmpresa");
    } else {
        alert("Algo deu errado. Desculpe o transtorno.");
    }
}

function alteraUsuario() {
    //Variaveis para os métodos
    y = 0;
    console.log(y);
    f = $("#frm");
    var frm = document.getElementById('frm');
    var usuario = frm.email.value.substring(0, frm.email.value.indexOf("@"));

    var dominio = frm.email.value.substring(
            frm.email.value.indexOf("@") + 1,
            frm.email.value.length
            );
    Vnome($("#nome"));
    Vsobrenome($("#sobrenome"));
    Vemail(usuario, dominio);
    Vestado(f.find("#estado"));
    Vcidade(f.find("#municipio"));
    Vsenha(f.find("#senha"));
    if (y === 6) {
        return "Cadastro alterado com sucesso!";
    } else {
    }
}
function validAUser() {
    $conferir = alteraUsuario();

    console.log($conferir);
    if ($conferir === "Cadastro alterado com sucesso!") {
        alert($conferir);
        $("#users").prop("type", "submit");
        $("#frm").attr("action", "AltConta");
    } else {
        alert("Algo deu errado. Desculpe o transtorno.");
    }
}
function alteraEmpresa() {
    //Variaveis para os métodos
    y = 0;
    console.log(y);
    f = $("#frmE");
    var frm = document.getElementById('frm');
    var usuario = frm.email.value.substring(0, frm.email.value.indexOf("@"));

    var dominio = frm.email.value.substring(
            frm.email.value.indexOf("@") + 1,
            frm.email.value.length
            );
    Vnome(f.find("#nome"));
    Vcnpj(f.find("#cnpj"));
    Vemail(usuario, dominio);
    Vcontato(f.find("#DDDf"), f.find("#DDDw"), f.find("#telfix"), f.find("#whats"));
    Vestado(f.find("#estado"));
    Vcidade(f.find("#municipio"));
    Vendereco(f.find("#endereco"), f.find("#numendereco"));
    if (y === 7) {
        return "Cadastro alterado com sucesso!";
    } else {
    }
}
function validAEmp() {
    $conferir = alteraEmpresa();

    console.log($conferir);
    if ($conferir === "Cadastro alterado com sucesso!") {
        alert($conferir);
        $("#emps").prop("type", "submit");
        $("#frmE").attr("action", "AltEmp");
    } else {
        alert("Algo deu errado. Desculpe o transtorno.");
    }
}

