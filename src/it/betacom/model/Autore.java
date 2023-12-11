package it.betacom.model;

public class Autore {
	
	private int AutoreID;
	private String Nome;
	private String Cognome;
	private int AnnoN;
	private int AnnoM;
	private String Sesso;
	private String Nazione;
	
	public Autore() {
		super();
	}

	public Autore(int autoreID, String nome, String cognome, int annoN, int annoM, String sesso, String nazione) {
		super();
		AutoreID = autoreID;
		Nome = nome;
		Cognome = cognome;
		AnnoN = annoN;
		AnnoM = annoM;
		Sesso = sesso;
		Nazione = nazione;
	}

	public int getAutoreID() {
		return AutoreID;
	}

	public void setAutoreID(int autoreID) {
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

	public String getSesso() {
		return Sesso;
	}

	public void setSesso(String sesso) {
		Sesso = sesso;
	}

	public String getNazione() {
		return Nazione;
	}

	public void setNazione(String nazione) {
		Nazione = nazione;
	}

	@Override
	public String toString() {
		return "Autore [AutoreID=" + AutoreID + ", Nome=" + Nome + ", Cognome=" + Cognome + ", AnnoN=" + AnnoN
				+ ", AnnoM=" + AnnoM + ", Sesso=" + Sesso + ", Nazione=" + Nazione + "]";
	}
	
	

}
