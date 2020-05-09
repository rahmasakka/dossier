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
import com.medical.medical.dao.DocteurRepository;
import com.medical.medical.model.Docteur;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "gestion des docteurs")
@RestController
@RequestMapping(value="/rest/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class DocteurController {
	    @Autowired
	    DocteurRepository docteurRepository;
	    
	 @ApiOperation("consulter tout les docteurs")
	  @GetMapping(value="/docteurs")
	  public List<Docteur> allDoctors(){
	      return docteurRepository.findAll();
	  }
	 
	 
	 @ApiOperation("consulter le docteur selon son id")
	    @GetMapping(value="/docteur/{id}")
	    public ResponseEntity<Docteur> docteur(@PathVariable Integer id) throws Exception{
	        final Docteur docteur = docteurRepository.findById(id).orElseThrow(()->new Exception("Le docteur n'existe pas"));
	        return ResponseEntity.ok().body(docteur);
	    }
	    
	 @ApiOperation("ajouter un nouveau docteur")
	    @PostMapping(value="/ajouterDocteur")
	    public Docteur addDoctor(@Valid @RequestBody Docteur docteur){
	        return docteurRepository.save(docteur);
	    }
	    
	 @ApiOperation("modifier un docteur selon son id")
	    @PutMapping(value="/docteur/{id}")
	    public ResponseEntity<Docteur> updateDoctor(@PathVariable Integer id, @Valid @RequestBody Docteur docteurDetails) throws Exception{
	        Docteur docteur = docteurRepository.findById(id).orElseThrow(()->new Exception("Le docteur n'existe pas"));
	        docteur.setNom(docteurDetails.getNom());
	        docteur.setPrenom(docteurDetails.getPrenom());
	        docteur.setNumTelPerso(docteurDetails.getNumTelPerso());
	        docteur.setNumTelCab(docteurDetails.getNumTelCab());
	        docteur.setAdresse(docteurDetails.getAdresse());
	        docteur.setUserName(docteurDetails.getUserName());
	        docteur.setPassword(docteurDetails.getPassword());        
	        docteurRepository.save(docteur);
	        return ResponseEntity.ok(docteur);
	    }
	    
	 @ApiOperation("supprimer unh docteur selon son id")
	    @DeleteMapping(value="/docteur/{id}")
	    public Map<String,Boolean> deleteDocteur(@PathVariable Integer id) throws Exception{
	        Docteur docteur = docteurRepository.findById(id).orElseThrow(()->new Exception("Le docteur n'existe pas"));
	        docteurRepository.delete(docteur);
	        Map<String,Boolean> response = new HashMap<>();
	        response.put("Le docteur est supprimé!",Boolean.TRUE);
	        return response;
	    }
}