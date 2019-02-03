package es.uma.health.kids.application.service.user.doctor;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseName;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseShortName;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientDoesNotExistException;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.NotAuthorizedException;
import es.uma.health.kids.domain.model.user.User;
import es.uma.health.kids.domain.model.user.UserDoesNotExistException;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;

public class DoctorDiagnosePatient {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private DiseaseContractionRepository contractionRepo;
	
	public DoctorDiagnosePatient(UserRepository userRepo, PatientRepository patientRepo,
			DiseaseContractionRepository contractionRepo) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.contractionRepo = contractionRepo;
	}

	public void execute(DoctorDiagnosePatientRequest request) {
		
		User user = userRepo.ofId(new UserId(request.doctorId));
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));
		
		checkUserExistence(user);
		checkPatientExistence(patient);
		checkAuthorization(user);
		
		Doctor doctor = (Doctor) user;
		
		DiseaseContraction dContraction = doctor.diagnose(
				patient, 
				contractionRepo.nextIdentity(), 
				new DiseaseName(request.diseaseName), 
				new DiseaseShortName(request.diseaseShortName));
		
		contractionRepo.add(dContraction);
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
	
	private void checkAuthorization(User user) {
		if (!user.isDoctor()) {
			throw new NotAuthorizedException("Normal users cannot perform this action.");
		}
	}
	
}
