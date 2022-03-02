/**
 * 
 */
package fr.eni.ghtprojet.bo;

/**
 * @author gguegan2021
 *
 */
public class Utilisateur {
	private int no_Utilisateur;
	private String pseudo; 
	private String nom; 
	private String prenom;
	private String email; 
	private String telephone; 
	private String rue;
	private String code_Postal;
	private String ville;
	private String mot_de_passe;
	private  int credit; 
	private byte administrateur;
	
	
	public Utilisateur(int no_Utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_Postal, String ville, String mot_de_passe, int credit, byte administrateur) {
		this.no_Utilisateur = no_Utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_Postal = code_Postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_Postal, String ville, String mot_de_passe, int credit, byte administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_Postal = code_Postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_Postal, String ville, String mot_de_passe, int credit) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_Postal = code_Postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
	}


	public int getNo_Utilisateur() {
		return no_Utilisateur;
	}


	public void setNo_Utilisateur(int no_Utilisateur) {
		this.no_Utilisateur = no_Utilisateur;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
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


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	public byte getAdministrateur() {
		return administrateur;
	}


	public void setAdministrateur(byte administrateur) {
		this.administrateur = administrateur;
	}


	@Override
	public String toString() {
		return "Utilisateur [no_Utilisateur=" + no_Utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", code_Postal="
				+ code_Postal + ", ville=" + ville + ", mot_de_passe=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}
	
	
	
	
	
	
	
	
}
