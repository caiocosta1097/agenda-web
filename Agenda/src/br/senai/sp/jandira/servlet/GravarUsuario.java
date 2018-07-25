package br.senai.sp.jandira.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.jandira.dao.UsuarioDAO;
import br.senai.sp.jandira.model.Usuario;

@WebServlet("/GravarUsuario")
public class GravarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GravarUsuario() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("txtNome"));
		usuario.setDtNasc(request.getParameter("txtDtNasc"));
		usuario.setCidade(request.getParameter("txtCidade"));
		usuario.setEmail(request.getParameter("txtEmail"));
		usuario.setSenha(request.getParameter("txtSenha"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		RequestDispatcher rd;
		
		if(usuarioDAO.gravar(usuario)){
			rd = request.getRequestDispatcher("sucesso_2.html");
		} else {
			rd = request.getRequestDispatcher("novo_usuario.html");
		}
		
		rd.forward(request, response);
	}

}
