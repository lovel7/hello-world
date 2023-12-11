package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.GenereDao;
import it.betacom.model.Genere;

public class GenereDaoImpl implements GenereDao {

	Connection con = null;
	Statement stm = null;
	PreparedStatement preparedStatement = null;

	// lista di appoggio
	private List<Genere> genereList = new ArrayList<>();

	// costruttore che inizializza la connessione
	public GenereDaoImpl() {
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

	// metodo che restituisce lista generi
	@Override
	public List<Genere> getAllGenere() {

		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM genere");
			while (resultSet.next()) {
				Genere genere = new Genere();
				genere.setCodiceG(resultSet.getInt("codiceG"));
				genere.setTipo(resultSet.getString("Tipo"));
				genereList.add(genere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genereList;
	}

	@Override
	public Genere getCodiceG(int codiceG) {
		Genere genere = null;
		try {
			String query = "Select * from eserciziolibri.genere where CodiceG = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, codiceG);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				genere = new Genere();
				genere.setCodiceG(resultSet.getInt("CodiceG"));
				genere.setTipo(resultSet.getString("Tipo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genere;
	}

	@Override
	public void insertGenere(Genere genere) {

		try {
			// Verifico se il genere esiste già nella lista
			if (genereList.contains(genere)) {
				System.out.println("Il genere esiste già nella lista");
				return; 
			}

			// Verifica se il genere esiste già nel database
			String checkQuery = "SELECT * FROM eserciziolibri.genere WHERE codiceG = ?";
			PreparedStatement checkStatement = con.prepareStatement(checkQuery);
			checkStatement.setInt(1, genere.getCodiceG());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("Il genere esiste già nel database");
				return; 
			}

			// Inserisci il genere nel database
			String insertQuery = "INSERT INTO eserciziolibri.genere VALUES (?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, genere.getCodiceG());
			preparedStatement.setString(2, genere.getTipo());
			int rowsAffected = preparedStatement.executeUpdate();
			genereList.add(genere);
			System.out.println("Genere correttamente inserito");

		} catch (SQLException e) {
			System.out.println("Inserimento genere non riuscito");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteGenere(Genere genere) {
		try {
			String query = "delete from eserciziolibri.genere where CodiceG = ? and Tipo = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, genere.getCodiceG());
			preparedStatement.setString(2, genere.getTipo());
			preparedStatement.executeUpdate();
			genereList.remove(genere);
			System.out.println("Genere cancellato correttamente");

		} catch (SQLException e) {
			System.out.println("Non è possibile cancellare il genere");
			e.printStackTrace();
		}
	}

	@Override
	public void updateGenere(Genere genere) {
		try {
			String query = "UPDATE eserciziolibri.genere SET Tipo = ? WHERE codiceG = ?";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, genere.getTipo());
			preparedStatement.setInt(2, genere.getCodiceG());
			preparedStatement.executeUpdate();
			System.out.println("Genere modificato correttamente");
			// aggiornamento lista dopo update
			for (Genere g : genereList) {
				if (g.getCodiceG() == genere.getCodiceG()) {
					g.setTipo(genere.getTipo());
					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("Non è possibile modificare il genere");
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
