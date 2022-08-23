package com.mglcl.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Dictionnaire extends Document  {

private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idDictionnaire;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String identificateurDictionnaire ;

@NotNull
@ManyToOne
@JoinColumn(name="idLangue")
private Langue langue;

@OneToMany(mappedBy="dictionnaire",fetch = FetchType.LAZY)
private Set<Emprunt> emprunts;

public Dictionnaire() {
	super();
	// TODO Auto-generated constructor stub
}


public int getIdDictionnaire() {
	return idDictionnaire;
}


public void setIdDictionnaire(int idDictionnaire) {
	this.idDictionnaire = idDictionnaire;
}


public String getIdentificateurDictionnaire() {
	return identificateurDictionnaire;
}


public void setIdentificateurDictionnaire(String identificateurDictionnaire) {
	this.identificateurDictionnaire = identificateurDictionnaire;
}


public Langue getLangue() {
	return langue;
}


public void setLangue(Langue langue) {
	this.langue = langue;
}


public Set<Emprunt> getEmprunts() {
	return emprunts;
}


public void setEmprunts(Set<Emprunt> emprunts) {
	this.emprunts = emprunts;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


}
