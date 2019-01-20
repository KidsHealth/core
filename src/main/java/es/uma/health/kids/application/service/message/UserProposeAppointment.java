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
import es.uma.health.kids.domain.model.user.User;
import es.uma.health.kids.domain.model.user.UserDoesNotExistException;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;

public class UserProposeAppointment {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private MessageRepository messageRepo;

	public UserProposeAppointment(UserRepository userRepo, PatientRepository patientRepo,
			MessageRepository messageRepo) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.messageRepo = messageRepo;
	}

	public void execute(ProposeAppointmentRequest request) {
	
		User user = userRepo.ofId(
				new UserId(request.userId));
		
		if (null == user) {
			throw new UserDoesNotExistException("User does not exist.");
		}
		
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));
		
		if (null == patient) {
			throw new PatientDoesNotExistException("Patient does not exist.");
		}
		
		AppointmentRequest proposedAppointment = user.proposeAppointment(
				messageRepo.nextIdentity(), 
				new MessageBody(request.body), 
				LocalDateTime.parse(
						request.proposedDatetime, 
						DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm")), 
				patient);
		
		messageRepo.add(proposedAppointment);
		
	}
}
