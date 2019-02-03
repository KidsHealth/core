package es.uma.health.kids.application.dto.diseasecontraction;

import java.util.Collection;

import es.uma.health.kids.application.dto.medication.MedicationDTO;

public class DetailedDiseaseContractionDTO extends DiseaseContractionDTO {

	public Collection<MedicationDTO> treatment;

	public DetailedDiseaseContractionDTO(int id, String diagnosedAt, String diseaseName, String diseaseShortName,
			int patientId, Collection<MedicationDTO> treatment) {
		super(id, diagnosedAt, diseaseName, diseaseShortName, patientId);
		this.treatment = treatment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((treatment == null) ? 0 : treatment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailedDiseaseContractionDTO other = (DetailedDiseaseContractionDTO) obj;
		if (treatment == null) {
			if (other.treatment != null)
				return false;
		} else if (!treatment.equals(other.treatment))
			return false;
		return true;
	}
	
}
