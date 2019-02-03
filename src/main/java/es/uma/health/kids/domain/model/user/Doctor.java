package es.uma.health.kids.domain.model.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseName;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseShortName;
import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationId;
import es.uma.health.kids.domain.model.medication.MedicineCommercialName;
import es.uma.health.kids.domain.model.medication.MedicineName;
import es.uma.health.kids.domain.model.medication.Posology;
import es.uma.health.kids.domain.model.medication.Timing;
import es.uma.health.kids.domain.model.patient.Patient;

public class Doctor extends User {
	
    public Doctor(UserId id,
            UserFullName fullName,
            Email email,
            Password password) {
        super(id, fullName, email, password);
    }

	@Override
	public boolean isDoctor() {
		return true;
	}

	@Override
	protected void checkMessageAuthorization(Patient patientAbout) {
		if(!patientAbout.doctorId().equals(id)) {
			throw new NotAuthorizedException();
		}
	}
	
	public void assignPatient(Patient aPatient) {
		if (null != aPatient.doctorId()) {
			throw new IllegalArgumentException("The patient must not have a doctor assigned yet.");
		}
		aPatient.setDoctorId(this.id());
	}
	
	public void unassignPatient(Patient aPatient) {
		if (!aPatient.doctorId().equals(this.id())) {
			throw new NotAuthorizedException("The doctor does not have authorization to perform this action.");
		}
		aPatient.setDoctorId(null);
	}
	
	public DiseaseContraction diagnose(Patient aPatient, DiseaseContractionId anId, 
			DiseaseName diseaseName, DiseaseShortName diseaseShortName) {
		if (!aPatient.doctorId().equals(this.id())) {
			throw new NotAuthorizedException("The doctor does not have authorization to perform this action.");
		}
		return new DiseaseContraction(anId, LocalDateTime.now(), diseaseName, diseaseShortName, aPatient.id());
	}

	public Medication prescribe(Patient aPatient, DiseaseContraction aDiseaseContraction, MedicationId anId,
			MedicineName medicineName, MedicineCommercialName medicineCommercialName, Timing timing, Posology posology,
			LocalDate startedAt, LocalDate endedAt) {
		if (!aPatient.doctorId().equals(this.id())) {
			throw new NotAuthorizedException("The doctor does not have authorization to perform this action.");
		}
		return new Medication(anId, aDiseaseContraction.id(), medicineName, medicineCommercialName, 
				timing, posology, startedAt);
	}

	
}
