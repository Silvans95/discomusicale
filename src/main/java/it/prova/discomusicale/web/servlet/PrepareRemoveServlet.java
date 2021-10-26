package it.prova.discomusicale.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.discomusicale.service.MyServiceFactory;


@WebServlet("/PrepareRemoveServlet")
public class PrepareRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrepareRemoveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idDiscoMusicaleParam = request.getParameter("discoMusicaleDaRimuovere");

		if (!NumberUtils.isCreatable(idDiscoMusicaleParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("discoMusicaleDaRimuovere", MyServiceFactory.getDiscoMusicaleServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idDiscoMusicaleParam)));
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/discomusicale/remove.jsp").forward(request, response);

	}
}
