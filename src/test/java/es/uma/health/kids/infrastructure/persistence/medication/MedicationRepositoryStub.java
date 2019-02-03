package es.uma.health.kids.infrastructure.persistence.medication;

import es.uma.health.kids.domain.model.medication.MedicationRepository;

public class MedicationRepositoryStub {

	public static MedicationRepository empty() {
		return new InMemoryMedicationRepository();
	}
}
