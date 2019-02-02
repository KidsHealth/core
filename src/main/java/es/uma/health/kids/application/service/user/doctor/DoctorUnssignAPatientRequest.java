package es.uma.health.kids.application.service.user.doctor;

public class DoctorUnssignAPatientRequest {

	public int doctorId;
	public int patientId;
	
	public DoctorUnssignAPatientRequest(int doctorId, int patientId) {
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	
}
