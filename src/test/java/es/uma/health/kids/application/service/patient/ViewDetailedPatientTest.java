package es.uma.health.kids.application.service.patient;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionDTO;
import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionMapper;
import es.uma.health.kids.application.dto.medication.MedicationDTO;
import es.uma.health.kids.application.dto.medication.MedicationMapper;
import es.uma.health.kids.application.dto.patient.DetailedPatientDTO;
import es.uma.health.kids.application.dto.patient.DetailedPatientMapper;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseName;
import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationId;
import es.uma.health.kids.domain.model.medication.MedicationRepository;
import es.uma.health.kids.domain.model.medication.MedicineName;
import es.uma.health.kids.domain.model.medication.Posology;
import es.uma.health.kids.domain.model.medication.Timing;
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

public class ViewDetailedPatientTest {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private DiseaseContractionRepository contractionRepo;
	private PatientResponsible pResp;
	private Doctor aDoctor;
	private Patient aPatient;
	private DiseaseContraction aDiseaseContraction;
	private MedicationRepository medicationRepo;
	private Medication aMedication;
	private DetailedPatientMapper patientMapper;
	private DetailedDiseaseContractionMapper contractionMapper;
	private MedicationMapper medicationMapper;
	
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
		aDiseaseContraction = new DiseaseContraction(new DiseaseContractionId(1), LocalDateTime.now(), 
				new DiseaseName("Influenza"), null, aPatient.id());
		contractionRepo = DiseaseContractionRepositoryStub.with(aDiseaseContraction);
		aMedication = new Medication(new MedicationId(1), aDiseaseContraction.id(), 
				new MedicineName("Ibuprofen"), null, new Timing(8), new Posology(400), 
				LocalDate.of(2019, 2, 3), LocalDate.of(2019, 2, 8));
		medicationRepo = MedicationRepositoryStub.with(aMedication);
		
		patientMapper = new DetailedPatientMapper();
		contractionMapper = new DetailedDiseaseContractionMapper();
		medicationMapper = new MedicationMapper();
	}

	@Test
	public void shouldAnUserViewADetailedPatient() {
		
		DetailedPatientDTO actualDetailedPatient = new ViewDetailedPatient(
				userRepo, patientRepo, contractionRepo, medicationRepo, 
				patientMapper,contractionMapper, medicationMapper)
				.execute(new ViewDetailedPatientRequest(pResp.id().value(), aPatient.id().value()));
		
		assertEquals(new DetailedPatientDTO(
					aPatient.id().value(),
					aPatient.fullName().name(),
					aPatient.fullName().surname(),
					aPatient.birthdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					null, null,
					Arrays.asList(new DetailedDiseaseContractionDTO(
							aDiseaseContraction.id().value(), 
							aDiseaseContraction.diagnosedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
							aDiseaseContraction.diseaseName().stringName(), 
							null, 
							aDiseaseContraction.patientId().value(), 
							Arrays.asList(new MedicationDTO(aMedication.id().value(), 
									aMedication.diseaseContractionId().value(), 
									aMedication.medicineName().value(), 
									null, 
									aMedication.timing().value(), aMedication.posology().value(), 
									aMedication.startedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
									aMedication.endedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))))
				), actualDetailedPatient);
	}

}
