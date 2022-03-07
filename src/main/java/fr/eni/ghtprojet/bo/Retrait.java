package fr.eni.ghtprojet.bo;

public class Retrait {
private String rue;
private String code_Postal;
private String ville;
private int no_article;

public Retrait(String rue, String code_Postal, String ville) {
	this.rue = rue;
	this.code_Postal = code_Postal;
	this.ville = ville;
}

public Retrait(int no_article, String rue, String code_Postal, String ville) {
	this.no_article = no_article;
	this.rue = rue;
	this.code_Postal = code_Postal;
	this.ville = ville;
}

public String getRue() {
	return rue;
}

public void setRue(String rue) {
	this.rue = rue;
}

public String getCode_Postal() {
	return code_Postal;
}

public void setCode_Postal(String code_Postal) {
	this.code_Postal = code_Postal;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}



public int getNo_article() {
	return no_article;
}

public void setNo_article(int no_article) {
	this.no_article = no_article;
}

@Override
public String toString() {
	return "Retrait [rue=" + rue + ", code_Postal=" + code_Postal + ", ville=" + ville + "]";
}

}
