package es.uma.health.kids.application.service.user.doctor;

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

public class DoctorUnssignAPatient {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	
	public DoctorUnssignAPatient(UserRepository userRepo, PatientRepository patientRepo) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
	}

	public void execute(DoctorUnssignAPatientRequest request) {
		
		User user = userRepo.ofId(new UserId(request.doctorId));
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));
		
		checkUserExistence(user);
		checkPatientExistence(patient);
		checkAuthorization(user);
		
		Doctor doctor = (Doctor) user;
		
		doctor.unassignPatient(patient);
		
		patientRepo.update(patient);
		
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
