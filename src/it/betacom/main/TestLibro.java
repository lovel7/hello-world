package it.betacom.main;

import java.util.List;

import it.betacom.dao.LibroDao;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.dao.impl.LibroDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;

public class TestLibro {

	public static void main(String[] args) {

		LibroDao libroDaoImpl = new LibroDaoImpl();
		List<Libro> libri = libroDaoImpl.getAllLibri();

		try {
			// Lista libri
			System.out.println("Es 4 \nLista dei libri presenti su Db:");

			for (Libro libro : libri) {
				System.out.println("ID libro: " + libro.getLibroID() + ", Titolo: " + libro.getTitolo() + " , Anno: "
						+ libro.getAnno() + ", AutoreID:  " + libro.getAutoreID() + ", CodiceG: " + libro.getCodiceG()
						+ ", CodiceE: " + libro.getCodiceE());
			}

			System.out.println("--------------------------------------------------");
			// trovo libro in base al codice
			System.out.println("Es 5 \nTrovare libro in base al suo codice:");

			Libro trovaLibro = libroDaoImpl.getLibroID(6);
			if (trovaLibro != null) {
				System.out.println("Il libro che si riferisce al codice " + trovaLibro.getLibroID() + " è: "
						+ trovaLibro.getTitolo());
			} else {
				System.out.println("Libro non trovato per il codice specificato.");
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 6 inserire nuovo libro");
			Libro nuovoLibro = new Libro(20, "Dieci Piccoli Indiani", 180, 1939, 9, 1, 5);
			libroDaoImpl.insertLibro(nuovoLibro);
			System.out.println("Lista aggiornata dopo inserimento:");
			for (Libro libro : libri) {
				System.out.println("ID libro: " + libro.getLibroID() + ", Titolo: " + libro.getTitolo() + " , Anno: "
						+ libro.getAnno() + ", AutoreID:  " + libro.getAutoreID() + ", CodiceG: " + libro.getCodiceG()
						+ ", CodiceE: " + libro.getCodiceE());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 7 cancellare libro");
			libroDaoImpl.deleteLibro(nuovoLibro);
			libri.remove(nuovoLibro);

			System.out.println("Lista aggiornata dopo cancellazione:");
			for (Libro libro : libri) {
				System.out.println("ID libro: " + libro.getLibroID() + ", Titolo: " + libro.getTitolo() + " , Anno: "
						+ libro.getAnno() + ", AutoreID:  " + libro.getAutoreID() + ", CodiceG: " + libro.getCodiceG()
						+ ", CodiceE: " + libro.getCodiceE());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 8 modificare libro");
			Libro libroDaModificare = new Libro(17, "Orlando", 680, 1928, 8, 4, 4);
			libroDaoImpl.updateLibro(libroDaModificare);
			System.out.println("Lista aggiornata dopo la modifica:");
			for (Libro libro : libri) {
				System.out.println("ID libro: " + libro.getLibroID() + ", Titolo: " + libro.getTitolo() + " , Anno: "
						+ libro.getAnno() + ", AutoreID:  " + libro.getAutoreID() + ", CodiceG: " + libro.getCodiceG()
						+ ", CodiceE: " + libro.getCodiceE());
			}

			// chiusura della connessione una volta terminato di usare l'oggetto
		} finally {
			((LibroDaoImpl) libroDaoImpl).closeConnection();
		}

	}

}