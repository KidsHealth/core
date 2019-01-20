package es.uma.health.kids.infrastructure.persistence.patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;

public class InMemoryPatientRepository implements PatientRepository {

	private Map<PatientId, Patient> patients;
	
	public InMemoryPatientRepository() {
		this.patients = new HashMap<>();
	}

	@Override
	public PatientId nextIdentity() {
		return new PatientId(patients.size() + 1);
	}

	@Override
	public void add(Patient aPatient) {
		patients.put(aPatient.id(), aPatient);
	}

	@Override
	public void update(Patient aPatient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Patient aPatient) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Patient> all() {
		return new ArrayList<>(patients.values());
	}

	@Override
	public Patient ofId(PatientId anId) {
		return patients.get(anId);
	}

}
