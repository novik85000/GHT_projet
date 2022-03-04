package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Utilisateur;

public interface ArticleDAO {
	public void insert(Article_vendu article) throws SQLException; 
	public Utilisateur selectById(int no_article); 
	public List<Article_vendu> SelectAll(); 
	public void update(Article_vendu article); 
	public void delete(int no_article); 
}
