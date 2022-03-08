package fr.eni.ghtprojet.bll;

import java.sql.SQLException;

import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.DALException;
import fr.eni.ghtprojet.dal.DAOFactory;
import fr.eni.ghtprojet.dal.EnchereDAO;
import fr.eni.ghtprojet.dal.UtilisateurDAO;

public class EnchereManager {
	
		private static EnchereManager instance;
		private EnchereDAO dao;
		
		public EnchereManager () throws Exception {
		 dao = DAOFactory.getEnchereDAO();
		}

		public static EnchereManager getInstance() throws Exception {
			if (instance==null) {
				instance = new EnchereManager();
			}
			return instance;
		}
		
		public void insert(Encheres enchere) throws DALException {
			dao.insert(enchere);
		
		}
}
