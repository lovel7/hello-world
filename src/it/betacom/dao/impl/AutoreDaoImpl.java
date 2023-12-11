package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.AutoreDao;
import it.betacom.model.Autore;
import it.betacom.model.Editore;
import it.betacom.model.Genere;

public class AutoreDaoImpl implements AutoreDao {

	Connection con = null;
	Statement stm = null;
	PreparedStatement preparedStatement = null;

	// lista di appoggio
	private List<Autore> autoreList = new ArrayList<>();

	// costruttore che inizializza la connessione
	public AutoreDaoImpl() {
		String jdbcUrl = "jdbc:mysql://localhost:3306/eserciziolibri";
		String username = "root";
		String password = "root";

		// gestione errore nel caricamento driver e inizializzazione database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore durante l'inizializzazione del database");
		}
	}

	@Override
	public List<Autore> getAllAutori() {
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM autori");
			while (resultSet.next()) {
				Autore autore = new Autore();
				autore.setAutoreID(resultSet.getInt("AutoreID"));
				autore.setNome(resultSet.getString("Nome"));
				autore.setCognome(resultSet.getString("Cognome"));
				autore.setAnnoN(resultSet.getInt("AnnoN"));
				autore.setAnnoM(resultSet.getInt("AnnoM"));
				autore.setSesso(resultSet.getString("Sesso"));
				autore.setNazione(resultSet.getString("Nazione"));
				autoreList.add(autore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autoreList;
	}

	@Override
	public Autore getAutoreID(int id) {
		Autore autore = null;
		try {
			String query = "Select * from eserciziolibri.autori where AutoreID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				autore = new Autore();
				autore.setAutoreID(resultSet.getInt("AutoreID"));
				autore.setNome(resultSet.getString("Nome"));
				autore.setCognome(resultSet.getString("Cognome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autore;
	}

	@Override
	public void insertAutore(Autore autore) {
		try {
			// Verifico se l'autore esiste già nella lista
			if (autoreList.contains(autore)) {
				System.out.println("L'autore esiste già nella lista");
				return;
			}

			// Verifica se l'autore esiste già nel database
			String checkQuery = "SELECT * FROM eserciziolibri.autori WHERE AutoreID = ?";
			PreparedStatement checkStatement = con.prepareStatement(checkQuery);
			checkStatement.setInt(1, autore.getAutoreID());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("L'autore esiste già nel database");
				return;
			}

			// Inserisci l'autore nel database
			String insertQuery = "INSERT INTO eserciziolibri.autori VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, autore.getAutoreID());
			preparedStatement.setString(2, autore.getNome());
			preparedStatement.setString(3, autore.getCognome());
			preparedStatement.setInt(4, autore.getAnnoN());
			preparedStatement.setInt(5, autore.getAnnoM());
			preparedStatement.setString(6, autore.getSesso());
			preparedStatement.setString(7, autore.getNazione());

			int rowsAffected = preparedStatement.executeUpdate();
			autoreList.add(autore);
			System.out.println("Autore correttamente inserito");

		} catch (SQLException e) {
			System.out.println("Inserimento autore non riuscito");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAutore(Autore autore) {
		try {
			String query = "delete from eserciziolibri.autori where Nome = ? and Cognome = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, autore.getNome());
			preparedStatement.setString(2, autore.getCognome());
			preparedStatement.executeUpdate();
			autoreList.remove(autore);
			System.out.println("Autore cancellato correttamente");

		} catch (SQLException e) {
			System.out.println("Non è possibile cancellare l'autore");
			e.printStackTrace();
		}
	}

	@Override
	public void updateAutore(Autore autore) {
		// TODO Auto-generated method stub

	}

}
