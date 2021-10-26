package it.prova.discomusicale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discomusicale")
public class DiscoMusicale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "autore")
	private String autore;
	@Column(name = "numerotracce")
	private Integer numeroTracce;
	@Column(name = "datarilascio")
	private Date dataRilascio;

	public DiscoMusicale() {
		// TODO Auto-generated constructor stub
	}

	
	
	public DiscoMusicale(String titolo, String autore) {
		super();
		this.titolo = titolo;
		this.autore = autore;
	}

	public DiscoMusicale(String titolo, String autore, Integer numeroTracce, Date dataRilascio) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.numeroTracce = numeroTracce;
		this.dataRilascio = dataRilascio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Integer getNumeroTracce() {
		return numeroTracce;
	}

	public void setNumeroTracce(Integer numeroTracce) {
		this.numeroTracce = numeroTracce;
	}

	public Date getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	@Override
	public String toString() {
		return "DiscoMusicale [titolo=" + titolo + ", autore=" + autore + ", numeroTracce=" + numeroTracce
				+ ", dataRilascio=" + dataRilascio + "]";
	}
}
