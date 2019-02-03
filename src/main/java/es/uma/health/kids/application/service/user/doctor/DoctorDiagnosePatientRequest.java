package es.uma.health.kids.application.service.user.doctor;

public class DoctorDiagnosePatientRequest {

	public int doctorId;
	public int patientId;
	public String diseaseName;
	public String diseaseShortName;
	
	public DoctorDiagnosePatientRequest(int doctorId, int patientId, String diseaseName,
			String diseaseShortName) {
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.diseaseName = diseaseName;
		this.diseaseShortName = diseaseShortName;
	}
	
}
