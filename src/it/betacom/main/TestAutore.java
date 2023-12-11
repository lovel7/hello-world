package it.betacom.main;

import java.util.List;

import it.betacom.dao.AutoreDao;
import it.betacom.dao.impl.AutoreDaoImpl;
import it.betacom.model.Autore;

public class TestAutore {

	public static void main(String[] args) {

		AutoreDao autoreDaoImpl = new AutoreDaoImpl();
		List<Autore> autori = autoreDaoImpl.getAllAutori();

		// Lista autori
		System.out.println("Es 4 \nLista dei autori presenti su Db:");
		System.out
				.println("Autore ID   | nome         | cognome        | Anno N    | Anno M      | Sesso     | Nazione");
		for (Autore autore : autori) {
			System.out.println(autore.getAutoreID() + ": " + autore.getNome() + autore.getCognome()
					+ autore.getAnnoN() + autore.getAnnoM() + autore.getSesso() + autore.getNazione());
		}

	}

}
