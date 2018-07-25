package br.senai.sp.jandira.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.jandira.dao.UsuarioDAO;
import br.senai.sp.jandira.model.Usuario;


@WebServlet("/Autentica")
public class Autentica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Autentica() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		HttpSession session = null;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = usuarioDAO.autenticar(email, senha);		
		RequestDispatcher rd;
		
		if(usuario == null){
			rd = request.getRequestDispatcher("login.html");
		} else {
			session = request.getSession();
			session.setAttribute("usuario", usuario);
			rd = request.getRequestDispatcher("index.jsp");
		}
		rd.forward(request, response);
	}

}
