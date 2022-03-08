package fr.eni.ghtprojet.bll;

import java.sql.SQLException;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.ArticleDAO;
import fr.eni.ghtprojet.dal.DALException;
import fr.eni.ghtprojet.dal.DAOFactory;
import fr.eni.ghtprojet.dal.DAORetraits;
import fr.eni.ghtprojet.dal.UtilisateurDAO;

public class RetraitManager {
	private static RetraitManager instance;
	private DAORetraits dao;
	
	public RetraitManager () throws Exception {
	 dao = DAOFactory.getDAORetraits();
	}
	
	public static RetraitManager getInstance() throws Exception {
		if (instance==null) {
			instance = new RetraitManager();
		}
		return instance;
	}
	
	public Retrait selectById(int no_article)throws DALException {
		
		return  dao.selectById(no_article);
		
	}
	
	
}
