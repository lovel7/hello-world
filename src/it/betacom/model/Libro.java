package it.betacom.model;

public class Libro {

	private int LibroID;
	private String Titolo;
	private int numPag;
	private int Anno;
	private int AutoreID;
	private int CodiceG;
	private int CodiceE;

	public Libro() {
		super();

	}

	public Libro(int libroID, String titolo, int numPag, int Anno, int autoreID, int codiceG, int codiceE) {
		super();
		LibroID = libroID;
		Titolo = titolo;
		this.numPag = numPag;
		this.Anno = Anno;
		AutoreID = autoreID;
		CodiceG = codiceG;
		CodiceE = codiceE;
	}

	public int getLibroID() {
		return LibroID;
	}

	public void setLibroID(int libroID) {
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

	public int getAnno() {
		return Anno;
	}

	public void setAnno(int anno) {
		this.Anno = anno;
	}

	public int getAutoreID() {
		return AutoreID;
	}

	public void setAutoreID(int autoreID) {
		AutoreID = autoreID;
	}

	public int getCodiceG() {
		return CodiceG;
	}

	public void setCodiceG(int codiceG) {
		CodiceG = codiceG;
	}

	public int getCodiceE() {
		return CodiceE;
	}

	public void setCodiceE(int codiceE) {
		CodiceE = codiceE;
	}

}
