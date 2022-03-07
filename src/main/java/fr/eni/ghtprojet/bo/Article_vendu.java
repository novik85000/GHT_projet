package fr.eni.ghtprojet.bo;

import java.sql.Date;
import java.time.LocalDateTime;

public class Article_vendu {
private int no_Article;
private String nom_Article;
private String description;
private Date dateDebutEncheres;
private Date dateFinEncheres;
private int miseAPrix;
private int prixVente;
private String etatVente;
private int no_Categorie; 
private int no_Utilisateur;
private String image; 
/**
 * Création d'un constructeur prenant tous les champs en compte 
 * @param no_Article
 * @param nom_Article
 * @param description
 * @param dateDebutEncheres
 * @param dateFinEncheres
 * @param miseAPrix
 * @param prixVente
 * @param etatVente
 * @param no_categorie
 * @param no_Utilisateur
 * @param image
 */
public Article_vendu(int no_Article, String nom_Article, String description, Date dateDebutEncheres,
		Date dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int no_categorie,int no_Utilisateur, String image) {
	super();
	this.no_Article = no_Article;
	this.nom_Article = nom_Article;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.miseAPrix = miseAPrix;
	this.prixVente = prixVente;
	this.etatVente = etatVente;
	this.no_Categorie = no_categorie;
	this.no_Utilisateur = no_Utilisateur;
	this.image = image;
}

/**
 * Constructeur ne prenant pas en compte le numéro de l'article car s'implémente de lui même dans la base
 * @param nom_Article
 * @param description
 * @param dateDebutEncheres
 * @param dateFinEncheres
 * @param miseAPrix
 * @param prixVente
 * @param etatVente
 * @param no_categorie
 * @param no_Utilisateur
 * @param image
 */
public Article_vendu(String nom_Article, String description, Date dateDebutEncheres,
		Date dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int no_categorie,int no_Utilisateur, String image) {
	super();
	
	this.nom_Article = nom_Article;
	this.description = description;
	this.dateDebutEncheres = dateDebutEncheres;
	this.dateFinEncheres = dateFinEncheres;
	this.miseAPrix = miseAPrix;
	this.prixVente = prixVente;
	this.etatVente = etatVente;
	this.no_Categorie = no_categorie;
	this.no_Utilisateur = no_Utilisateur;
	this.image = image;
}

// Déclaration des méthodes Setters and Getters 
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
public Date getDateDebutEncheres() {
	return dateDebutEncheres;
}
public void setDateDebutEncheres(Date dateDebutEncheres) {
	this.dateDebutEncheres = dateDebutEncheres;
}
public Date getDateFinEncheres() {
	return dateFinEncheres;
}
public void setDateFinEncheres(Date dateFinEncheres) {
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

public int getNo_Categorie() {
	return no_Categorie;
}
public void setNo_Categorie(int no_Categorie) {
	this.no_Categorie = no_Categorie;
}

public int getNo_Utilisateur() {
	return no_Utilisateur;
}
public void setNo_Utilisateur(int no_Utilisateur) {
	this.no_Utilisateur = no_Utilisateur;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

// Déclaration de la méthode to String
@Override
public String toString() {
	return "Article_vendu [no_Article=" + no_Article + ", nom_Article=" + nom_Article + ", description=" + description
			+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
			+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", no_Categorie=" + no_Categorie
			+ ", no_Utilisateur=" + no_Utilisateur + "]";
}





}
