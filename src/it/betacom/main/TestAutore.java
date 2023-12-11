package it.betacom.main;

import java.util.List;

import it.betacom.dao.AutoreDao;
import it.betacom.dao.impl.AutoreDaoImpl;
import it.betacom.model.Autore;
import it.betacom.model.Genere;

public class TestAutore {

	public static void main(String[] args) {

		AutoreDao autoreDaoImpl = new AutoreDaoImpl();
		List<Autore> autori = autoreDaoImpl.getAllAutori();

		// Lista autori
		System.out.println("Es 4 \nLista dei autori presenti su Db:");
		for (Autore autore : autori) {
			System.out.println("ID autore: " + autore.getAutoreID() + ", Nome: " + autore.getNome() + " , Cognome: "
					+ autore.getCognome() + ", AnnoN:  " + autore.getAnnoN() + ", AnnoM: " + autore.getAnnoM()
					+ ", Sesso: " + autore.getSesso() + ", Nazione: " + autore.getNazione());
		}

		System.out.println("--------------------------------------------------");
		// trovo autore in base al codice
		System.out.println("Es 5 \nTrovare autore in base al suo codice:");

		Autore trovaAutore = autoreDaoImpl.getAutoreID(5);
		if (trovaAutore != null) {
			System.out.println("L'autore che si riferisce al codice " + trovaAutore.getAutoreID() + " è: "
					+ trovaAutore.getNome() + " " + trovaAutore.getCognome());
		} else {
			System.out.println("Autore non trovato per il codice specificato.");
		}

		System.out.println("--------------------------------------------------");
		System.out.println("Es 6 inserire nuovo autore");
		Autore nuovoAutore = new Autore(10, "Charles", "Dickens", 1812, 1870, "M", "Inghilterra");
		autoreDaoImpl.insertAutore(nuovoAutore);
		System.out.println("Lista aggiornata dopo inserimento:");
		for (Autore autore : autori) {
			System.out.println("ID autore: " + autore.getAutoreID() + ", Nome: " + autore.getNome() + " , Cognome: "
					+ autore.getCognome() + ", AnnoN:  " + autore.getAnnoN() + ", AnnoM: " + autore.getAnnoM()
					+ ", Sesso: " + autore.getSesso() + ", Nazione: " + autore.getNazione());
		}

		System.out.println("--------------------------------------------------");
		System.out.println("Es 7 cancellare autore");
		autoreDaoImpl.deleteAutore(nuovoAutore);
		System.out.println("Lista aggiornata dopo cancellazione:");
		autori.remove(nuovoAutore);
		for (Autore autore : autori) {
			System.out.println("ID autore: " + autore.getAutoreID() + ", Nome: " + autore.getNome() + " , Cognome: "
					+ autore.getCognome() + ", AnnoN:  " + autore.getAnnoN() + ", AnnoM: " + autore.getAnnoM()
					+ ", Sesso: " + autore.getSesso() + ", Nazione: " + autore.getNazione());
		}
		
		
		
		
		

	}

}
