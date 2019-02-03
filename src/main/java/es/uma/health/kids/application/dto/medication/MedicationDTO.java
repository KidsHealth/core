package es.uma.health.kids.application.dto.medication;

public class MedicationDTO {

	public int id;
	public int diseaseContractionId;
	public String medicineName;
	public String medicineCommercialName;
	public int timing;
	public int posology;
	public String startedAt;
	public String endedAt;
	
	public MedicationDTO(int id, int diseaseContractionId, String medicineName, String medicineCommercialName,
			int timing, int posology, String startedAt, String endedAt) {
		this.id = id;
		this.diseaseContractionId = diseaseContractionId;
		this.medicineName = medicineName;
		this.medicineCommercialName = medicineCommercialName;
		this.timing = timing;
		this.posology = posology;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diseaseContractionId;
		result = prime * result + ((endedAt == null) ? 0 : endedAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((medicineCommercialName == null) ? 0 : medicineCommercialName.hashCode());
		result = prime * result + ((medicineName == null) ? 0 : medicineName.hashCode());
		result = prime * result + posology;
		result = prime * result + ((startedAt == null) ? 0 : startedAt.hashCode());
		result = prime * result + timing;
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
		MedicationDTO other = (MedicationDTO) obj;
		if (diseaseContractionId != other.diseaseContractionId)
			return false;
		if (endedAt == null) {
			if (other.endedAt != null)
				return false;
		} else if (!endedAt.equals(other.endedAt))
			return false;
		if (id != other.id)
			return false;
		if (medicineCommercialName == null) {
			if (other.medicineCommercialName != null)
				return false;
		} else if (!medicineCommercialName.equals(other.medicineCommercialName))
			return false;
		if (medicineName == null) {
			if (other.medicineName != null)
				return false;
		} else if (!medicineName.equals(other.medicineName))
			return false;
		if (posology != other.posology)
			return false;
		if (startedAt == null) {
			if (other.startedAt != null)
				return false;
		} else if (!startedAt.equals(other.startedAt))
			return false;
		if (timing != other.timing)
			return false;
		return true;
	}
	
}
