$(document).ready(function() {
    montarTabela();
    $("#confirmar").click(function (event) {
        event.preventDefault();
        if(!$("#confirmar").hasClass("editarItem")) {
            cadastraItem();
        } else {
            atualizarItem();
        }
    });
});

var urlEndPoint = "usuarios";
var pageTitle = "Usuário";

function montarTabela(){
    $("#col_itens").empty();
    $.ajax({
        type: "GET",
        url: urlDefault + urlEndPoint,
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            var cont = 0;
            $.each(data.Usuarios, function (key, val) {
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

function cadastraItem(){
    var id ="";
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
    $("h1").text("Editar " + pageTitle + ": "+data.nome);
    $("#nome").val(data.nome);
    $("#email").val(data.email);
    $("#matricula").val(data.matricula);
    $("#cpf").val(data.cpf);
    $("#senha").val(data.senha);
    $("#confirmacaoSenha").val(data.senha);
}

function getItem(id) {
    var item = {};
    item.id = id;
    item.nome = $("#nome").val();
    item.email = $("#email").val();
    item.matricula = $("#matricula").val();
    item.cpf = $("#cpf").val();
    item.senha = $("#senha").val();
    item.tipo = "user";
    item.status = true;

    var message = "";

    if(item.nome == "") {
        message += "Nome ";
    }

    if( !validarEmail(item.email) ) {
        message += "E-mail ";
    }

    if(item.matricula == "") {
        message += "Matricula ";
    }

    if( !validarCPF(item.cpf) ) {
        message += "CPF ";
    }

    if(item.senha != $("#confirmacaoSenha").val()) {
        message += "Senha ";
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
    return "<tr id='" + item.id + "'>" +
        "<td>" + item.id + "</td>" +
        "<td>" + item.nome + "</td>" +
        "<td>" + item.email + "</td>" +
        "<td>" + item.matricula + "</td>" +
        "<td>" + item.cpf + "</td>" +
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

function formatar(mascara, documento){
    var i = documento.value.length;
    var saida = mascara.substring(0,1);
    var texto = mascara.substring(i)
    if (texto.substring(0,1) != saida){
        documento.value += texto.substring(0,1);
    }
}

function validarCPF(value) {

    if( value=="") {
        return false;
    }

    var cpf = value.replace(/[^\d]+/g,'');
    if(cpf == '') return false;

    if (cpf.length != 11) return false;

    // testa se os 11 digitos são iguais, que não pode.
    var valido = 0;
    for (var i=1; i < 11; i++){
        if (cpf.charAt(0)!=cpf.charAt(i)) valido =1;
    }
    if (valido==0) return false;


    var aux = 0;
    for (var i=0; i < 9; i ++)
        aux += parseInt(cpf.charAt(i)) * (10 - i);
    var check = 11 - (aux % 11);
    if (check == 10 || check == 11)
        check = 0;
    if (check != parseInt(cpf.charAt(9)))
        return false;

    aux = 0;
    for (var i = 0; i < 10; i ++)
        aux += parseInt(cpf.charAt(i)) * (11 - i);
    check = 11 - (aux % 11);
    if (check == 10 || check == 11)
        check = 0;
    if (check != parseInt(cpf.charAt(10)))
        return false;
    return true;

}

function validarEmail(email) {
    var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
    return email_regex.test(email);
}