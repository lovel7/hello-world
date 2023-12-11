package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.EditoreDao;
import it.betacom.model.Editore;
import it.betacom.model.Genere;

public class EditoreDaoImpl implements EditoreDao {

	Connection con = null;
	Statement stm = null;
	PreparedStatement preparedStatement = null;

	// lista di appoggio
	private List<Editore> editoreList = new ArrayList<>();

	// costruttore che inizializza la connessione
	public EditoreDaoImpl() {
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
	public List<Editore> getAllEditori() {
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM editori");
			while (resultSet.next()) {
				Editore editore = new Editore();
				editore.setCodiceE(resultSet.getInt("codiceE"));
				editore.setNome(resultSet.getString("Nome"));
				editoreList.add(editore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editoreList;
	}

	@Override
	public Editore getCodiceE(int id) {
		Editore editore = null;
		try {
			String query = "Select * from eserciziolibri.editori where CodiceE = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				editore = new Editore();
				editore.setCodiceE(resultSet.getInt("CodiceE"));
				editore.setNome(resultSet.getString("Nome"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return editore;
	}

	@Override
	public void insertEditore(Editore editore) {
		try {
			// Verifico se il genere esiste già nella lista
			if (editoreList.contains(editore)) {
				System.out.println("L'editore esiste già nella lista");
				return;
			}

			// Verifica se l'editore esiste già nel database
			String checkQuery = "SELECT * FROM eserciziolibri.editori WHERE codiceE = ?";
			PreparedStatement checkStatement = con.prepareStatement(checkQuery);
			checkStatement.setInt(1, editore.getCodiceE());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("L'editore esiste già nel database");
				return;
			}

			// Inserisci l'editore nel database
			String insertQuery = "INSERT INTO eserciziolibri.editori VALUES (?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, editore.getCodiceE());
			preparedStatement.setString(2, editore.getNome());
			int rowsAffected = preparedStatement.executeUpdate();
			editoreList.add(editore);
			System.out.println("Editore correttamente inserito");

		} catch (SQLException e) {
			System.out.println("Inserimento editore non riuscito");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEditore(Editore editore) {
		try {
			
			String query = "delete from eserciziolibri.editori where CodiceE = ? and Nome = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, editore.getCodiceE());
			preparedStatement.setString(2, editore.getNome());
			preparedStatement.executeUpdate();
			editoreList.remove(editore);
			System.out.println("Editore cancellato correttamente");

		} catch (SQLException e) {
			System.out.println("Non è possibile cancellare l'editore");
			e.printStackTrace();
		} 
	}

	@Override
	public void updateEditore(Editore editore) {
		try {
			String query = "UPDATE eserciziolibri.editori SET Nome = ? WHERE codiceE = ?";

			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, editore.getNome());
			preparedStatement.setInt(2, editore.getCodiceE());
			preparedStatement.executeUpdate();
			System.out.println("Editore modificato correttamente");
			// aggiornamento lista dopo update
			for (Editore e : editoreList) {
				if (e.getCodiceE() == editore.getCodiceE()) {
					e.setNome(editore.getNome());
					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("Non è possibile modificare l'editore");
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
