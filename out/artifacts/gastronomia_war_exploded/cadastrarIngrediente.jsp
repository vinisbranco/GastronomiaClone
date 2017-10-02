<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="./includes/_header.jsp"></jsp:include>
		
<div class='container' id=''>
	<h1>Cadastro de Ingredientes</h1>
	<form id='cadastroIngredientes'>

	</form>
	<form id='tabela'>
		
		<div id='col_nome' class='row coluna'>
			<div class='form-group col-sm-6'>
				<label for='nome'>Nome do ingrediente:</label>
				<input id='nome' type='search' class='form-control'>
			</div>
		</div>
		<div id='col_atributos' class='row coluna'>	
			<div class='form-group col-sm-2'>
				<label for='atributo1'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo1' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo2'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo2' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo3'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo3' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo4'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo4' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo5'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo5' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo6'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo6' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo7'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo7' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo8'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo8' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo9'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo9' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
			<div class='form-group col-sm-2'>
				<label for='atributo10'>Nome do atributo:</label>
					<div class='input-group'>
						<input id='atributo10' type='search' class='form-control'>
						<span class='input-group-addon'>g</span>
					</div>
			</div>
		</div>
		<div class='row coluna buttons'>
			<button id='confirmar' type='button' class='btn btn-success separar'>Confirmar</button>
			<button id='limpar' type='reset' class='btn btn-danger separar'>Limpar tudo</button>
		</div>
	</form>
</div>

<br>

<div class='container' id='numero2'>
	<div class='panel-footer lista'>
		<div class='panel-heading titulo_lista'>
		<h1>Ingredientes</h1></div>
		<table class='table table-striped coluna'>
			<tr> 
				<th>Visualizar</th>
				<th>Nome do ingrediente</th>
				<th>-</th>
			</tr>
			<tr>
				<td><button type='button' class='btn btn-default'><span class='glyphicon glyphicon-pencil'></span></button></td>
				<td>Sal</td>
				<td>
					<div class='btn-group'>
					<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
						Ações <span class='caret'></span>
					</button>
					<ul class='dropdown-menu'>
						<li><a href='#'>Editar</a></li>
						<li role='separator' class='divider'></li>
						<li><a href='#'>Deletar</a></li>
					</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>		

<jsp:include page="./includes/_footer.jsp"></jsp:include>
