package it.prova.discomusicale.service;

import it.prova.discomusicale.dao.DiscoMusicaleDAO;
import it.prova.discomusicale.dao.DiscoMusicaleDAOImpl;
import it.prova.discomusicale.service.DiscoMusicaleServiceImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static DiscoMusicaleService DISCOMUSICALE_SERVICE_INSTANCE = null;
	private static DiscoMusicaleDAO DISCOMUSICALEDAO_INSTANCE = null;

	public static DiscoMusicaleService getDiscoMusicaleServiceInstance() {
		if (DISCOMUSICALE_SERVICE_INSTANCE == null)
			DISCOMUSICALE_SERVICE_INSTANCE = new DiscoMusicaleServiceImpl();

		if (DISCOMUSICALEDAO_INSTANCE == null)
			DISCOMUSICALEDAO_INSTANCE = new DiscoMusicaleDAOImpl();

		DISCOMUSICALE_SERVICE_INSTANCE.setDiscoMusicaleDao(DISCOMUSICALEDAO_INSTANCE);

		return DISCOMUSICALE_SERVICE_INSTANCE;
	}

}
