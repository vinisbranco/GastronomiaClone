<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="./includes/_header.jsp"></jsp:include>

<script type="text/javascript" src="./assets/js/cadastrarAtributo.js"></script>

<div class="container" id="numero1">
    <form id="formulario">
        <h1>Cadastro de Atributo</h1>
        <div class="row">
            <div class="form-group col-sm-6">
                <label for="nome">Nome do atributo:</label>
                <input id="nome" type="search" class="form-control" name="nome">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-3">
                <label for="unidade">Unidade de Medida:</label>
                <input id="unidade" type="search" class="form-control" name="unidade">
            </div>
            <div class="form-group col-sm-3">
                <label for="multiplicador">Multiplicador:</label>
                <input id="multiplicador" type="search" class="form-control" name="multiplicador">
            </div>
        </div>
        <div class="form-group col-sm-3">
            <label >Obrigatório:</label>
            <div class="btn-group" data-toggle="buttons">
                <label class="radio-inline"><input id="sim" type="radio" value=1 name="obrigatorio">sim</label>
                <label class="radio-inline"><input id="nao" type="radio" value=0 name="obrigatorio" checked>não</label>
            </div>
        </div>
        <div class="row buttons">
            <button type="button" class="btn btn-success separar" id="confirmar">Confirmar</button>
            <button type="reset" class="btn btn-danger separar">Limpar tudo</button>
        </div>
    </form>
</div>
<br>
<div class="alert alert-success" role="alert"
     style="display: none; width: 25%; margin-left:37%; text-align: center;">
</div>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading titulo_lista"><h3>Lista de Atributos</h3></div>
        <div class="panel-body">
            <table class="table table-horvered table-striped" id="listaItens" style="display:none;">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome do Atributo</th>
                    <th>Unidade de Medida</th>
                    <th>Multiplicador</th>
                    <th>Obrigatorio</th>
                    <th>Ações</th>
                </tr>
                </thead>

                <tbody id="col_itens">

                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="./includes/_footer.jsp"></jsp:include>
