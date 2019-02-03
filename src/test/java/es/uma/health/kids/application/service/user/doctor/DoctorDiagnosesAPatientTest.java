package es.uma.health.kids.application.service.user.doctor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientFullName;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;
import es.uma.health.kids.infrastructure.persistence.diseasecontraction.DiseaseContractionRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.patient.PatientRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.user.UserRepositoryStub;

public class DoctorDiagnosesAPatientTest {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private DiseaseContractionRepository contractionRepo;
	private PatientResponsible pResp;
	private Doctor aDoctor;
	private Patient aPatient;
	
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
		contractionRepo = DiseaseContractionRepositoryStub.empty();
	}

	@Test
	public void shouldADoctorDiagnoseOwnPatient() {
		
		Collection<DiseaseContraction> actualContractions = contractionRepo.ofPatient(aPatient.id());
		assertTrue(actualContractions.isEmpty());
		
		new DoctorDiagnosePatient(userRepo, patientRepo, contractionRepo).execute(new DoctorDiagnosePatientRequest(
					aDoctor.id().value(),
					aPatient.id().value(),
					"Influenza",
					null
				));
		
		actualContractions = contractionRepo.ofPatient(aPatient.id());
		
		assertEquals(1, actualContractions.size());
	}

}
