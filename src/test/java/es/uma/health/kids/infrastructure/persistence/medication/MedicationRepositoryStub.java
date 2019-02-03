package es.uma.health.kids.infrastructure.persistence.medication;

import java.util.stream.Stream;

import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationRepository;

public class MedicationRepositoryStub {

	public static MedicationRepository empty() {
		return new InMemoryMedicationRepository();
	}
	
	public static MedicationRepository with(Medication... medications) {
		MedicationRepository repo = empty();
		Stream.of(medications).forEach(repo::add);
		return repo;
	}
}
