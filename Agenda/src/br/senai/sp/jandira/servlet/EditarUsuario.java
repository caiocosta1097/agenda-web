package br.senai.sp.jandira.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.jandira.dao.UsuarioDAO;
import br.senai.sp.jandira.model.Usuario;

@WebServlet("/EditarUsuario")
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarUsuario() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();
		
		usuario.setId(Integer.parseInt(request.getParameter("txtIdUsuario")));
		usuario.setNome(request.getParameter("txtNome"));
		usuario.setDtNasc(request.getParameter("txtDtNasc"));
		usuario.setCidade(request.getParameter("txtCidade"));
		usuario.setEmail(request.getParameter("txtEmail"));
		
		if(request.getParameter("txtSenhaNova").equals("")){
			usuario.setSenha(request.getParameter("txtSenha"));
		}else{
			usuario.setSenha(request.getParameter("txtSenhaNova"));
		}

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		RequestDispatcher rd;
		HttpSession session = null;
		

		if (usuarioDAO.atualizarUsuario(usuario)) {
			session = request.getSession();
			session.setAttribute("usuario", usuario);
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			rd = request.getRequestDispatcher("editar_usuario.jsp");
		}

		rd.forward(request, response);
	}

}
