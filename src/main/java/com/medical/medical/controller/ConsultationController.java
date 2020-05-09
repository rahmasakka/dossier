package com.medical.medical.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medical.medical.dao.ConsultationRepository;
import com.medical.medical.model.Consultation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "gestion les consultations")
@RestController
@RequestMapping(value="/rest/api")
public class ConsultationController {

	@Autowired
	ConsultationRepository consultationRepository;
	
	@ApiOperation("consulter toutes les consultations")
	  @GetMapping(value="/consultations")
	  public List<Consultation> allConsultations(){
	      return consultationRepository.findAll();
	  }
	  
	@ApiOperation("consulter les liste des consultations du docteur")
	@GetMapping(value = "/consultations/docteur/{docteurID}")
	public List<Consultation> chercherDocteur(@PathVariable int docteurID) {
	    return consultationRepository.chercherConsultationDocteur(docteurID);
	}	

	@ApiOperation("consulter la liste des consultations du patient")
	@GetMapping(value = "/consultations/patient/{patientID}")
	public List<Consultation> chercherPatient(@PathVariable int patientID) {
	    return consultationRepository.chercherConsultationPatient(patientID);
	}
	
	@ApiOperation("consulter la liste des consultations du patient x avec le docteur y")
	@GetMapping(value = "/consultations/patientDocteur/{patientID}/{docteurID}")
	public List<Consultation> chercherPatientDocteur(@PathVariable int patientID, @PathVariable int docteurID) {
		return consultationRepository.chercherConsultationPatientDocteur(patientID, docteurID) ;
	 }
	
	
	@ApiOperation("ajouter une nouvelle consultation")
    @PostMapping(value="/ajouterConsultation")
    public Consultation addConsultation(@Valid @RequestBody Consultation consultation){
        return consultationRepository.save(consultation);
    }
    
	@ApiOperation("modifier une consultation selon son id")
    @PutMapping(value="/consultation/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Integer id, @Valid @RequestBody Consultation consultationDetails) throws Exception{
        Consultation consultation = consultationRepository.findById(id).orElseThrow(()->new Exception("La consultation n'existe pas"));
        consultation.setDocteur(consultationDetails.getDocteur());
        consultation.setPatient(consultationDetails.getPatient());
        consultation.setDateCons(consultationDetails.getDateCons());     
        consultationRepository.save(consultation);
        return ResponseEntity.ok(consultation);
    }
    
	@ApiOperation("supprimer une consultation")
    @DeleteMapping(value="/consultation/{id}")
    public Map<String,Boolean> deleteDocteur(@PathVariable Integer id) throws Exception{
        Consultation consultation = consultationRepository.findById(id).orElseThrow(()->new Exception("La consultation n'existe pas"));
        consultationRepository.delete(consultation);
        Map<String,Boolean> response = new HashMap<>();
        response.put("La consultation est supprimée!",Boolean.TRUE);
        return response;
    }
}