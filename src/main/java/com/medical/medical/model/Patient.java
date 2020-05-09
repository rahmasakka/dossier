package com.medical.medical.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medical.medical.model.Consultation;

@Entity
@Table(name="Patient", uniqueConstraints={@UniqueConstraint(columnNames={"user_name"})})

public class Patient {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nom", nullable = false)
    private String nom;
    @Column(name="prenom", nullable = false)
    private String prenom;
    @Column(name="date_naissance", nullable = false)
    private String dateNais;
    @Column(name="num_tel", nullable = false)
    private String numTel;
    @Column(name="user_name", nullable = false)
    private String userName;
    @Column(name="adresse", nullable = false)
    private String adresse;
    @JsonIgnore
    @Column(name="password", nullable = false)
    private String password;
    
    @JsonIgnore
	 @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	    private List<Consultation> consultations;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setDateNais(String dateNais) {
		this.dateNais = dateNais;
	}	
	public String getDateNais() {
		return dateNais;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Patient(Integer id, String nom, String prenom, String dateNais, String numTel, String userName,
			String adresse, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNais = dateNais;
		this.numTel = numTel;
		this.userName = userName;
		this.adresse = adresse;
		this.password = password;
	}

	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNais=" + dateNais + ", numTel="
				+ numTel + ", userName=" + userName + ", adresse=" + adresse + ", password=" + password + "]";
	}    
}