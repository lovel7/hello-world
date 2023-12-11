package it.betacom.model;

public class Genere {

	private int CodiceG;
	private String Tipo;

	public Genere() {
		super();
	}

	public Genere(int codiceG, String tipo) {
		super();
		CodiceG = codiceG;
		Tipo = tipo;
	}

	public int getCodiceG() {
		return CodiceG;
	}

	public void setCodiceG(int codiceG) {
		CodiceG = codiceG;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	@Override
	public String toString() {
		return "Genere [CodiceG=" + CodiceG + ", Tipo=" + Tipo + "]";
	}

}
