package com.medical.medical.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medical.medical.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}