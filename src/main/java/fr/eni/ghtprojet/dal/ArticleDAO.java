package fr.eni.ghtprojet.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Categorie;
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

public interface ArticleDAO {
	public void insert(Article_vendu article, Retrait retrait) throws DALException; 
	public Article_vendu selectById(int no_article); 
	public List<Article_vendu> SelectAll(); 
	public void update(Encheres enchere) throws DALException; 
	public void delete(int no_article); 
	public Categorie selectById1(int no_categorie) throws DALException; 
	public List<Article_vendu> rechercheArticle(String rechercheParMot, int no_categorie) throws DALException;
}
