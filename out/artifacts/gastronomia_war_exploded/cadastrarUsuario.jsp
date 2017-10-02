<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="./includes/_header.jsp"></jsp:include>

<script type="text/javascript" src="./assets/js/cadastrarUsuario.js"></script>

<div class="container" id="numero1">
	<form id="formulario">
		<h1>Cadastro de Usuário</h1>
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="nome">Nome:</label>
				<input id="nome" type="search" class="form-control">
			</div>	
			<div class="form-group col-sm-6">
				<label for="email">E-mail:</label>
				<input id="email" type="email" class="form-control" name="email">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="matricula">Matricula:</label>
				<input id="matricula" type="search" class="form-control" name="matricula">
			</div>
			<div class="form-group col-sm-6">
				<label for="cpf">CPF:</label>
                <input id="cpf" type="text" class="form-control" name="cpf" maxlength="14" onkeypress="formatar('###.###.###-##', this);" />
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="senha">Senha:</label>
				<input id="senha" type="password" class="form-control" name="senha">
			</div>
			<div class="form-group col-sm-6">
				<label for="confirmacaoSenha">Confirmação de Senha:</label>
				<input id="confirmacaoSenha" type="password" class="form-control" name="confirmacaoSenha">
			</div>
		</div>
		<div class="row buttons">
			<button id="confirmar" type="button" class="btn btn-success separar">Confirmar</button>
			<button id="limpar" type="button" class="btn btn-danger separar">Limpar tudo</button>
		</div>
	</form>
</div>
<br>
<div class="alert alert-success" role="alert"
     style="display: none; width: 25%; margin-left:37%; text-align: center;">
</div>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading titulo_lista"><h3>Lista de Usuários</h3></div>
        <div class="panel-body">
            <table class="table table-horvered table-striped" id="listaItens" style="display:none;">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>e-mail</th>
                    <th>Matrícula</th>
                    <th>CPF</th>
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
