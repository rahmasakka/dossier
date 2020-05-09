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
import com.medical.medical.dao.PatientRepository;
import com.medical.medical.model.Patient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "gestion des patients")
@RestController
@RequestMapping(value="/rest/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
    @Autowired
    PatientRepository patientRepository;
    
    @ApiOperation("consulter la liste des patients")
    @GetMapping(value="/patients")
    public List<Patient> allPatient(){
        return patientRepository.findAll();
    }
    
    @ApiOperation("consulter un patient selon son id")
    @GetMapping(value="/patient/{id}")
    public ResponseEntity<Patient> patient(@PathVariable Integer id) throws Exception{
        final Patient patient = patientRepository.findById(id).orElseThrow(()->new Exception("Le patient n'existe pas"));
        return ResponseEntity.ok().body(patient);
    }
    
    @ApiOperation("ajouter un nouveau patient")
    @PostMapping(value="/ajouterPatient")
    public Patient addPatient(@Valid @RequestBody Patient patient){
        return patientRepository.save(patient);
    }
    
    @ApiOperation("modifier un patient selon son id")
    @PutMapping(value="/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id, @Valid @RequestBody Patient patientDetails) throws Exception{
        Patient patient = patientRepository.findById(id).orElseThrow(()->new Exception("Le patient n'existe pas"));
        patient.setNom(patientDetails.getNom());
        patient.setPrenom(patientDetails.getPrenom());
        patient.setDateNais(patientDetails.getDateNais());
        patient.setNumTel(patientDetails.getNumTel());
        patient.setAdresse(patientDetails.getAdresse());
        patient.setUserName(patientDetails.getUserName());
        patient.setPassword(patientDetails.getPassword());
        patientRepository.save(patient);
        return ResponseEntity.ok(patient);
    }
    
    @ApiOperation("supprimer un patient selon son id")
    @DeleteMapping(value="/patient/{id}")
    public Map<String,Boolean> deletePatient(@PathVariable Integer id) throws Exception{
        Patient patient = patientRepository.findById(id).orElseThrow(()->new Exception("Le patient n'existe pas"));
        patientRepository.delete(patient);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Le patient est supprimé!",Boolean.TRUE);
        return response;
    }
}
