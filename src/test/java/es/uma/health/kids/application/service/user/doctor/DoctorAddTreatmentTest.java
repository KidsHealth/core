package es.uma.health.kids.application.service.user.doctor;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseName;
import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientFullName;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;
import es.uma.health.kids.infrastructure.persistence.diseasecontraction.DiseaseContractionRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.medication.MedicationRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.patient.PatientRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.user.UserRepositoryStub;

public class DoctorAddTreatmentTest {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private DiseaseContractionRepository contractionRepo;
	private PatientResponsible pResp;
	private Doctor aDoctor;
	private Patient aPatient;
	private DiseaseContraction aDiseaseContraction;
	private MedicationRepository medicationRepo;
	
	@Before
	public void setUp() {
		pResp = new PatientResponsible(new UserId(1), null, null, null);
		aDoctor = new Doctor(new UserId(30), null, null, null);
		userRepo = UserRepositoryStub.with(pResp, aDoctor);
		aPatient = new Patient(
				new PatientId(2), 
				new PatientFullName("Name", "Surname"),
				LocalDate.of(2012, 05, 01),
				pResp.id(),
				aDoctor.id());
		patientRepo = PatientRepositoryStub.with(aPatient);
		aDiseaseContraction = new DiseaseContraction(new DiseaseContractionId(1), null, 
				new DiseaseName("Influenza"), null, aPatient.id());
		contractionRepo = DiseaseContractionRepositoryStub.with(aDiseaseContraction);
		medicationRepo = MedicationRepositoryStub.empty();
	}

	@Test
	public void shouldADoctorAddATreatment() {
		
		Collection<Medication> actualMedications = medicationRepo.ofDiagnosis(aDiseaseContraction.id());
		assertTrue(actualMedications.isEmpty());
		
		new DoctorAddTreatment(userRepo, patientRepo, contractionRepo, medicationRepo).execute(
				new DoctorAddTreatmentRequest(
					aDoctor.id().value(),
					aDiseaseContraction.id().value(),
					"Ibuprofen",
					null,
					8,
					400,
					"2019-02-03",
					"2019-02-08"
				));
		
		actualMedications = medicationRepo.ofDiagnosis(aDiseaseContraction.id());
		
		assertEquals(1, actualMedications.size());
	}

}
