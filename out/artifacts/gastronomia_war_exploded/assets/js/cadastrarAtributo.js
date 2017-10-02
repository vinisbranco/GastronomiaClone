$(document).ready(function () {
    montarTabela();
    $("#confirmar").click(function (event) {
        event.preventDefault();
        if(!$("#confirmar").hasClass("editarItem")) {
            cadastrarItem();
        } else {
            atualizarItem();
        }
    });

});

var urlEndPoint = "atributos";
var pageTitle = "Atributo";

function montarTabela(){
    $("#col_itens").empty();
    $.ajax({
        type: "GET",
        url: urlDefault + urlEndPoint,
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            var cont = 0;
            $.each(data.Atributos, function (key, val) {
                if(!val.status){
                    return;
                }
                $("#listaItens").show();
                $("#nadaLista").hide();
                $("#col_itens").append(inputRollInTable(val));
                cont++;
            });
            if(cont== 0){
                $(".panel-body").append("<h4 style='text-align: center;' " +
                    "id='nadaLista'>Nenhum " + pageTitle + " cadastrado</h4>");
                $("#listaItens").hide();
            }
        },
        error: function () {
            alert("Erro ao recuperar informações do servidor.");
        }
    });
}

function cadastrarItem(){
    var id = "";
    var item = getItem(id);

    if(item == null){
        return
    }

    $.ajax({
        type: "POST",
        url: urlDefault + urlEndPoint,
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(item),
        success: function (data) {
            if (data.success) {
                $(".alert-success").text(data.message).fadeIn(1500).fadeOut(1000);
            } else {
                alert(data.message);
            }
            montarTabela();
            limparForm();
        },
        error: function () {
            alert(pageTitle + " não cadastrado: erro ao enviar informações para o servidor.");
        }
    });
}

function deletarItem(id){
    if(!confirm("Tem certeza que deseja deletar?")){
        return false;
    }
    $.ajax({
        type: "DELETE",
        url: urlDefault + urlEndPoint + "/" + id,
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            if (data.success) {
                $(".alert-success").text(data.message).fadeIn(1500).fadeOut(1000);
            } else {
                alert(data.message);
            }
            montarTabela();
        },
        error: function () {
            alert(pageTitle + " não cadastrado: erro ao enviar informações para o servidor.");
        }
    });
}

function editarItem(id){
    $.get(urlDefault + urlEndPoint + "/" + id, function (data) {
        setItem(data);
        $(".btn-success").text("Editar");
        $(".btn-success").addClass("editarItem");
        $(".btn-success").attr("data-id", id);
    }).fail(function(){
        alert("Erro ao pegar informações do servidor");
    });
}

function atualizarItem(){
    var id = $(".btn-success").attr("data-id");
    var item = getItem(id);

    if(item == null){
        return;
    }

    $.ajax({
        type: "PUT",
        url: urlDefault + urlEndPoint + "/update",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(item),
        success: function (data) {
            if (data.success) {
                $(".alert-success").text(data.message).fadeIn(1500).fadeOut(1000);
                $("h1").text("Cadastrar " + pageTitle);
                $(".btn-success").text("Cadastrar");
                $(".btn-success").removeClass("editarItem");
            } else {
                alert(data.message);
            }
            montarTabela();
            limparForm();
        },
        error: function () {
            alert(pageTitle + " não atualizado: erro ao enviar informações para o servidor.");
        }
    });
}

function setItem(data) {
    $("h1").text("Editar " + pageTitle + ": " + data.nome);
    $("#nome").val(data.nome);
    $("#multiplicador").val(data.multiplicador);
    $("#unidade").val(data.unidade);

    if(data.obrigatorio) {
        document.getElementById("sim").checked = true;
    } else {
        document.getElementById("nao").checked = true;
    }
}

function getItem(id) {
    var item = {};
    item.id = id;
    item.nome = $("#nome").val();
    item.unidade = $("#unidade").val();
    item.multiplicador = $("#multiplicador").val();
    item.obrigatorio = document.getElementById("sim").checked;
    item.status = true;

    var message = "";

    if(item.nome == "") {
        message += "Nome ";
    }

    if(item.unidade == "") {
        message += "Unidade ";
    }

    if(item.multiplicador == "") {
        message += "Multiplicador ";
    }

    if( message != "") {
        alert("Favor revisar: " + message);
        return null;
    }

    return item;
}

function limparForm(){
    $('#formulario')[0].reset();
}

function inputRollInTable(item) {

    var obr = "-";
    if (item.obrigatorio == true) {
        obr = "Sim";
    }

    return "<tr id='" + item.id + "'>" +
        "<td>" + item.id + "</td>" +
        "<td>" + item.nome + "</td>" +
        "<td>" + item.unidade + "</td>" +
        "<td>" + item.multiplicador + "</td>" +
        "<td>" + obr + "</td>" +
        "<td>" +
        "<div class='btn-group'>" +
        "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' " +
        "aria-haspopup='true' aria-expanded='false'> Ações <span class='caret'></span>" +
        "</button>" +
        "<ul class='dropdown-menu'>" +
        "<li><a href='#' onclick=editarItem('"+item.id+"')>Editar</a></li>" +
        "<li role='separator' class='divider'></li>" +
        "<li><a href='#' onclick=deletarItem('"+item.id+"')>Deletar</a></li>" +
        "</ul>" +
        "</div>" +
        "</td>" +
        "</tr>";

}