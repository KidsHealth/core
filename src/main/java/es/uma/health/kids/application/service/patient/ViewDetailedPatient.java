package es.uma.health.kids.application.service.patient;

import java.util.Collection;
import java.util.stream.Collectors;

import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionDTO;
import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionMapper;
import es.uma.health.kids.application.dto.medication.MedicationDTO;
import es.uma.health.kids.application.dto.medication.MedicationMapper;
import es.uma.health.kids.application.dto.patient.DetailedPatientDTO;
import es.uma.health.kids.application.dto.patient.DetailedPatientMapper;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.medication.MedicationRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientDoesNotExistException;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.NotAuthorizedException;
import es.uma.health.kids.domain.model.user.User;
import es.uma.health.kids.domain.model.user.UserDoesNotExistException;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;

public class ViewDetailedPatient {

	private UserRepository userRepo;
	private PatientRepository  patientRepo;
	private DiseaseContractionRepository contractionRepo;
	private MedicationRepository medicationRepo;
	private DetailedPatientMapper patientMapper;
	private DetailedDiseaseContractionMapper contractionMapper;
	private MedicationMapper medicationMapper;

	public ViewDetailedPatient(UserRepository userRepo, PatientRepository patientRepo,
			DiseaseContractionRepository contractionRepo, MedicationRepository medicationRepo,
			DetailedPatientMapper patientMapper, DetailedDiseaseContractionMapper contractionMapper,
			MedicationMapper medicationMapper) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.contractionRepo = contractionRepo;
		this.medicationRepo = medicationRepo;
		this.patientMapper = patientMapper;
		this.contractionMapper = contractionMapper;
		this.medicationMapper = medicationMapper;
	}

	public DetailedPatientDTO execute(ViewDetailedPatientRequest request) {
		
		User user = userRepo.ofId(new UserId(request.userId));
		checkUserExistence(user);
		
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));		
		checkPatientExistence(patient);
		
		checkAuthorization(user, patient);
		
		Collection<DetailedDiseaseContractionDTO> detContractions = 
				contractionRepo.ofPatient(patient.id()).stream().map(c -> {
					Collection<MedicationDTO> medications = medicationRepo.ofDiagnosis(c.id()).stream()
							.map(medicationMapper::toDTO).collect(Collectors.toList());
					
					return contractionMapper.toDTO(c, medications);
				}).collect(Collectors.toList());
		
		return patientMapper.toDTO(patient, detContractions);
	}

	private void checkAuthorization(User user, Patient patient) {
		if (user.isDoctor() && !patient.doctorId().equals(user.id()) || 
				!user.isDoctor() && !patient.patientResponsibleId().equals(user.id())) {
			throw new NotAuthorizedException("This user is not allowed to view the requested patient.");
		}
	}
	
	private void checkUserExistence(User user) {
		if (null == user) {
			throw new UserDoesNotExistException();
		}
	}
	
	private void checkPatientExistence(Patient aPatient) {
		if (null == aPatient) {
			throw new PatientDoesNotExistException();
		}
	}
	
}
