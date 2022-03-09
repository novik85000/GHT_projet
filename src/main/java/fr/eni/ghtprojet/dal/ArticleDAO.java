package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Categorie;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

public interface ArticleDAO {
	public void insert(Article_vendu article, Retrait retrait) throws SQLException; 
	public Article_vendu selectById(int no_article); 
	public List<Article_vendu> SelectAll(); 
	public void update(Article_vendu article); 
	public void delete(int no_article); 
	public Categorie selectById1(int no_categorie); 
}
