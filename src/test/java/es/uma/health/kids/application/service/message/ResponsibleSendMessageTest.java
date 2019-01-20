package es.uma.health.kids.application.service.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import es.uma.health.kids.application.service.message.ResponsibleSendMessage;
import es.uma.health.kids.application.service.message.SendMessageRequest;
import es.uma.health.kids.domain.model.message.Message;
import es.uma.health.kids.domain.model.message.MessageId;
import es.uma.health.kids.domain.model.message.MessageRepository;
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

public class ResponsibleSendMessageTest {

	@Test
	public void shouldSendMessageToAPatientDoctor() {
		
		PatientResponsible aResponsible = new PatientResponsible(
				new PatientResponsibleId(1),
				null, null, null);
		
		Patient aPatient = new Patient(
				new PatientId(1), null, null, 
				aResponsible.id(), 
				new DoctorId(1));
		
		Message expectedMessage = new Message(
				new MessageId(1), null, null, 
				false, new DoctorId(1), aPatient.id());
		
		PatientResponsibleRepository prRepo = PatientResponsibleRepositoryStub.with(aResponsible);
		PatientRepository patientRepo = PatientRepositoryStub.with(aPatient);
		MessageRepository messageRepo = MessageRepositoryStub.empty();
		
		new ResponsibleSendMessage(prRepo, patientRepo, messageRepo).execute(
					new SendMessageRequest(1, 1, null)
				);
		
		Message actualMessage = messageRepo.ofId(expectedMessage.id());
		
		assertNotNull(actualMessage);
		assertEquals(expectedMessage, actualMessage);
		assertEquals(expectedMessage.doctorId(), actualMessage.doctorId());
		assertEquals(expectedMessage.patientId(), actualMessage.patientId());
		assertFalse(actualMessage.isDoctorTheSender());
	
	}

}
