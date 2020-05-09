package com.medical.medical.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.medical.medical.model.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {
	
	@Query("SELECT c from Consultation c WHERE c.docteur.id= :docteurID")
	List<Consultation> chercherConsultationDocteur(@Param("docteurID")int id);
	
	@Query("SELECT c from Consultation c WHERE c.patient.id= :patientID")
	List<Consultation> chercherConsultationPatient(@Param("patientID")int id);
	
	@Query("select c from Consultation c WHERE c.docteur.id= :docteurID AND c.patient.id= :patientID ")
	List<Consultation> chercherConsultationPatientDocteur(int patientID, int docteurID);	
}