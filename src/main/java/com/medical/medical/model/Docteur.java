package com.medical.medical.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medical.medical.model.Consultation;


@Entity
@Table(name="Docteur")
public class Docteur {
	
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nom", nullable = false)
	private String nom;
	@Column(name="prenom", nullable = false)
	private String prenom;
	@Column(name="num_tel_personnel", nullable = false)
	private String numTelPerso;
	@Column(name="num_tel_cabinet", nullable = false)
	private String numTelCab;	   
	@Column(name="adresse_cabinet", nullable = false)
	private String adresse;
    @Column(name="user_name", nullable = false)
    private String userName;
    @JsonIgnore
    @Column(name="password", nullable = false)
    private String password;
    
    @JsonIgnore
	 @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL)
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
	public String getNumTelPerso() {
		return numTelPerso;
	}
	public void setNumTelPerso(String numTelPerso) {
		this.numTelPerso = numTelPerso;
	}
	public String getNumTelCab() {
		return numTelCab;
	}
	public void setNumTelCab(String numTelCab) {
		this.numTelCab = numTelCab;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(List<Consultation> consultations) {
		this.consultations = consultations;
	}
	
	
	public Docteur(Integer id, String nom, String prenom, String numTelPerso, String numTelCab, String adresse,
			String userName, String password, List <Consultation> consultations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numTelPerso = numTelPerso;
		this.numTelCab = numTelCab;
		this.adresse = adresse;
		this.userName = userName;
		this.password = password;
		this.consultations= consultations;
	}
	
	
	 
//		public Docteur(Integer id, String nom, String prenom, String numTelPerso, String numTelCab, String adresse,
//				String userName, String password, List<Consultation> consultations) {
//			super();
//			this.id = id;
//			this.nom = nom;
//			this.prenom = prenom;
//			this.numTelPerso = numTelPerso;
//			this.numTelCab = numTelCab;
//			this.adresse = adresse;
//			this.userName = userName;
//			this.password = password;
//			this.consultations = consultations;
//		}
	
	
	@Override
	public String toString() {
		return "Docteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", numTelPerso=" + numTelPerso
				+ ", numTelCab=" + numTelCab + ", adresse=" + adresse + ", userName=" + userName + ", password="
				+ password + ", consultations=" + consultations + "]";
	}
	
	public Docteur() {
		super();
	}   
}