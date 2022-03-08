package fr.eni.ghtprojet.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connexion {
	
private static DataSource dataSource;
	
	static {
		Context context;
		try {
			context = new InitialContext();		
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			System.out.println("Erreur de connection - context");
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection() throws SQLException {		
		
		return dataSource.getConnection();
	}
	
	
}