package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.LibroDao;
import it.betacom.model.Autore;
import it.betacom.model.Genere;
import it.betacom.model.Libro;

public class LibroDaoImpl implements LibroDao {

	Connection con = null;
	Statement stm = null;
	PreparedStatement preparedStatement = null;

	// lista di appoggio
	private List<Libro> libroList = new ArrayList<>();

	// costruttore che inizializza la connessione
	public LibroDaoImpl() {
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
	public List<Libro> getAllLibri() {
		try {
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM eserciziolibri.libri");
			while (resultSet.next()) {
				Libro libro = new Libro();
				libro.setLibroID(resultSet.getInt("libroID"));
				libro.setTitolo(resultSet.getString("Titolo"));
				libro.setNumPag(resultSet.getInt("numPag"));
				libro.setAnno(resultSet.getInt("Anno"));
				libro.setAutoreID(resultSet.getInt("AutoreID"));
				libro.setCodiceG(resultSet.getInt("CodiceG"));
				libro.setCodiceE(resultSet.getInt("CodiceE"));

				libroList.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libroList;
	}

	@Override
	public Libro getLibroID(int id) {
		Libro libro = null;
		try {
			String query = "Select * from eserciziolibri.libri where LibroID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				libro = new Libro();
				libro.setLibroID(resultSet.getInt("LibroID"));
				libro.setTitolo(resultSet.getString("Titolo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libro;
	}

	@Override
	public void insertLibro(Libro libro) {

		try {
			// Verifico se il libro esiste già nella lista
			if (libroList.contains(libro)) {
				System.out.println("Il libro esiste già nella lista");
				return;
			}

			// Verifica se il libro esiste già nel database
			String checkQuery = "SELECT * FROM eserciziolibri.libri WHERE LibroID = ?";
			PreparedStatement checkStatement = con.prepareStatement(checkQuery);
			checkStatement.setInt(1, libro.getLibroID());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("Il libro esiste già nel database");
				return;
			}

			// Inserisci il libro nel database
			String insertQuery = "INSERT INTO eserciziolibri.libri VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setInt(1, libro.getLibroID());
			preparedStatement.setString(2, libro.getTitolo());
			preparedStatement.setInt(3, libro.getNumPag());
			preparedStatement.setInt(4, libro.getAnno());
			preparedStatement.setInt(5, libro.getAutoreID());
			preparedStatement.setInt(6, libro.getCodiceG());
			preparedStatement.setInt(7, libro.getCodiceE());

			// mancano gli altri set

			int rowsAffected = preparedStatement.executeUpdate();
			libroList.add(libro);
			System.out.println("Libro correttamente inserito");

		} catch (SQLException e) {
			System.out.println("Inserimento libro non riuscito");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLibro(Libro libro) {
		try {
			String query = "delete from eserciziolibri.libri where Titolo = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, libro.getTitolo());
			preparedStatement.executeUpdate();
			libroList.remove(libro);
			System.out.println("Libro cancellato correttamente");

		} catch (SQLException e) {
			System.out.println("Non è possibile cancellare il libro");
			e.printStackTrace();
		}
	}

	@Override
	public void updateLibro(Libro libro) {
		try {
			String query = "UPDATE eserciziolibri.libri SET Titolo = ?, numPag = ?, Anno = ?, AutoreID = ?, CodiceG = ?, COdiceE = ? WHERE LibroID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, libro.getTitolo());
			preparedStatement.setInt(2, libro.getNumPag());
			preparedStatement.setInt(3, libro.getAnno());
			preparedStatement.setInt(4, libro.getAutoreID());
			preparedStatement.setInt(5, libro.getCodiceG());
			preparedStatement.setInt(6, libro.getCodiceE());
			preparedStatement.setInt(7, libro.getLibroID());
			preparedStatement.executeUpdate();
			System.out.println("Libro modificato correttamente");

			// aggiornamento lista dopo update
			for (Libro l : libroList) {
				if (l.getLibroID() == libro.getLibroID()) {
					l.setTitolo(libro.getTitolo());
					l.setAnno(libro.getAnno());
					l.setNumPag(libro.getNumPag());
					l.setAutoreID(libro.getAutoreID());
					l.setCodiceG(libro.getCodiceG());
					l.setCodiceE(libro.getCodiceE());

					break;
				}
			}

		} catch (SQLException e) {
			System.out.println("Non è possibile cancellare il libro");
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