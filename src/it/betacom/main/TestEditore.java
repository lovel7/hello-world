package it.betacom.main;

import java.util.List;

import it.betacom.dao.EditoreDao;
import it.betacom.dao.impl.EditoreDaoImpl;
import it.betacom.model.Editore;

public class TestEditore {

	public static void main(String[] args) {

		EditoreDao editoreDaoImpl = new EditoreDaoImpl();
		List<Editore> editori = editoreDaoImpl.getAllEditori();

		try {

			// Lista editori
			System.out.println("Es 4 \nLista degli editori presenti su Db:");

			for (Editore editore : editori) {
				System.out.println(editore.getCodiceE() + ": " + editore.getNome());
			}

			System.out.println("--------------------------------------------------");
			// trovo editore in base al codice
			System.out.println("Es 5 \nTrovare editore in base al suo codice:");

			Editore trovaEditore = editoreDaoImpl.getCodiceE(2);
			if (trovaEditore != null) {
				System.out.println("L'editore che si riferisce al codice " + trovaEditore.getCodiceE() + " è: "
						+ trovaEditore.getNome());
			} else {
				System.out.println("Editore non trovato per il codice specificato.");
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 6 inserire nuovo editore");
			Editore nuovoEditore1 = new Editore(3, "Laterza");
			Editore nuovoEditore2 = new Editore(4, "De Agostini");
			Editore nuovoEditore3 = new Editore(5, "Bompiani");
			Editore nuovoEditore4 = new Editore(6, "Adelphi");
			editoreDaoImpl.insertEditore(nuovoEditore1);
			editoreDaoImpl.insertEditore(nuovoEditore2);
			editoreDaoImpl.insertEditore(nuovoEditore3);
			editoreDaoImpl.insertEditore(nuovoEditore4);
			System.out.println("Lista aggiornata dopo inserimento:");
			for (Editore editore : editori) {
				System.out.println(editore.getCodiceE() + ": " + editore.getNome());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 7 cancellare editore");
			editoreDaoImpl.deleteEditore(nuovoEditore4);
			System.out.println("Lista aggiornata dopo cancellazione:");

			for (Editore editore : editori) {
				System.out.println(editore.getCodiceE() + ": " + editore.getNome());
			}

			System.out.println("--------------------------------------------------");
			System.out.println("Es 8 modificare l'editore");
			Editore editoreDaModificare = new Editore(4, "De Laurentis");
			editoreDaoImpl.updateEditore(editoreDaModificare);
			System.out.println("Lista aggiornata dopo la modifica:");
			for (Editore editore : editori) {
				System.out.println(editore.getCodiceE() + ": " + editore.getNome());
			}

			// chiusura della connessione una volta terminato di usare l'oggetto
			// chiusura della connessione una volta terminato di usare l'oggetto
		} finally {
			((EditoreDaoImpl) editoreDaoImpl).closeConnection();
		}

	}

}
