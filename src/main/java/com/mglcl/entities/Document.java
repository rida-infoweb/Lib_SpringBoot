package com.mglcl.entities;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Document implements Serializable {
private static final long serialVersionUID = 1L;

private float prixDeVente;

public Document()  {
	super();
	//TODO Auto-generated constructor stub
}
public Document(float prixDeVente) {
	super();
	this.prixDeVente = prixDeVente;
}

public float getPrixDeVente() {
	return prixDeVente;
}

public void setPrixDeVente(float prixDeVente) {
	this.prixDeVente = prixDeVente;
}


}
