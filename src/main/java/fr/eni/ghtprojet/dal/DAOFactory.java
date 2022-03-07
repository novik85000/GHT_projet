package fr.eni.ghtprojet.dal;

public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() throws Exception {
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleDAO getArticleDAO() throws Exception {
		return new ArticleDAOImpl();
	}
	public static DAORetraits getDAORetraits() throws Exception {
		return new RetraitDAOImpl();
	}
}
