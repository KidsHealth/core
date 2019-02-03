package es.uma.health.kids.application.dto.diseasecontraction;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import es.uma.health.kids.application.dto.shared.Mapper;
import es.uma.health.kids.domain.model.diseasecontraction.DiseaseContraction;

public class DiseaseContractionMapper implements Mapper<DiseaseContraction, DiseaseContractionDTO> {

	@Override
	public DiseaseContractionDTO toDTO(DiseaseContraction entity) {
		return new DiseaseContractionDTO(entity.id().value(), 
				entity.diagnosedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
				entity.diseaseName().stringName(),
				Optional.ofNullable(entity.diseaseShortName()).map(w -> w.value()).orElse(null), 
				entity.patientId().value());
	}

	@Override
	public DiseaseContraction toEntity(DiseaseContractionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
