package br.senai.sp.jandira.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

@WebServlet("/GravarContato")
public class GravarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GravarContato() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		contato.setBairro(request.getParameter("txtBairro"));
		contato.setCelular(request.getParameter("txtCelular"));
		contato.setCep(request.getParameter("txtCep"));
		contato.setCidade(request.getParameter("txtCidade"));
		contato.setDtNasc(request.getParameter("txtDtNasc"));
		contato.setEmail(request.getParameter("txtEmail"));
		contato.setEstado(request.getParameter("txtEstado"));
		contato.setIdUsuario(Integer.parseInt(request.getParameter("txtIdUsuario")));
		contato.setLogradouro(request.getParameter("txtLogradouro"));
		contato.setNome(request.getParameter("txtNome"));
		contato.setSexo(request.getParameter("cbSexo"));
		contato.setTelefone(request.getParameter("txtTelefone"));
		
		ContatoDAO contatoDAO = new ContatoDAO(contato);
		
		RequestDispatcher rd;
		
		if(contatoDAO.gravarContato()){
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			rd = request.getRequestDispatcher("cadastrar_contato.jsp");
		}
		
		rd.forward(request, response);
	}

}
