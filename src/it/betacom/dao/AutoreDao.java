package it.betacom.dao;

import java.util.List;

import it.betacom.model.Autore;

public interface AutoreDao {
	
	// lista per ottenere autore
	List<Autore> getAllAutori();
	
	// metodo per avere autore in base all'ID
	Autore getAutoreID(String id);
	
	// metodo inserimento autore
	void insertAutore (Autore autore);
	
	// metodo cancellazione autore
	void deleteAutore(Autore autore);
	
	// metodo update autore
	void updateAutore(Autore autore);
	
	

	

}
