/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("input").prop('disabled', true);
    $("select").prop('disabled', true);
    $("error").hide();
    $("label").hide();
    $("#btnsAlt").hide();
    $("#btnsAltE").hide();

    $("#altU").click(function () {
        $("#frm").find("input").prop('disabled', false);
        $("#frm").find("select").prop('disabled', false);
        $("#btnsAlt").show("slow");
        $("#altU").fadeOut("slow");
        $("#altE").fadeOut("slow");
    });
    $("#cancel").click(function () {
        $("#frm").find("input").prop('disabled', true);
        $("#frm").find("select").prop('disabled', true);
        $("#btnsAlt").fadeOut("slow");
        $("#altU").show("slow");
        $("#altE").show("slow");
    });

    $("#altE").click(function () {
        $("#frmE").find("input").prop('disabled', false);
        $("#frmE").find("select").prop('disabled', false);
        $("#btnsAltE").show("slow");
        $("error").show('slow');
        $("label").show('slow');
        $("#altE").fadeOut("slow");
        $("#altU").fadeOut("slow");
    });
    $("#cancelE").click(function () {
        $("#frmE").find("input").prop('disabled', true);
        $("#frmE").find("select").prop('disabled', true);
        $("#btnsAltE").fadeOut("slow");
        $("error").hide('slow');
        $("label").hide('slow');
        $("#altE").show("slow");
        $("#altU").show("slow");
    });
    
    $("#ctt").find("input").change(function (){
        if($(this).val() === null || $(this).val() === "null"){
            $(this).attr("value","");
        }
    });

    $("#criar").click(function () {
        window.location.replace("CadastroEmpresa.jsp");
    });

    $("#delU").click(function () {
        $("#frm").attr('action', "DelUser");
    });
    $("#delE").click(function () {
        $("#frmE").attr('action', "DelEmp");
    });

});