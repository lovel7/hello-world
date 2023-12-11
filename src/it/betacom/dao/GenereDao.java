package it.betacom.dao;

import java.util.List;

import it.betacom.model.Genere;

public interface GenereDao {

	// lista per ottenere genere
	List<Genere> getAllGenere();

	// metodo per avere genere in base codiceGenere
	Genere getCodiceG(int codiceG);

	// metodo inserimento genere
	void insertGenere(Genere genere);

	// metodo cancellazione genere
	void deleteGenere(Genere genere);

	// metodo update genere
	void updateGenere(Genere genere);

}
