package it.betacom.model;

public class Autore {
	
	private String AutoreID;
	private String Nome;
	private String Cognome;
	private int AnnoN;
	private int AnnoM;
	private char Sesso;
	private String Nazione;
	
	public Autore() {
		super();
	}

	public Autore(String autoreID, String nome, String cognome, int annoN, int annoM, char sesso, String nazione) {
		super();
		AutoreID = autoreID;
		Nome = nome;
		Cognome = cognome;
		AnnoN = annoN;
		AnnoM = annoM;
		Sesso = sesso;
		Nazione = nazione;
	}

	public String getAutoreID() {
		return AutoreID;
	}

	public void setAutoreID(String autoreID) {
		AutoreID = autoreID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public int getAnnoN() {
		return AnnoN;
	}

	public void setAnnoN(int annoN) {
		AnnoN = annoN;
	}

	public int getAnnoM() {
		return AnnoM;
	}

	public void setAnnoM(int annoM) {
		AnnoM = annoM;
	}

	public char getSesso() {
		return Sesso;
	}

	public void setSesso(char sesso) {
		Sesso = sesso;
	}

	public String getNazione() {
		return Nazione;
	}

	public void setNazione(String nazione) {
		Nazione = nazione;
	}
	
	

}
