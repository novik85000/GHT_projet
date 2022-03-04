package fr.eni.ghtprojet.bll;

import java.sql.SQLException;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.ArticleDAO;
import fr.eni.ghtprojet.dal.DAOFactory;
import fr.eni.ghtprojet.dal.UtilisateurDAO;

public class ArticleManager {
	private static ArticleManager instance;
	private ArticleDAO dao;
	
	public ArticleManager () throws Exception {
	 dao = DAOFactory.getArtcileDAO();
	}
	
	public static ArticleManager getInstance() throws Exception {
		if (instance==null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	public void insert(Article_vendu article) throws SQLException {
		dao.insert(article);
	
	}
}
