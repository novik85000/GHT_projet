/**
 * 
 */
package fr.eni.ghtprojet.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Categorie;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.utils.Connexion;

/**
 * @author gguegan2021
 *
 */
public class ArticleDAOImpl implements ArticleDAO {
	final private String SQL_INSERT_ARTICLE = "insert INTO ARTICLES_VENDUS (nom_article,description,"
			+ "date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_categorie, "
			+ "no_utilisateur,etat_vente,image) \r\n "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?) ";
	final private String SQL_INSERT_RETRAIT = "insert INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?) ";
	final private String SELECT_ARTICLES_VENDUS = "SELECT * FROM ARTICLES_VENDUS where no_article = ? ";
	final private String SQL_SELECT_ALL = "select * from ARTICLES_VENDUS ";
	final private String SQL_SELECT_BY_ID_CATEGORIES = "select * FROM CATEGORIES where no_categorie = ?";
	final private String SQL_UPDATE_ENCHERES = "UPDATE ARTICLES_VENDUS SET prix_vente=? WHERE no_article = ? ";
	final private String SQL_RECHERCHE_ARTICLE =  "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ? ";
	final private String APPEND_RECHERCE = "and no_categorie = ? ";
	
	
	@Override
	public void insert(Article_vendu article, Retrait retrait) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				stmt = connection.prepareStatement(SQL_INSERT_ARTICLE, stmt.RETURN_GENERATED_KEYS);
				stmt.setString(1, article.getNom_Article());
				stmt.setString(2, article.getDescription());
				stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
				stmt.setDate(4,  java.sql.Date.valueOf(article.getDateFinEncheres()));
				stmt.setInt(5, article.getPrixVente());
				stmt.setInt(6, article.getMiseAPrix());
				stmt.setInt(7, article.getNo_Categorie());
				stmt.setInt(8, article.getNo_Utilisateur());
				stmt.setString(9, article.getEtatVente());
				stmt.setString(10, article.getImage());
				
				stmt.executeUpdate();
				ResultSet rsId;
				
				rsId =  stmt.getGeneratedKeys();
				
				int noArticle = 0;
				
				if (rsId.next()) {
					noArticle =  rsId.getInt(1);
					}
				
				stmt = connection.prepareStatement(SQL_INSERT_RETRAIT);
				
				
				stmt.setInt(1, noArticle);
				stmt.setString(2, retrait.getRue());
				stmt.setString(3, retrait.getCode_Postal());
				stmt.setString(4, retrait.getVille());
				
				stmt.executeUpdate();
				System.out.println("Insertion réussi");
			} catch (SQLException e) {
				throw new DALException("Insertion non réalisé - Article non valide non valide  = " +  e);
			}
		
			
	}

	@Override
	public Article_vendu selectById(int no_article) {
		Connection connection = null;
		PreparedStatement stmt = null;
		Article_vendu article = null;
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				stmt = connection.prepareStatement(SELECT_ARTICLES_VENDUS);
				stmt.setInt(1, no_article);
				System.out.println("set de statement a reussi");
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					article = new Article_vendu (
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							String.valueOf(rs.getDate("date_debut_enchere")),
							String.valueOf(rs.getDate("date_fin_enchere")),
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							rs.getInt("no_utilisateur"),
							rs.getInt("no_categorie"),
							rs.getString("etat_vente"),
							rs.getString("image")
							);
				}
			connection.close();
			}
			
			catch (SQLException e) {
				System.out.println("select by id n'a pas r�ussi");
			}
			
		return article;
	}
	
	public Categorie selectById1(int no_categorie) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		Categorie categorie = null;
		
		try {
			connection = Connexion.getConnection();
			stmt = connection.prepareStatement(SQL_SELECT_BY_ID_CATEGORIES);
			stmt.setInt(1, no_categorie);
			System.out.println("set de statement a reussi");
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				categorie = new Categorie(
						rs.getInt("no_categorie"),
						rs.getString("libelle"));
			}
			connection.close();
			
		} catch (SQLException e) {
			throw new DALException("selectById failed - Numéro Article = " + no_categorie, e);
		}
		
		return categorie;
		
	}

	@Override
	public List<Article_vendu> SelectAll() {
		List<Article_vendu> listArticle = new ArrayList<>();
		Connection connection = null;
		PreparedStatement stmt = null;
		Article_vendu article = null;
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				stmt = connection.prepareStatement(SQL_SELECT_ALL);
				System.out.println("statement");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					listArticle.add(new Article_vendu (
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							String.valueOf(rs.getDate("date_debut_enchere")),
							String.valueOf(rs.getDate("date_fin_enchere")),
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							rs.getInt("no_utilisateur"),
							rs.getInt("no_categorie"),
							rs.getString("etat_vente"),
							rs.getString("image")));
					
				}
				
			} catch (SQLException e) {
				System.out.println("Select All n'ai pas reussi");
			}
		
		
		
		return listArticle;
	}

	@Override
	public void update(Encheres enchere) throws DALException {
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				stmt = connection.prepareStatement(SQL_UPDATE_ENCHERES);
				stmt.setInt(1, enchere.getMontantEnchere());
				stmt.setInt(2,enchere.getNo_article());
				
			
				System.out.println("set de statement a reussi");
				stmt.executeUpdate();
				
				System.out.println("update a reussi");
				
			connection.close();
			}
			
			catch (Exception e) {
				throw new DALException("update failed - enchere = " + enchere, e);
				
			}
			

	}

	@Override
	public void delete(int no_article) {
		

	}
	
	public List<Article_vendu> rechercheArticle(String rechercheParMot, int no_categorie) throws DALException {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		Article_vendu article = null;
		List<Article_vendu> listeArticle = new ArrayList<>();
		System.out.println("connection a reussi");
			try {
				connection = Connexion.getConnection();
				if (no_categorie!=0) {
					stmt = connection.prepareStatement(SQL_RECHERCHE_ARTICLE+APPEND_RECHERCE);
					stmt.setString(1, "%" + rechercheParMot + "%");
					stmt.setInt(2, no_categorie);
				}else {
					stmt = connection.prepareStatement(SQL_RECHERCHE_ARTICLE);
					stmt.setString(1, "%" + rechercheParMot + "%");
				}
				System.out.println("statement");
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					listeArticle.add(new Article_vendu (
							rs.getInt("no_article"),
							rs.getString("nom_article"),
							rs.getString("description"),
							String.valueOf(rs.getDate("date_debut_enchere")),
							String.valueOf(rs.getDate("date_fin_enchere")),
							rs.getInt("prix_initial"),
							rs.getInt("prix_vente"),
							rs.getInt("no_utilisateur"),
							rs.getInt("no_categorie"),
							rs.getString("etat_vente"),
							rs.getString("image")));
				}
					
			}catch (Exception e) {
				 throw new DALException("recherche failed - enchere = " +  e);
			}
			return listeArticle;
	}
}
