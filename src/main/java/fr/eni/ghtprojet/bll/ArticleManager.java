package fr.eni.ghtprojet.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Categorie;
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.ArticleDAO;
import fr.eni.ghtprojet.dal.DALException;
import fr.eni.ghtprojet.dal.DAOFactory;
import fr.eni.ghtprojet.dal.UtilisateurDAO;

public class ArticleManager {
	private static ArticleManager instance;
	private ArticleDAO dao;
	
	public ArticleManager () throws Exception {
	 dao = DAOFactory.getArticleDAO();
	}
	
	public static ArticleManager getInstance() throws Exception {
		if (instance==null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	public void insert(Article_vendu article, Retrait retrait) throws DALException {
		dao.insert(article, retrait);
	
	}
	
	public Article_vendu selectById(int no_article) {
		return dao.selectById(no_article);
	}
	
	public List<Article_vendu> selectAll() {
		return dao.SelectAll();
	}
	
	public Categorie selectById1 (int no_categorie)throws DALException  {
		return dao.selectById1(no_categorie);
	}
	
	 public void update (Encheres enchere) throws DALException{
		 dao.update(enchere);
		 
	 }
	 public List<Article_vendu> rechercheArticle(String rechercheParMot, int no_categorie) throws DALException {
		return dao.rechercheArticle(rechercheParMot, no_categorie);
		 
	 }
}
