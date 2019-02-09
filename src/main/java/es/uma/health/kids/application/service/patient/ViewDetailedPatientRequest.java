package es.uma.health.kids.application.service.patient;

public class ViewDetailedPatientRequest {

	public int userId;
	public int patientId;
	
	public ViewDetailedPatientRequest(int userId, int patientId) {
		this.userId = userId;
		this.patientId = patientId;
	}

	public ViewDetailedPatientRequest() {
	}
	
}
