package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Utilisateur;

public interface UtilisateurDAO {
 
	public void insert(Utilisateur utilisateur) throws SQLException; 
	public Utilisateur selectById(int no_utilisateur) throws Exception; 
	public List<Utilisateur> SelectAll(); 
	public void update(Utilisateur utilisateur); 
	public void delete(int no_utilisateur); 
	public Utilisateur seConnecter(String pseudo, String email, String motDePasse) throws SQLException;
}
