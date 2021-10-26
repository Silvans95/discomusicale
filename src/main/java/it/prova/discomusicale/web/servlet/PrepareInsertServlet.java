package it.prova.discomusicale.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.discomusicale.model.DiscoMusicale;


@WebServlet("/PrepareInsertServlet")
public class PrepareInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//metto un bean 'vuoto' in request perché per la pagina risulta necessario
		request.setAttribute("insert_discoMusicale_attr", new DiscoMusicale());
		request.getRequestDispatcher("/discomusicale/insert.jsp").forward(request, response);

	}

}
