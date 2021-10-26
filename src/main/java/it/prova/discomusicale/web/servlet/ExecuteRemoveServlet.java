package it.prova.discomusicale.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.discomusicale.model.DiscoMusicale;
import it.prova.discomusicale.service.MyServiceFactory;


@WebServlet("/ExecuteRemoveServlet")
public class ExecuteRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteRemoveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idDiscoMusicaleParam = request.getParameter("idDaRimuovere");

		if (!NumberUtils.isCreatable(idDiscoMusicaleParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			Long idDiscoMusicale = Long.parseLong(idDiscoMusicaleParam);

			DiscoMusicale discoMusicaleDaRimuovere = MyServiceFactory.getDiscoMusicaleServiceInstance()
					.caricaSingoloElemento(idDiscoMusicale);
			MyServiceFactory.getDiscoMusicaleServiceInstance().rimuovi(discoMusicaleDaRimuovere);
			request.setAttribute("listAttribute", MyServiceFactory.getDiscoMusicaleServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/discomusicale/results.jsp").forward(request, response);
	}

}
