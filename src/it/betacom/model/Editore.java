package it.betacom.model;

public class Editore {
	
	private String CodiceE;
	private String Nome;
	
	public Editore() {
		super();
	}

	public Editore(String codiceE, String nome) {
		super();
		CodiceE = codiceE;
		Nome = nome;
	}

	public String getCodiceE() {
		return CodiceE;
	}

	public void setCodiceE(String codiceE) {
		CodiceE = codiceE;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	
	
}
