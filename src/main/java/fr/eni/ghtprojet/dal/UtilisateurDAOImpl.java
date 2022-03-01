package fr.eni.ghtprojet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.servlets.Connecter;
import fr.eni.ghtprojet.utils.Connexion;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private final static String SQL_SE_CONNECTER = "select * from UTILISATEURS where pseudo=? or email=? and mot_de_passe=?";

	public UtilisateurDAOImpl() {
	
	}
	

	@Override
	public void insert(Utilisateur utilisateur) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectById(int no_utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int no_utilisateur) {
		// TODO Auto-generated method stub
		
	}

	public Utilisateur seConnecter(String pseudo, String email, String motDePasse) throws SQLException {
		Utilisateur user = null;
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
		try {
			connection = Connexion.getConnection();
			stmt = connection.prepareStatement(SQL_SE_CONNECTER);
			stmt.setString(1, pseudo );
			stmt.setString(2, email);
			stmt.setString(3, motDePasse);
			System.out.println("set de statement a reussi");
			
			ResultSet rs = stmt.executeQuery();
			
			System.out.println("execution de sql statement a reussi");
			
			if (rs.next()) {
				user = new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getByte("administrateur")
						);
				
				System.out.println(user);
				System.out.println("creation de nouveau utilisateur a reussi");
				
			}
			connection.close();
			} catch (Exception e) {
				System.out.println("Erreur");
			}
		
		return user;
		
	}
}
