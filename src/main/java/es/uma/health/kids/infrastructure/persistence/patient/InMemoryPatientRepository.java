package es.uma.health.kids.infrastructure.persistence.patient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.UserId;

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

	@Override
	public Collection<Patient> ofResponsible(UserId responsibleId) {
		return all().stream().filter(p -> p.patientResponsibleId().equals(responsibleId)).collect(Collectors.toList());
	}

	@Override
	public Collection<Patient> ofDoctor(UserId doctorId) {
		return all().stream().filter(p -> p.doctorId().equals(doctorId)).collect(Collectors.toList());
	}
	
	public Collection<Patient> relatedWith(UserId userId) {
		return all().stream().filter(p -> {
			return p.patientResponsibleId().equals(userId) || p.doctorId().equals(userId);
		}).collect(Collectors.toList());
	}

}
