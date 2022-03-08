package fr.eni.ghtprojet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.utils.Connexion;

public class EnchereDAOImpl implements EnchereDAO {
	final private String SQL_INSERT_ENCHERES = "insert INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) \r\n"
			+ " VALUES (?, ?, ?, ?)";

	@Override
	public void insert(Encheres enchere) throws DALException {
		// préparation de la connection
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
		
		try {
			connection = Connexion.getConnection();
			stmt = connection.prepareStatement(SQL_INSERT_ENCHERES);
			
			// insertions des champs 
			stmt.setInt(1,enchere.getNo_utilisateur());
			stmt.setInt(2, enchere.getNo_article());
			stmt.setDate(3, java.sql.Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontantEnchere());
			
			System.out.println("set de statement a reussi");
			
			stmt.executeUpdate();
			// fermer la connection
			connection.close();
			
			System.out.println("insertion réussi");
			
		} catch (SQLException e) {
			throw new DALException("Insertion non réalisé - Enchere non valide  = " +  e);
		}

		

	}

	@Override
	public Encheres selectById(int no_article) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Encheres> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Encheres enchere) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no_article) {
		// TODO Auto-generated method stub

	}

}
