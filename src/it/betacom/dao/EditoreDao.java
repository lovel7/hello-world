package it.betacom.dao;

import java.util.List;

import it.betacom.model.Editore;

public interface EditoreDao {
	
	// lista per ottenere editore
		List<Editore> getAllEditori();
		
		// metodo per avere editore in base all'ID
		Editore getCodiceE(int id);
		
		// metodo inserimento editore
		void insertEditore (Editore editore);
		
		// metodo cancellazione editore
		void deleteEditore(Editore editore);
		
		// metodo update editore
		void updateEditore(Editore editore);
		
		


}
