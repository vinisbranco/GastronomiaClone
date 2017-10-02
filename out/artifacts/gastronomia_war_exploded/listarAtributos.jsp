
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="/includes/_header.jsp"></jsp:include>


<div class="panel-footer lista">
	<div class="panel-heading titulo_lista"><h2>Lista de Atributos</h2></div>
	<table class="table table-striped tamanhoFonte_tabela">
		<tr>
			<th><h3>Nome do Atributo</h3></th>
			<th><h3>Unidade de Medida</h3></th>
			<th><h3>Multiplicador</h3></th>
			<th><h3>Editar</h3></th>
			<th><h3>Excluir</h3></th>
		</tr>
		<tr>
			<td>Calcio</td>
			<td>G</td>
			<td>2.5</td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button></td>
		</tr>
		<tr>
			<td>Ferro</td>
			<td>G</td>
			<td>2.5</td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button></td>
		</tr>
		<tr>
			<td>*</td>
			<td>*</td>
			<td>*</td> 
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button></td>
		</tr>
		<tr>
			<td>*</td>
			<td>*</td> 
			<td>*</td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></td>
			<td><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span></button></td>
		</tr>
	</table>
</div>
	
<jsp:include page="/includes/_footer.jsp"></jsp:include>
