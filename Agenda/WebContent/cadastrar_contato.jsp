<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.senai.sp.jandira.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");

	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormatBanco = new SimpleDateFormat("yyyy-MM-dd");

		String dtNasc;
		Date data = dateFormatBanco.parse(usuario.getDtNasc());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Contato</title>
<link href="CSS/Bootstrap.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="navbar navbar-default">
			<h1>Contatos</h1>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img style="margin-right: 10px;" src="imagens/user24.png"><strong>Usuário</strong>
						</h3>
					</div>
					<div class="panel-body">
						<p>
							<strong>Usuário:</strong>
							<%=usuario.getNome()%></p>
						<p>
							<strong>Cidade:</strong>
							<%=usuario.getCidade()%></p>
						<p>
							<strong>Data nascimento:</strong>
							<%=dtNasc = dateFormat.format(data)%></p>
						<p>&nbsp</p>
						<p>
							<a href="sair.jsp"><img style="margin-right: 10px;"
								src="imagens/exit24.png">Sair do sistema</a>
						</p>
					</div>
				</div>
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img style="margin-right: 10px;" src="imagens/menu24.png"><strong>Menu</strong>
						</h3>
					</div>
					<div class="panel-body">
						<ul class="nav">
							<li class="nav-item"><a href="index.jsp">Home</a></li>
							<li class="nav-item"><a href="cadastrar_contato.jsp">Adiconar
									Contato</a></li>
							<li class="nav-item"><a href="editar_usuario.jsp">Editar
									Usuário</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img style="margin-right: 10px;" src="imagens/users24.png"><strong>Meus
								Contatos</strong>
						</h3>
					</div>
					<div class="panel-body">
						<!-- FORMULÁRIO DE CADASTRO DE CONTATOS -->
						<form method="GET" action="GravarContato">
							<!-- LINHA 01 -->
							<fieldset>
								<legend>Dados gerais:</legend>
								<div class="form-row">
									<div class="form-group col-md-6">
										<input type="hidden" name="txtIdUsuario"
											value="<%=usuario.getId()%>"> <label for="txtNome">Nome:</label>
										<input type="text" name="txtNome" class="form-control"
											required="required" placeholder="Digite seu nome completo...">
									</div>
									<div class="form-group col-md-3">
										<label for="txtDtNasc">Dt. Nasc.:</label> <input type="date"
											name="txtDtNasc" class="form-control" required="required">
									</div>
									<div class="form-group col-md-3">
										<label for="cbSexo">Sexo:</label> <select name="cbSexo"
											class="form-control">
											<option value="s">Selecione</option>
											<option value="Feminino">Feminino</option>
											<option value="Masculino">Masculino</option>
										</select>
									</div>

								</div>
							</fieldset>
							<!-- LINHA 02 -->
							<fieldset>
								<legend>Dados de contato:</legend>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="txtEmail">E-mail:</label> <input type="mail"
											name="txtEmail" class="form-control" required="required" placeholder="Digite seu e-mail...">
									</div>
									<div class="form-group col-md-3">
										<label for="txtTelefone">Telefone:</label> <input type="text"
											name="txtTelefone" class="form-control phone-ddd-mask"
											required="required" placeholder="(00) 0000-0000">
									</div>
									<div class="form-group col-md-3">
										<label for="txtCelular">Celular:</label> <input type="text"
											name="txtCelular" class="form-control cel-sp-mask"
											required="required" placeholder="(00) 00000-0000">
									</div>

								</div>
							</fieldset>
							<!-- LINHA 03 -->
							<fieldset>
								<legend>Dados de endereço:</legend>
								<div class="form-row">
									<div class="form-group col-md-8">
										<label for="txtLogradouro">Logradouro:</label> <input
											type="text" name="txtLogradouro" class="form-control"
											required="required" placeholder="Ex: rua, avenida, alameda, etc...">
									</div>
									<div class="form-group col-md-4">
										<label for="txtBairro">Bairro:</label> <input type="text"
											name="txtBairro" class="form-control" required="required" placeholder="Digite seu bairro...">
									</div>
								</div>
								<div class="form-row">
									<div class="form-group col-md-6">
										<label for="txtCidade">Cidade:</label> <input type="text"
											name="txtCidade" class="form-control" required="required" placeholder="Digite sua cidade...">
									</div>
									<div class="form-group col-md-3">
										<label for="txtEstado">Estado:</label> <input type="text"
											name="txtEstado" class="form-control" required="required" placeholder="Sigla do estado...">
									</div>
									<div class="form-group col-md-3">
										<label for="txtCep">CEP:</label> <input type="text"
											name="txtCep" class="form-control cep-mask"
											required="required" placeholder="00000-000">
									</div>
								</div>
							</fieldset>

							<div class="form-row">
								<div class="col-md-12">
									<input type="submit" value="Salvar" class="btn btn-success" />
									<input type="reset" value="Limpar" class="btn btn-warning" />
									<a href="index.jsp" class="btn btn-danger">Cancelar</a>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</div>
	<script async="" src="//www.google-analytics.com/analytics.js"></script>
	<script type="text/javascript"
		src="//code.jquery.com/jquery-2.0.3.min.js"></script>
	<script type="text/javascript"
		src="//assets.locaweb.com.br/locastyle/2.0.6/javascripts/locastyle.js"></script>
	<script type="text/javascript"
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
</body>
</html>
<%
	}
%>