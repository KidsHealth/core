package es.uma.health.kids.application.service.message;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import es.uma.health.kids.domain.model.message.AppointmentRequest;
import es.uma.health.kids.domain.model.message.MessageId;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.domain.model.message.AppointmentRequest.Status;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.DoctorId;
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.PatientResponsibleId;
import es.uma.health.kids.domain.model.user.PatientResponsibleRepository;
import es.uma.health.kids.infrastructure.persistence.message.MessageRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.patient.PatientRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.user.PatientResponsibleRepositoryStub;

public class UserProposeAppointmentTest {

	@Test
	public void shouldAResponsibleProposeAnAppointment() {
		
		PatientResponsible aResponsible = new PatientResponsible(new PatientResponsibleId(1), null, null, null);
		
		Patient aPatient = new Patient(
				new PatientId(1), null, null, 
				aResponsible.id(), 
				new DoctorId(1));
		
		AppointmentRequest expectedAR = new AppointmentRequest(
				new MessageId(1), 
				null, null,
				false,
				new DoctorId(1),
				aPatient.id(),
				LocalDateTime.of(2019, 1, 31, 9, 30),
				null,
				Status.PENDING);
		
		PatientResponsibleRepository prRepo = PatientResponsibleRepositoryStub.with(aResponsible);
		PatientRepository patientRepo = PatientRepositoryStub.with(aPatient);
		MessageRepository messageRepo = MessageRepositoryStub.empty();
		
		new UserProposeAppointment(prRepo, patientRepo, messageRepo).execute(
					new ProposeAppointmentRequest(1, 1, null, "2019-01-31 09:30")
				);
		
		AppointmentRequest actualAR = (AppointmentRequest) messageRepo.ofId(expectedAR.id());
		
		assertNotNull(actualAR);
		assertEquals(expectedAR, actualAR);
		assertEquals(expectedAR.doctorId(), actualAR.doctorId());
		assertEquals(expectedAR.patientId(), actualAR.patientId());
		assertEquals(expectedAR.datetimeProposed(), actualAR.datetimeProposed());
		assertEquals(expectedAR.status(), actualAR.status());
		assertFalse(actualAR.isDoctorTheSender());
	
	}

}
