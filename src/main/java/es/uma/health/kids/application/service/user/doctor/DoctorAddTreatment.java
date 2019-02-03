package es.uma.health.kids.application.service.user.doctor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionDoesNotExistException;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationRepository;
import es.uma.health.kids.domain.model.medication.MedicineCommercialName;
import es.uma.health.kids.domain.model.medication.MedicineName;
import es.uma.health.kids.domain.model.medication.Posology;
import es.uma.health.kids.domain.model.medication.Timing;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientDoesNotExistException;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.NotAuthorizedException;
import es.uma.health.kids.domain.model.user.User;
import es.uma.health.kids.domain.model.user.UserDoesNotExistException;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;

public class DoctorAddTreatment {

	private UserRepository userRepo; 
	private PatientRepository patientRepo;
	private DiseaseContractionRepository contractionRepo; 
	private MedicationRepository medicationRepo;
	
	public DoctorAddTreatment(UserRepository userRepo, PatientRepository patientRepo,
			DiseaseContractionRepository contractionRepo, MedicationRepository medicationRepo) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.contractionRepo = contractionRepo;
		this.medicationRepo = medicationRepo;
	}

	public void execute(DoctorAddTreatmentRequest request) {
		
		User user = userRepo.ofId(new UserId(request.doctorId));
		
		checkUserExistence(user);
		checkAuthorization(user);
		
		Doctor doctor = (Doctor) user;
		
		DiseaseContraction aDiseaseContraction = contractionRepo.ofId(new DiseaseContractionId(request.diseaseContractionId));
		
		checkDiseaseContractionExistence(aDiseaseContraction);
		
		Patient patient = patientRepo.ofId(aDiseaseContraction.patientId());
		
		checkPatientExistence(patient);
		
		Medication medication = doctor.prescribe(patient, aDiseaseContraction, medicationRepo.nextIdentity(),
				new MedicineName(request.medicineName), new MedicineCommercialName(request.medicineCommercialName),
				new Timing(request.timing), new Posology(request.posology), 
				LocalDate.parse(request.startedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
				LocalDate.parse(request.endedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		medicationRepo.add(medication);
		
	}

	private void checkDiseaseContractionExistence(DiseaseContraction aDiseaseContraction) {
		if (null == aDiseaseContraction) {
			throw new DiseaseContractionDoesNotExistException();
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
	
	private void checkAuthorization(User user) {
		if (!user.isDoctor()) {
			throw new NotAuthorizedException("Normal users cannot perform this action.");
		}
	}
}
