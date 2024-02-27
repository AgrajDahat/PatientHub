package com.patient.service;

import com.patient.model.Patient;
import com.patient.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PatientServiceTest {

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @Test
    void testGetPatientById() {
        // Mock repository response
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.of(new Patient(1L, "John Doe", 25)));

        // Test the service method
        Patient retrievedPatient = patientService.getPatientById(1L);

        // Verify that the repository method was called
        Mockito.verify(patientRepository, Mockito.times(1)).findById(1L);

        // Assertions
        Assertions.assertNotNull(retrievedPatient);
        Assertions.assertEquals("John Doe", retrievedPatient.getName());
        Assertions.assertEquals(25, retrievedPatient.getAge());
    }

    @Test
    void testSavePatient() {
        // Mock repository response
        Patient patientToSave = new Patient(null, "Jane Doe", 30);
        Mockito.when(patientRepository.save(patientToSave)).thenReturn(new Patient(1L, "Jane Doe", 30));

        // Test the service method
        Patient savedPatient = patientService.savePatient(patientToSave);

        // Verify that the repository method was called
        Mockito.verify(patientRepository, Mockito.times(1)).save(patientToSave);

        // Assertions
        Assertions.assertNotNull(savedPatient);
        Assertions.assertEquals("Jane Doe", savedPatient.getName());
        Assertions.assertEquals(30, savedPatient.getAge());
    }

}
