package fr.eni.ghtprojet.bo;

import java.time.LocalDateTime;

public class Article_vendu {
private int no_Article;
private String nom_Article;
private String description;
private LocalDateTime dateDebutEncheres;
private LocalDateTime dateFinEncheres;
private int miseAPrix;
private int prixVente;
private String etatVente;
public Article_vendu(int no_Article, String nom_Article, String description, LocalDateTime dateDebutEncheres,
		LocalDateTime dateFinEncheres, int miseAPrix, int prixVente, String etatVente) {
	super();
	this.no_Article = no_Article;
	this.nom_Article = nom_Article;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.miseAPrix = miseAPrix;
	this.prixVente = prixVente;
	this.etatVente = etatVente;
}
public int getNo_Article() {
	return no_Article;
}
public void setNo_Article(int no_Article) {
	this.no_Article = no_Article;
}
public String getNom_Article() {
	return nom_Article;
}
public void setNom_Article(String nom_Article) {
	this.nom_Article = nom_Article;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDateTime getDateDebutEncheres() {
	return dateDebutEncheres;
}
public void setDateDebutEncheres(LocalDateTime dateDebutEncheres) {
	this.dateDebutEncheres = dateDebutEncheres;
}
public LocalDateTime getDateFinEncheres() {
	return dateFinEncheres;
}
public void setDateFinEncheres(LocalDateTime dateFinEncheres) {
	this.dateFinEncheres = dateFinEncheres;
}
public int getMiseAPrix() {
	return miseAPrix;
}
public void setMiseAPrix(int miseAPrix) {
	this.miseAPrix = miseAPrix;
}
public int getPrixVente() {
	return prixVente;
}
public void setPrixVente(int prixVente) {
	this.prixVente = prixVente;
}
public String getEtatVente() {
	return etatVente;
}
public void setEtatVente(String etatVente) {
	this.etatVente = etatVente;
}

}
