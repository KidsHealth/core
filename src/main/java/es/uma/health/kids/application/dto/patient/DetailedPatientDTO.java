package es.uma.health.kids.application.dto.patient;

import java.util.Collection;

import es.uma.health.kids.application.dto.diseasecontraction.DetailedDiseaseContractionDTO;

public class DetailedPatientDTO extends PatientDTO {

	public Collection<DetailedDiseaseContractionDTO> contractions;
	
	public DetailedPatientDTO(int id, String name, String surname, String birthdate, Integer height, Integer weight,
			Collection<DetailedDiseaseContractionDTO> contractions) {
		super(id, name, surname, birthdate, height, weight);
		this.contractions = contractions; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contractions == null) ? 0 : contractions.hashCode());
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
		DetailedPatientDTO other = (DetailedPatientDTO) obj;
		if (contractions == null) {
			if (other.contractions != null)
				return false;
		} else if (!contractions.equals(other.contractions))
			return false;
		return true;
	}
	
}
