<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.senai.sp.jandira.dao.ContatoDAO"%>
<%@page import="br.senai.sp.jandira.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.jandira.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = new Usuario();	
	usuario = (Usuario) session.getAttribute("usuario");
	
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO contatoDAO = new ContatoDAO();
		contatos = contatoDAO.getContatos(usuario.getId());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormatBanco = new SimpleDateFormat("yyyy-MM-dd");
		String dtNasc;
		Date data = dateFormatBanco.parse(usuario.getDtNasc());
		
		
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>
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
			<div class="col-md-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">
							<img style="margin-right: 10px;" src="imagens/user24.png"><strong>Usuário</strong>
						</h3>
					</div>
					<div class="panel-body">
						<p><strong>Usuário:</strong> <%= usuario.getNome() %></p>
						<p><strong>Cidade:</strong> <%= usuario.getCidade() %></p>
						<p><strong>Data nascimento:</strong> <%= dtNasc = dateFormat.format(data) %></p>
						<p>&nbsp</p>
						<p><a href="sair.jsp"><img style="margin-right: 10px;" src="imagens/exit24.png">Sair do sistema</a></p>
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
							<li class="nav-item"><a href="cadastrar_contato.jsp">Adiconar Contato</a></li>
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
							<img style="margin-right: 10px;" src="imagens/users24.png"><strong>Meus Contatos</strong>
						</h3>
					</div>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>E-mail</th>
								</tr>
							</thead>
							<tbody>
								<% for (Contato contato: contatos){ %>
									<tr>
										<td><%= contato.getId() %></td>
										<td><%= contato.getNome() %></td>
										<td><%= contato.getEmail() %></td>
										<td><a href="editar_contato.jsp?idContato=<%= contato.getId() %>"><img src="imagens/edit24.png"></a></td>
									<td><a href="excluir_contato.jsp?idContato=<%= contato.getId() %>"><img src="imagens/delete24.png"></a></td>
									</tr>
								<% } %>	
							</tbody>
						</table>
					</div>
					<div class="panel-footer"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<% } %>