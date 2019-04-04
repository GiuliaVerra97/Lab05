package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	

	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?useTimezone=true&serverTimezone=UTC&user=root&password=ulla97";
	static private Connection connection = null;

	public static Connection getConnection() {

		try {
			if (connection == null || connection.isClosed()) {			//devo avviare la connessione e quindi verificare che non sia chiusa, ma non la metto in questo caso perchè da errore 
				connection = DriverManager.getConnection(jdbcUrl);
			}
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
	

}
