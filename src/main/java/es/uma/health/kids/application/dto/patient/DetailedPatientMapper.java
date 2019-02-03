package es.uma.health.kids.application.dto.patient;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionDTO;
import es.uma.health.kids.domain.model.patient.Patient;

public class DetailedPatientMapper {

	public DetailedPatientDTO toDTO(Patient entity, Collection<DetailedDiseaseContractionDTO> contractions) {
		return new DetailedPatientDTO(
				entity.id().value(), 
				Optional.ofNullable(entity.fullName()).map(f -> f.name()).orElse(null), 
				Optional.ofNullable(entity.fullName()).map(f -> f.surname()).orElse(null),
				Optional.ofNullable(entity.birthdate()).map(
						b -> b.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).orElse(null), 
				Optional.ofNullable(entity.height()).map(h -> h.value()).orElse(null), 
				Optional.ofNullable(entity.weight()).map(w -> w.value()).orElse(null),
				contractions);
	}
	
}
