package es.uma.health.kids.infrastructure.persistence.user;

import java.util.stream.Stream;

import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.DoctorRepository;
import es.uma.health.kids.infrastructure.persistence.doctor.InMemoryDoctorRepository;

public class DoctorRepositoryStub {

	public static DoctorRepository with(Doctor ...doctors) {
		DoctorRepository repo = empty();
		Stream.of(doctors).forEach(repo::add);
		return repo;
	}

	private static DoctorRepository empty() {
		return new InMemoryDoctorRepository();
	}

}
