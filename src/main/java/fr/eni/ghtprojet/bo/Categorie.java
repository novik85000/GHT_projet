package fr.eni.ghtprojet.bo;

public class Categorie {
private int no_Categorie;
private String libelle;
public Categorie(int no_Categorie, String libelle) {
	super();
	this.no_Categorie = no_Categorie;
	this.libelle = libelle;
}
public int getNo_Categorie() {
	return no_Categorie;
}
public void setNo_Categorie(int no_Categorie) {
	this.no_Categorie = no_Categorie;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
@Override
public String toString() {
	return "Categorie [no_Categorie=" + no_Categorie + ", libelle=" + libelle + "]";
}

}
