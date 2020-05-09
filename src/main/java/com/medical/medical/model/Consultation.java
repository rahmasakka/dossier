package com.medical.medical.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.medical.medical.model.Docteur;


@Entity
@Table(name="Consultation")
public class Consultation {

    @Id
    @GeneratedValue
    private Integer id;
	
   
    @ManyToOne
    @JoinColumn
    private Docteur docteur;
    
    
    @ManyToOne
    @JoinColumn
    private Patient patient;
    
    @Column(name="date_consultation", nullable = false)
    private String dateCons;

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", docteur=" + docteur + ", patient=" + patient + ", dateCons=" + dateCons + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDateCons() {
		return dateCons;
	}

	public void setDateCons(String dateCons) {
		this.dateCons = dateCons;
	}

	public Consultation(Integer id, Docteur docteur, Patient patient, String dateCons) {
		super();
		this.id = id;
		this.docteur = docteur;
		this.patient = patient;
		this.dateCons = dateCons;
	}
    
	public Consultation() {
		super();
	}   
}