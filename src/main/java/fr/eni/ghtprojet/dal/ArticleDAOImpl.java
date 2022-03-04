/**
 * 
 */
package fr.eni.ghtprojet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.utils.Connexion;

/**
 * @author gguegan2021
 *
 */
public class ArticleDAOImpl implements ArticleDAO {
	final private String SQL_INSERT_ARTCILE = "insert INTO ARTICLES_VENDUS (nom_article,description,"
			+ "date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_categorie, "
			+ "no_utilisateur,etat_vente,image) \r\n "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
	@Override
	public void insert(Article_vendu article) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				stmt = connection.prepareStatement(SQL_INSERT_ARTCILE);
				stmt.setString(1, article.getNom_Article());
				stmt.setString(2, article.getDescription());
				stmt.setDate(3, article.getDateDebutEncheres());
				stmt.setDate(4, article.getDateFinEncheres());
				stmt.setInt(5, article.getPrixVente());
				stmt.setInt(6, article.getMiseAPrix());
				stmt.setInt(7, article.getNo_Categorie());
				stmt.setInt(8, article.getNo_Utilisateur());
				stmt.setString(9, article.getEtatVente());
				stmt.setString(10, article.getImage());
				
				stmt.executeUpdate();
				System.out.println("Insertion réussi");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	}

	@Override
	public Utilisateur selectById(int no_article) {

		return null;
	}

	@Override
	public List<Article_vendu> SelectAll() {
		
		return null;
	}

	@Override
	public void update(Article_vendu article) {


	}

	@Override
	public void delete(int no_article) {
		

	}

}
