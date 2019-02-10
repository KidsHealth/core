package es.uma.health.kids.domain.model.message;

import java.time.LocalDateTime;

import es.uma.health.kids.domain.event.DomainEvent;
import es.uma.health.kids.domain.model.patient.PatientId;

public class AppointmentAccepted extends DomainEvent {

	private MessageId appointmentId;
	private LocalDateTime datetimeProposed;
	private PatientId patientId;

	public AppointmentAccepted(MessageId appointmentId, LocalDateTime datetimeProposed,
			PatientId patientId) {
		super();
		this.appointmentId = appointmentId;
		this.datetimeProposed = datetimeProposed;
		this.patientId = patientId;
	}

	public MessageId appointmentId() {
		return appointmentId;
	}
	
	public LocalDateTime datetimeProposed() {
		return datetimeProposed;
	}

	public PatientId patientId() {
		return patientId;
	}
	
}
