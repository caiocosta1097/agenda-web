<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.senai.sp.jandira.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");

	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo Usuário</title>
<link href="CSS/Bootstrap.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="navbar navbar-default">
			<h1>iContatos</h1>
		</div>
	</header>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3>Editar usuário</h3>
					</div>
					<div class="panel-body">
						<form action="EditarUsuario" method="POST">
							<fieldset>
								<legend>Dados Gerais</legend>

								<!-- Linha 1 do form -->
								<div class="form-row">
									<div class="form-group col-md-6">
										<input type="hidden" name="txtIdUsuario"
											value="<%=usuario.getId()%>">
										<label for="txtNome">Nome:</label> <input class="form-control"
											type="text" name="txtNome" required="required" value="<%=usuario.getNome()  %>">

									</div>
									<div class="form-group col-md-3">

										<label for="txtCidade">Cidade:</label> <input
											class="form-control" type="text" name="txtCidade"
											required="required" value="<%=usuario.getCidade()  %>">

									</div>
									<div class="form-group col-md-3">

										<label for="txtDtNasc">Data de nascimento:</label> <input
											class="form-control" type="date" name="txtDtNasc"
											required="required" value="<%=usuario.getDtNasc()  %>">

									</div>


								</div>

							</fieldset>
							<fieldset>
								<legend>Dados para autenticação:</legend>

								<!-- Linha 2 do form -->
								<div class="form-row">

									<div class="form-group col-md-6">

										<label for="txtEmail">E-mail:</label> <input
											class="form-control" type="email" name="txtEmail"
											required="required" value="<%=usuario.getEmail()%>">

									</div>
									<div class="form-group col-md-3">
										<input type="hidden" name="txtSenha"
											value="<%=usuario.getSenha()%>">

										<label for="txtSenha"> Nova senha:</label> <input
											class="form-control" type="password" name="txtSenhaNova">

									</div>
									<div class="form-group col-md-3">

										<label for="txtConfSenha">Confirmar senha:</label> <input
											class="form-control" type="password" name="txtConfSenha">

									</div>


								</div>

							</fieldset>
							<hr>

							<!-- Linha 3 do form -->
							<div class="form-row">

								<div class="form-group col-md-12">
									<input type="submit" value="Salvar"
										class="btn btn-success"> 
										<a href="index.jsp"
										class="btn btn-danger">Cancelar</a>
								</div>

							</div>

						</form>

					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>

<%
	}
%>