package it.prova.discomusicale.service;

import java.util.List;

import it.prova.discomusicale.dao.DiscoMusicaleDAO;
import it.prova.discomusicale.model.DiscoMusicale;

public interface DiscoMusicaleService  {

	// questo mi serve per injection
	public void setDiscoMusicaleDao(DiscoMusicaleDAO discoMusicaleDao);

	public List<DiscoMusicale> listAll() throws Exception;

	public DiscoMusicale caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(DiscoMusicale input) throws Exception;

	public void inserisciNuovo(DiscoMusicale input) throws Exception;

	public void rimuovi(DiscoMusicale input) throws Exception;

	public List<DiscoMusicale> findByExample(DiscoMusicale input) throws Exception;


}
