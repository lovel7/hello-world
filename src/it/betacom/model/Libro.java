package it.betacom.model;

public class Libro {
	
	private String LibroID;
	private String Titolo;
	private int numPag;
	private String AutoreID;
	private String CodiceG;
	private String CodiceE;
	
	public Libro() {
		super();

	}

	public Libro(String libroID, String titolo, int numPag, String autoreID, String codiceG, String codiceE) {
		super();
		LibroID = libroID;
		Titolo = titolo;
		this.numPag = numPag;
		AutoreID = autoreID;
		CodiceG = codiceG;
		CodiceE = codiceE;
	}

	public String getLibroID() {
		return LibroID;
	}

	public void setLibroID(String libroID) {
		LibroID = libroID;
	}

	public String getTitolo() {
		return Titolo;
	}

	public void setTitolo(String titolo) {
		Titolo = titolo;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public String getAutoreID() {
		return AutoreID;
	}

	public void setAutoreID(String autoreID) {
		AutoreID = autoreID;
	}

	public String getCodiceG() {
		return CodiceG;
	}

	public void setCodiceG(String codiceG) {
		CodiceG = codiceG;
	}

	public String getCodiceE() {
		return CodiceE;
	}

	public void setCodiceE(String codiceE) {
		CodiceE = codiceE;
	}
	
	

}
