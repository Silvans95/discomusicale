package it.prova.discomusicale.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.discomusicale.model.DiscoMusicale;


//nel nome della classe vi è DiscoMusicale in quanto è una classe specifica
public class UtilityDiscoMusicaleForm {

	public static DiscoMusicale createDiscoMusicaleFromParams(String titoloInputParam, String autoreInputParam,
			String numeroTracceInputStringParam, String dataRilascioStringParam) {

		DiscoMusicale result = new DiscoMusicale(titoloInputParam, autoreInputParam);

		if (NumberUtils.isCreatable(numeroTracceInputStringParam)) {
			result.setNumeroTracce(Integer.parseInt(numeroTracceInputStringParam));
		}
		result.setDataRilascio(parseDateArrivoFromString(dataRilascioStringParam));

		return result;
	}

	public static boolean validateDiscoMusicaleBean(DiscoMusicale discoMusicaleToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(discoMusicaleToBeValidated.getTitolo())
				|| StringUtils.isBlank(discoMusicaleToBeValidated.getAutore())
				|| discoMusicaleToBeValidated.getNumeroTracce() == null 
				|| discoMusicaleToBeValidated.getNumeroTracce() < 1
				|| discoMusicaleToBeValidated.getDataRilascio() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataRilascioStringParam) {
		if (StringUtils.isBlank(dataRilascioStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataRilascioStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
