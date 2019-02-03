package es.uma.health.kids.infrastructure.persistence.diseasecontraction;

import java.util.stream.Stream;

import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContractionRepository;

public class DiseaseContractionRepositoryStub {

	public static DiseaseContractionRepository empty() {
		return new InMemoryDiseaseContractionRepository();
	}
	
	public static DiseaseContractionRepository with(DiseaseContraction...contractions) {
		DiseaseContractionRepository contractionsRepo = new InMemoryDiseaseContractionRepository();
		Stream.of(contractions).forEach(contractionsRepo::add);
		return contractionsRepo;
	}
	
}
