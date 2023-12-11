package it.betacom.main;

import java.util.List;

import it.betacom.dao.GenereDao;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.model.Genere;

public class TestGenere {

	public static void main(String[] args) {

		GenereDao genereDaoImpl = new GenereDaoImpl();
		List<Genere> generi = genereDaoImpl.getAllGenere();

		try {

			// Lista generi
			System.out.println("Es 4 \nLista dei generi presenti su Db:");

			for (Genere genere : generi) {
				System.out.println(genere.getCodiceG() + ": " + genere.getTipo());
			}

			System.out.println("--------------------------------------------------");
			// trovo genere in base al codice
			System.out.println("Es 5 \nTrovare genere in base al suo codice:");

			Genere trovaGenere = genereDaoImpl.getCodiceG(1);
			if (trovaGenere != null) {
				System.out.println("IL genere che si riferisce al codice " + trovaGenere.getCodiceG() + " è: "
						+ trovaGenere.getTipo());
			} else {
				System.out.println("Genere non trovato per il codice specificato.");
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 6 inserire nuovo genere");
			Genere nuovoGenere = new Genere(5, "Narrativa");
			genereDaoImpl.insertGenere(nuovoGenere);
			System.out.println("Lista aggiornata dopo inserimento:");
			for (Genere genere : generi) {
				System.out.println(genere.getCodiceG() + ": " + genere.getTipo());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 7 cancellare genere");
			Genere genereDaCancellare = new Genere(5, "Narrativa" + "");
			genereDaoImpl.deleteGenere(nuovoGenere);
			System.out.println("Lista aggiornata dopo cancellazione:");
			for (Genere genere : generi) {
				System.out.println(genere.getCodiceG() + ": " + genere.getTipo());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 8 modificare genere");
			Genere genereDaModificare = new Genere(1, "Gialli del 900");
			genereDaoImpl.updateGenere(genereDaModificare);
			System.out.println("Lista aggiornata dopo cancellazione:");
			for (Genere genere : generi) {
				System.out.println(genere.getCodiceG() + ": " + genere.getTipo());
			}

			// chiusura della connessione una volta terminato di usare l'oggetto
		} finally {
			((GenereDaoImpl) genereDaoImpl).closeConnection();
		}

	}

}
