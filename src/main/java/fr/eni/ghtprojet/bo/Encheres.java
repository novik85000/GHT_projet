package fr.eni.ghtprojet.bo;

import java.time.LocalDateTime;

public class Encheres {
private String dateEnchere;
private int montantEnchere;
private int no_utilisateur; 
private int no_article;

public Encheres(String dateEnchere, int montantEnchere) {
	super();
	this.dateEnchere = dateEnchere;
	this.montantEnchere = montantEnchere;
}

public Encheres(int no_utilisateur, int no_article,String dateEnchere, int montantEnchere) {
	this.no_utilisateur = no_utilisateur; 
	this.no_article = no_article;
	this.dateEnchere = dateEnchere;
	this.montantEnchere = montantEnchere;
}

public String getDateEnchere() {
	return dateEnchere;
}

public void setDateEnchere(String dateEnchere) {
	this.dateEnchere = dateEnchere;
}

public int getMontantEnchere() {
	return montantEnchere;
}

public void setMontantEnchere(int montantEnchere) {
	this.montantEnchere = montantEnchere;
}

public int getNo_utilisateur() {
	return no_utilisateur;
}

public void setNo_utilisateur(int no_utilisateur) {
	this.no_utilisateur = no_utilisateur;
}

public int getNo_article() {
	return no_article;
}

public void setNo_article(int no_article) {
	this.no_article = no_article;
}

@Override
public String toString() {
	return "Encheres [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", no_utilisateur="
			+ no_utilisateur + ", no_article=" + no_article + "]";
}


}





