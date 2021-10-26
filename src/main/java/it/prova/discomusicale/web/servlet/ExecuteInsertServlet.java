package it.prova.discomusicale.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.discomusicale.model.DiscoMusicale;
import it.prova.discomusicale.service.MyServiceFactory;
import it.prova.discomusicale.utility.UtilityDiscoMusicaleForm;

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String titoloInputParam = request.getParameter("titolo");
		String autoreInputParam = request.getParameter("autore");
		String numeroTracceInputStringParam = request.getParameter("numeroTracce");
		String dataRilascioStringParam = request.getParameter("dataRilascio");

		// preparo un bean (che mi serve sia per tornare in pagina
		// che per inserire) e faccio il binding dei parametri
		DiscoMusicale discoMusicaleInstance = UtilityDiscoMusicaleForm.createDiscoMusicaleFromParams(titoloInputParam,
				autoreInputParam, numeroTracceInputStringParam, dataRilascioStringParam);

		// se la validazione non risulta ok
		if (!UtilityDiscoMusicaleForm.validateDiscoMusicaleBean(discoMusicaleInstance)) {
			request.setAttribute("insert_discoMusicale_attr", discoMusicaleInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/discomusicale/insert.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			MyServiceFactory.getDiscoMusicaleServiceInstance().inserisciNuovo(discoMusicaleInstance);
			request.setAttribute("listAttribute", MyServiceFactory.getDiscoMusicaleServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/discomusicale/results.jsp").forward(request, response);

	}

}
