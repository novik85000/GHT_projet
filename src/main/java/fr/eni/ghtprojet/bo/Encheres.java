package fr.eni.ghtprojet.bo;

import java.time.LocalDateTime;

public class Encheres {
private LocalDateTime dateEnchere;
private int montantEnchere;

public Encheres(LocalDateTime dateEnchere, int montantEnchere) {
	super();
	this.dateEnchere = dateEnchere;
	this.montantEnchere = montantEnchere;
}

public LocalDateTime getDateEnchere() {
	return dateEnchere;
}

public void setDateEnchere(LocalDateTime dateEnchere) {
	this.dateEnchere = dateEnchere;
}

public int getMontantEnchere() {
	return montantEnchere;
}

public void setMontantEnchere(int montantEnchere) {
	this.montantEnchere = montantEnchere;
}



}
