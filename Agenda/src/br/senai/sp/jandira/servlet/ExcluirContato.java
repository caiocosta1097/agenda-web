package br.senai.sp.jandira.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.jandira.dao.ContatoDAO;

@WebServlet("/ExcluirContato")
public class ExcluirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirContato() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContatoDAO contatoDAO = new ContatoDAO();

		RequestDispatcher rd;

		if (contatoDAO.excluirContato(request.getParameter("txtIdContato"))) {
			rd = request.getRequestDispatcher("index.jsp");
		} else {
			rd = request.getRequestDispatcher("excluir_contato.jsp");
		}

		rd.forward(request, response);
	}

}
