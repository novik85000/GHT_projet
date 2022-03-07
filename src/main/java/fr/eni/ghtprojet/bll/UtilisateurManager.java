package fr.eni.ghtprojet.bll;

import java.sql.SQLException;

import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.DAOFactory;
import fr.eni.ghtprojet.dal.UtilisateurDAO;
import fr.eni.ghtprojet.dal.UtilisateurDAOImpl;

public class UtilisateurManager {
	private static UtilisateurManager instance;
	private UtilisateurDAO dao;
	
	public UtilisateurManager () throws Exception {
	 dao = DAOFactory.getUtilisateurDAO();
	}
	
	public static UtilisateurManager getInstance() throws Exception {
		if (instance==null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	public Utilisateur seConnecter(String pseudo, String email, String mdp) throws Exception {
		Utilisateur user = null;
		user =  dao.seConnecter(pseudo, email, mdp);
		return user;
		
	}
	
	public void insert(Utilisateur utilisateur) throws SQLException {
		dao.insert(utilisateur);
	
	}
	
	public void update(Utilisateur utilisateur) throws SQLException {
		dao.update(utilisateur);
	
	}
	
	public void delete (int no_utilisateur) throws SQLException {
		dao.delete(no_utilisateur);
	
	}

	public Utilisateur selectById(int i) throws Exception {
		return dao.selectById(i);
	}
}

