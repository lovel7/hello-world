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

public class AutoreDaoImpl implements AutoreDao{
	
	Connection con = null;
	Statement stm = null;
	PreparedStatement preparedStatement = null;

	//lista di appoggio
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAutore(Autore autore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAutore(Autore autore) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAutore(Autore autore) {
		// TODO Auto-generated method stub
		
	}

}
