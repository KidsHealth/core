package es.uma.health.kids.infrastructure.persistence.diseasecontraction;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;
import es.uma.health.kids.domain.model.patient.PatientId;

public class InMemoryDiseaseContractionRepository implements DiseaseContractionRepository {

	private Map<DiseaseContractionId, DiseaseContraction> contractions;
	
	public InMemoryDiseaseContractionRepository() {
		this.contractions = new HashMap<DiseaseContractionId, DiseaseContraction>();
	}

	@Override
	public DiseaseContractionId nextIdentity() {
		return new DiseaseContractionId(contractions.size() + 1);
	}

	@Override
	public void add(DiseaseContraction aDiseaseContraction) {
		contractions.put(aDiseaseContraction.id(), aDiseaseContraction);
	}

	@Override
	public void update(DiseaseContraction aDiseaseContraction) {
		add(aDiseaseContraction);
	}

	@Override
	public void delete(DiseaseContraction aDiseaseContraction) {
		contractions.remove(aDiseaseContraction.id());
	}

	@Override
	public Collection<DiseaseContraction> all() {
		return contractions.values().stream().map(c -> ofId(c.id())).collect(toList());
	}

	@Override
	public DiseaseContraction ofId(DiseaseContractionId anId) {
		DiseaseContraction contraction = contractions.get(anId);
		return new DiseaseContraction(
				contraction.id(), 
				contraction.diagnosedAt(), 
				contraction.diseaseName(), 
				contraction.diseaseShortName(), 
				contraction.patientId());
	}

	@Override
	public Collection<DiseaseContraction> ofPatient(PatientId patientId) {
		return contractions.values().stream()
				.filter(c -> c.patientId().equals(patientId))
				.map(c -> ofId(c.id())).collect(toList());
	}

}
