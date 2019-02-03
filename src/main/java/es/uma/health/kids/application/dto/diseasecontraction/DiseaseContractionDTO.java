package es.uma.health.kids.application.dto.diseasecontraction;

public class DiseaseContractionDTO {

	public int id;
	public String diagnosedAt;
	public String diseaseName;
	public String diseaseShortName; 
	public int patientId;
	
	public DiseaseContractionDTO(int id, String diagnosedAt, String diseaseName, String diseaseShortName,
			int patientId) {
		this.id = id;
		this.diagnosedAt = diagnosedAt;
		this.diseaseName = diseaseName;
		this.diseaseShortName = diseaseShortName;
		this.patientId = patientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnosedAt == null) ? 0 : diagnosedAt.hashCode());
		result = prime * result + ((diseaseName == null) ? 0 : diseaseName.hashCode());
		result = prime * result + ((diseaseShortName == null) ? 0 : diseaseShortName.hashCode());
		result = prime * result + id;
		result = prime * result + patientId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiseaseContractionDTO other = (DiseaseContractionDTO) obj;
		if (diagnosedAt == null) {
			if (other.diagnosedAt != null)
				return false;
		} else if (!diagnosedAt.equals(other.diagnosedAt))
			return false;
		if (diseaseName == null) {
			if (other.diseaseName != null)
				return false;
		} else if (!diseaseName.equals(other.diseaseName))
			return false;
		if (diseaseShortName == null) {
			if (other.diseaseShortName != null)
				return false;
		} else if (!diseaseShortName.equals(other.diseaseShortName))
			return false;
		if (id != other.id)
			return false;
		if (patientId != other.patientId)
			return false;
		return true;
	}
    
}
