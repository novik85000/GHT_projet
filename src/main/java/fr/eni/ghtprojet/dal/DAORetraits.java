package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

public interface DAORetraits {
	public void insert(Retrait retrait) throws SQLException; 
	public Retrait selectById(int no_article) throws DALException, Exception; 
	public List<Retrait> SelectAll(); 
	public void update(Retrait retrait); 
	public void delete(int no_article); 
}
