/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#estado").change(function () {
        var estado = $("#estado").val();
        $.ajax({
            type: "POST",
            url: "TelaCadastro",
            data: "estado=" + estado,
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#municipio").empty();
                $("#municipio").append("<option selected>Sua Cidade...</option>");
                for (var i in data.dados) {
                    $("#municipio").append("<option value='" + data.dados[i].pkidmunicipio + "'>" + data.dados[i].nomemunicipio + "</option>");
                }
                ;

            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#bob").append(jqXHR.responseText + "Desculpe");
            },
            beforeSend: function (xhr) {
                $("#municipio").attr("disabled", true);
                $("#municipio").html("<option selected>Aguarde...</option>");

            },
            complete: function (jqXHR, textStatus) {
                $('#municipio').attr("disabled", false);
            }
        });
    });
    $("#estadoE").change(function () {
        var estado = $("#estado").val();
        $.ajax({
            type: "POST",
            url: "TelaCadastro",
            data: "estado=" + estado,
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                $("#municipioE").empty();
                $("#municipioE").append("<option selected>Sua Cidade...</option>");
                for (var i in data.dados) {
                    $("#municipioE").append("<option value='" + data.dados[i].pkidmunicipio + "'>" + data.dados[i].nomemunicipio + "</option>");
                }
                ;

            },
            error: function (jqXHR, textStatus, errorThrown) {
                $("#bob").append(jqXHR.responseText + "Desculpe");
            },
            beforeSend: function (xhr) {
                $("#municipioE").attr("disabled", true);
                $("#municipioE").html("<option selected>Aguarde...</option>");

            },
            complete: function (jqXHR, textStatus) {
                $('#municipioE').attr("disabled", false);
            }
        });
    });
});

