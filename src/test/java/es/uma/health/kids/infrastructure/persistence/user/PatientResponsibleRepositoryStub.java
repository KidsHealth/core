package es.uma.health.kids.infrastructure.persistence.user;

import java.util.stream.Stream;

import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.PatientResponsibleRepository;
import es.uma.health.kids.infrastructure.persistence.user.InMemoryPatientResponsibleRepository;

public class PatientResponsibleRepositoryStub {

	public static PatientResponsibleRepository empty() {
		return new InMemoryPatientResponsibleRepository();
	}
	
	public static PatientResponsibleRepository with(PatientResponsible ...responsibles) {
		PatientResponsibleRepository prRepo = empty();
		Stream.of(responsibles).forEach(prRepo::add);
		return prRepo;
	}
	
}
