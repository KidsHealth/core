package es.uma.health.kids.application.dto.diseasecontraction;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

import es.uma.health.kids.application.dto.medication.MedicationDTO;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;

public class DetailedDiseaseContractionMapper {

	public DetailedDiseaseContractionDTO toDTO(DiseaseContraction entity, Collection<MedicationDTO> treatment) {
		return new DetailedDiseaseContractionDTO(entity.id().value(), 
				entity.diagnosedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
				entity.diseaseName().stringName(),
				Optional.ofNullable(entity.diseaseShortName()).map(w -> w.value()).orElse(null), 
				entity.patientId().value(), treatment);
	}
	
}
