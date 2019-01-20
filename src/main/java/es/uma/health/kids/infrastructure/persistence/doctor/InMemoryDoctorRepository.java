package es.uma.health.kids.infrastructure.persistence.doctor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.DoctorId;
import es.uma.health.kids.domain.model.user.DoctorRepository;
import es.uma.health.kids.domain.model.user.Email;
import es.uma.health.kids.domain.model.user.UserId;

public class InMemoryDoctorRepository implements DoctorRepository {

	private Map<DoctorId, Doctor> doctors;
	
	public InMemoryDoctorRepository() {
		doctors = new HashMap<>();
	}
	
	@Override
	public UserId nextIdentity() {
		return new UserId(doctors.size() + 1);
	}

	@Override
	public void add(Doctor aDoctor) {
		doctors.put(aDoctor.id(), aDoctor);
	}

	@Override
	public void update(Doctor aDoctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Doctor aDoctor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Doctor> all() {
		return new ArrayList<>(doctors.values());
	}

	@Override
	public Doctor ofEmail(Email anEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor ofId(UserId anId) {
		return doctors.get(anId);
	}

}
