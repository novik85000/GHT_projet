package fr.eni.ghtprojet.bo;

public class Retrait {
private String rue;
private String code_Postal;
private String ville;

public Retrait(String rue, String code_Postal) {
	super();
	this.rue = rue;
	this.code_Postal = code_Postal;
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

}
