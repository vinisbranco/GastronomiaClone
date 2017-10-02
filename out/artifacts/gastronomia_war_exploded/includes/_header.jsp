<%@ page import="java.net.URLDecoder" %>
<%-- <%@ page import="br.com.ideiasages.authorization.Role" %>
<%@ page import="br.com.ideiasages.authorization.LoggedUser" %> --%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%-- <%
    LoggedUser userEntity = (LoggedUser) request.getAttribute("user");
%> --%>
<!DOCTYPE html>
<html lang="en">
 
 	<head>
		<title>Projeto Gastronomia</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="/assets/css/style.css">
		<script src="./assets/js/jquery.min.js"></script>
		<script src="./assets/js/dominio.js"></script>
		<script src="./assets/js/bootstrap.min.js"></script>
    </head>
    <body>
<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" style="font-weight: bold" href="#">Gastronomia</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro
        				<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="cadastrarIngrediente.jsp">Cadastro de Ingredientes</a></li>
							<li><a href="cadastrarGrupos.jsp">Cadastro de Grupos</a></li>
							<li><a href="cadastrarAtributos.jsp">Cadastro de Atributos</a></li>
							<li><a href="cadastrarUsuario.jsp">Cadastro de Usuários</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
