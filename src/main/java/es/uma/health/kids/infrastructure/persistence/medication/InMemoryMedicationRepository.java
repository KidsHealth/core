package es.uma.health.kids.infrastructure.persistence.medication;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.toList;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.medication.Medication;
import es.uma.health.kids.domain.model.medication.MedicationId;
import es.uma.health.kids.domain.model.medication.MedicationRepository;

public class InMemoryMedicationRepository implements MedicationRepository {

	private Map<MedicationId, Medication> medications;
	
	public InMemoryMedicationRepository() {
		this.medications = new HashMap<MedicationId, Medication>();
	}

	@Override
	public MedicationId nextIdentity() {
		return new MedicationId(medications.size() + 1);
	}

	@Override
	public void add(Medication aMedication) {
		medications.put(aMedication.id(), aMedication);
	}

	@Override
	public void update(Medication aMedication) {
		add(aMedication);
	}

	@Override
	public void delete(Medication aMedication) {
		medications.remove(aMedication.id());
	}

	@Override
	public Collection<Medication> all() {
		return medications.values().stream().map(m -> ofId(m.id())).collect(toList());
	}

	@Override
	public Medication ofId(MedicationId anId) {
		Medication medication = medications.get(anId);
		return new Medication(
				medication.id(), 
				medication.diseaseContractionId(), 
				medication.medicineName(), 
				medication.medicineCommercialName(), 
				medication.timing(), 
				medication.posology(), 
				medication.startedAt(), 
				medication.endedAt());
	}

	@Override
	public Collection<Medication> ofDiagnosis(DiseaseContractionId id) {
		return medications.values().stream()
				.filter(m -> m.diseaseContractionId().equals(id))
				.map(m -> ofId(m.id())).collect(toList());
	}

}
