package es.uma.health.kids.domain.model.medication;

import java.util.Collection;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;

public interface MedicationRepository {

	public MedicationId nextIdentity();
	
	public void add(Medication aMedication);
	
	public void update(Medication aMedication);

	public void delete(Medication aMedication);

	public Collection<Medication> all();
	
	public Medication ofId(MedicationId anId);

	public Collection<Medication> ofDiagnosis(DiseaseContractionId id);
	
}
