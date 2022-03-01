package fr.eni.ghtprojet.dal;

public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() throws Exception {
		return new UtilisateurDAOImpl();
	}
}
