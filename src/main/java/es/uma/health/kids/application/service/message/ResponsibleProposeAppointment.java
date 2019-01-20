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
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.PatientResponsibleDoesNotExistException;
import es.uma.health.kids.domain.model.user.PatientResponsibleId;
import es.uma.health.kids.domain.model.user.PatientResponsibleRepository;

public class ResponsibleProposeAppointment {

	private PatientResponsibleRepository prRepo;
	private PatientRepository patientRepo;
	private MessageRepository messageRepo;

	public ResponsibleProposeAppointment(PatientResponsibleRepository prRepo, PatientRepository patientRepo,
			MessageRepository messageRepo) {
		this.prRepo = prRepo;
		this.patientRepo = patientRepo;
		this.messageRepo = messageRepo;
	}

	public void execute(ProposeAppointmentRequest request) {
	
		PatientResponsible pr = prRepo.ofId(
				new PatientResponsibleId(request.userId));
		
		if (null == pr) {
			throw new PatientResponsibleDoesNotExistException("Patient responsible does not exist.");
		}
		
		Patient patient = patientRepo.ofId(new PatientId(request.patientId));
		
		if (null == patient) {
			throw new PatientDoesNotExistException("Patient does not exist.");
		}
		
		if (!patient.patientResponsibleId().equals(pr.id())) {
			throw new PatientDoesNotExistException("Patient not found for the given responsible.");
		}
		
		AppointmentRequest proposedAppointment = patient.proposeAppointment(
				messageRepo.nextIdentity(),
				new MessageBody(request.body),
				LocalDateTime.parse(request.proposedDatetime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
				false);
		
		messageRepo.add(proposedAppointment);
		
	}
	
}
