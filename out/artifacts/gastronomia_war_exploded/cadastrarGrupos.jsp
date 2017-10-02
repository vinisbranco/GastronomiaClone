<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="./includes/_header.jsp"></jsp:include>

<script type="text/javascript" src="./assets/js/cadastrarGrupo.js"></script>

<div class="container" id="numero1">
	<form id="formulario">
		<h1>Cadastro de Grupo de Receita</h1>
		<div class="row">
			<div class="form-group col-sm-6">
				<label for="nome">Nome do grupo de receita:</label>
				<input id="nome" type="search" class="form-control" name="nome">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-3">
				<label for="custo">Valor da Porção (em gramas):</label>
				<div class="input-group">
					<input id="custo" type="search" class="form-control" name="porcao">
					<span class="input-group-addon">g</span>
				</div>
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
		<div class="panel-heading titulo_lista"><h3>Lista de Grupos de Receita</h3></div>
		<div class="panel-body">
			<table class="table table-horvered table-striped" id="listaItens" style="display:none;">
				<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Valor da Porção (em gramas)</th>
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