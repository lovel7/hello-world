package it.betacom.model;

public class Editore {
	
	private int CodiceE;
	private String Nome;
	
	public Editore() {
		super();
	}

	public Editore(int codiceE, String nome) {
		super();
		CodiceE = codiceE;
		Nome = nome;
	}

	public int getCodiceE() {
		return CodiceE;
	}

	public void setCodiceE(int codiceE) {
		CodiceE = codiceE;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	
	
}
