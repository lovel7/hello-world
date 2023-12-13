package it.betacom.dao;

import java.util.List;

import it.betacom.model.Libro;

public interface LibroDao {
	
	// lista per ottenere libro
	List<Libro> getAllLibri();
	
	// metodo per avere libro in base all'ID
	Libro getLibroID(int id);
	
	// metodo inserimento libro
	void insertLibro (Libro libro);
	
	// metodo cancellazione libro
	void deleteLibro(Libro libro);
	
	// metodo update libro
	void updateLibro(Libro libro);
	
	

}
