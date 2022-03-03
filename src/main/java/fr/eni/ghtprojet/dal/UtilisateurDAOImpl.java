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
	
	private final static String SQL_INSERT_UTILISATEUR = "insert INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit) VALUES (?,?,?,?,?,?, ?, ?,?,?)";
	
	public static boolean isInsere = false;

	
	
	public UtilisateurDAOImpl() {
	
	}
	

	@Override
	public void insert(Utilisateur utilisateur) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
		try {
			connection = Connexion.getConnection();
			stmt = connection.prepareStatement(SQL_INSERT_UTILISATEUR);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCode_Postal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMot_de_passe());
			stmt.setInt(10, utilisateur.getCredit());

			
			System.out.println("set de statement a reussi");
			
			stmt.executeUpdate();
			connection.close();
			System.out.println("Insertion d'utilisateur a reussi");
			isInsere = true;
			
			
			
		}
		catch (Exception e) {
			System.out.println("Insertion n'ai pas reussi");
			isInsere = false;
			
		}
		
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
				System.out.println("Erreur de se connecter");
			}
		
		return user;
		
	}
}
