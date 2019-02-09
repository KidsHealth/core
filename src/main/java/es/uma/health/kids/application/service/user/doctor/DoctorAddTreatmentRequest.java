package es.uma.health.kids.application.service.user.doctor;

public class DoctorAddTreatmentRequest {

	public int doctorId;
	public int diseaseContractionId;
	public String medicineName;
	public String medicineCommercialName;
	public int timing;
	public int posology;
	public String startedAt;
	public String endedAt;
	
	public DoctorAddTreatmentRequest(int doctorId, int diseaseContractionId, String medicineName,
			String medicineCommercialName, int timing, int posology, String startedAt, String endedAt) {
		this.doctorId = doctorId;
		this.diseaseContractionId = diseaseContractionId;
		this.medicineName = medicineName;
		this.medicineCommercialName = medicineCommercialName;
		this.timing = timing;
		this.posology = posology;
		this.startedAt = startedAt;
		this.endedAt = endedAt;
	}

	public DoctorAddTreatmentRequest() {
	}
	
}
