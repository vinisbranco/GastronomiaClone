$(document).ready(function () {
    montarTabela();
    $("#confirmar").click(function (event) {
        event.preventDefault();
        if(!$("#confirmar").hasClass("editarIngrediente")) {
            cadastrarIngrediente();
        } else {
            atualizarIngrediente();
        }
    });
});
    
function montaForm(){    
    $("#formIngredientes").empty();
    $.ajax({
        type: "GET",
        url: urlDefault + "atributos",
        contentType: "application/json;charset=UTF-8",
        success: function(data) {
            var cont = 0;
            var ingredientesHtml = [];
            $.each(data.Atributos, function(key, val) {
                if(!val.status){
                    return;
                }
                ingredientesHtml.push(
                    "<div class='form-group col-sm-2'>" +
                        "<label for='" + val.nome + "'>" + val.nome + "</label>" +
                            "<div class='input-group'>" +
                                "<input id='" + val.nome + "'type='search' class='form-control'>" + 
                                "<span class='input-group-addon'>" + val.unidade + "</span>" +
                            "</div>" +
                    "</div>"
                );
            });
            if(cont == 0) {
                //nenhum atributo cadastrado
                //return;
            }
            ingredientesHtml.appendTo("#formIngredientes");
        },
        error: function () {
            alert("Erro ao recuperar informações do servidor.");
        }
    });
}

function montarTabela(){
    $("#listaIngredientes").empty();
    $.ajax({
        type: "GET",
        url: urlDefault + "ingredientes",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            var cont = 0;
            $.each(data.Ingredientes, function (key, val) {
                if(!val.status){
                    return;
                }
                $("#listaIngredientes").show();
                $("#nadaLista").hide();
                $("#listaIngredientes").append(inputRowInTable($(this)));
                cont++;
            });
            if(cont == 0){
                $(".panel-body").append("<h4 style='text-align: center;' id='nadaLista'>Nenhum ingrediente cadastrado</h4>");
                $("#listaIngredientes").hide();
            }
        },
        error: function () {
            alert("Erro ao recuperar informações do servidor.");
        }
    });
}

function cadastrarIngrediente(){
    var ingredientes = {};
    ingrediente.id = $(".btn-success").attr("data-id");        
    $.each($("#tabela:input"), function() {
        
        if($(this).attr("type") == "search") {
            ingredientes[this.id] = $(this).val();
        }

    });

    $.ajax({
        type: "POST",
        url: "./ingredientes",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(ingredientes),
        success: function(data) {
            if(data.success) {
                alert("Cadastro de ingrediente efetuado com sucesso.");
                window.location.href = "./";
            } else {
                alert(data.message);
            }
        },
        error: function() {
            alert("Ingrediente não cadastrado: erro ao enviar informações para o servidor.");
        }
    });
}

function atualizarIngrediente(){
    var ingrediente = {};
    ingrediente.id = $(".btn-success").attr("data-id");
    $.each($("#formIngredientes:input"), function() {
        
        if($(this).attr("type") == "search") {
            ingredientes[this.id] = $(this).val();
        }

    });

    $.ajax({
        type: "PUT",
        url: urlDefault + "ingredientes/update",
        contentType: "application/json;charset=UTF-8",
        data: JSON.stringify(ingrediente),
        success: function (data) {
            if (data.success) {
                $(".alert-success").text(data.message).fadeIn(1500).fadeOut(1000);
                $("h1").text("Cadastrar Ingrediente");
                $(".btn-success").text("Cadastrar");
                $(".btn-success").removeClass("editarIngrediente");
            } else {
                alert(data.message);
            }
            montarTabela();
            limparForm();
        },
        error: function () {
            alert("Ingrediente não cadastrado: erro ao enviar informações para o servidor.");
        }
    });
}

function editarIngrediente(id){
    
    $.ajax({
        type: "GET",
        url: urlDefault + "atributos/" + id,
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            $("h1").text("Editar ingrediente: " + data.nome);                
            $.each(data, function (key, val) {
                if(key == "id") continue;
                $("#" + key).val(val);
            });
            $(".btn-success").text("Editar");
            $(".btn-success").addClass("editarIngrediente");
            $(".btn-success").attr("data-id", id);
        },
        error: function () {
            alert("Erro ao recuperar informações do servidor.");
        }
    });
}

function inputRowInTable(ingrediente) {
    // A ideia é colocar na tabela os atributos obrigatorios
    
    /*return "<tr id='" + id + "'>" +
        "<td>" + nome + "</td>" +
        "<td>" + proteina + "</td>" +
        "<td>" +
        "<div class='btn-group'>" +
        "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' " +
        "aria-haspopup='true' aria-expanded='false'> Ações <span class='caret'></span>" +
        "</button>" +
        "<ul class='dropdown-menu'>" +
        "<li><a href='#' onclick=editarAtributo('"+id+"')>Editar</a></li>" +
        "<li role='separator' class='divider'></li>" +
        "<li><a href='#' onclick=deletarAtributo('"+id+"')>Deletar</a></li>" +
        "</ul>" +
        "</div>" +
        "</td>" +
        "</tr>";
    */
}
    
$("#limpar").click(function() {
    $.each($("#tabela:input"), function() {

        if($(this).attr("type") == "search") $(this).val("");

    });
});
    
$("#confirmar").click(function() {
    event.preventDefault();

    

});
