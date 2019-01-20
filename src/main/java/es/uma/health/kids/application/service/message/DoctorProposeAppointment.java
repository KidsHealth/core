package es.uma.health.kids.application.service.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import es.uma.health.kids.domain.model.message.AppointmentRequest;
import es.uma.health.kids.domain.model.message.MessageBody;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientDoesNotExistException;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.DoctorDoesNotExistException;
import es.uma.health.kids.domain.model.user.DoctorId;
import es.uma.health.kids.domain.model.user.DoctorRepository;

public class DoctorProposeAppointment {

	private DoctorRepository doctorRepo;
	private PatientRepository patientRepo;
	private MessageRepository messageRepo;

	public DoctorProposeAppointment(DoctorRepository doctorRepo, PatientRepository patientRepo,
			MessageRepository messageRepo) {
		this.doctorRepo = doctorRepo;
		this.patientRepo = patientRepo;
		this.messageRepo = messageRepo;
	}

	public void execute(ProposeAppointmentRequest request) {
	
		Doctor doctor = doctorRepo.ofId(
				new DoctorId(request.userId));
		
		if (null == doctor) {
			throw new DoctorDoesNotExistException("Doctor does not exist.");
		}
		
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));
		
		if (null == patient) {
			throw new PatientDoesNotExistException("Patient does not exist.");
		}
		
		if (!patient.doctorId().equals(doctor.id())) {
			throw new PatientDoesNotExistException("Patient not found for the given doctor.");
		}
		
		AppointmentRequest proposedAppointment = patient.proposeAppointment(
				messageRepo.nextIdentity(),
				new MessageBody(request.body),
				LocalDateTime.parse(request.proposedDatetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
				true);
		
		messageRepo.add(proposedAppointment);
		
	}
	
}
