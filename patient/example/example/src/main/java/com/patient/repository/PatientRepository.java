package com.patient.repository;

import org.springframework.data.repository.CrudRepository;
import com.patient.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
