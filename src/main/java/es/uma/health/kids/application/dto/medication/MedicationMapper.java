package es.uma.health.kids.application.dto.medication;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import es.uma.health.kids.application.dto.shared.Mapper;
import es.uma.health.kids.domain.model.medication.Medication;

public class MedicationMapper implements Mapper<Medication, MedicationDTO> {

	@Override
	public MedicationDTO toDTO(Medication entity) {
		return new MedicationDTO(entity.id().value(), entity.diseaseContractionId().value(), 
				entity.medicineName().value(), 
				Optional.ofNullable(entity.medicineCommercialName())
				.map(w -> w.value()).orElse(null), entity.timing().value(), 
				entity.posology().value(), entity.startedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
				Optional.ofNullable(entity.endedAt())
				.map(w -> w.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).orElse(null));
	}

	@Override
	public Medication toEntity(MedicationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
