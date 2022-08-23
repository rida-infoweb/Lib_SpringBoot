package com.mglcl.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Revue extends Document{
	
private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRevue;

@Column(unique= true)
@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
private String reference ;

@OneToMany(mappedBy="revue",fetch = FetchType.LAZY)
private Set<Emprunt> emprunts;

@NotNull
@NotBlank (message = "Ce champ est obligatoire !")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date anneePublication;

public Revue() {
	super();
}

public int getIdRevue() {
	return idRevue;
}

public void setIdRevue(int idRevue) {
	this.idRevue = idRevue;
}

public String getReference() {
	return reference;
}

public void setReference(String reference) {
	this.reference = reference;
}

public Set<Emprunt> getEmprunts() {
	return emprunts;
}

public void setEmprunts(Set<Emprunt> emprunts) {
	this.emprunts = emprunts;
}

public Date getAnneePublication() {
	return anneePublication;
}

public void setAnneePublication(Date anneePublication) {
	this.anneePublication = anneePublication;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}
