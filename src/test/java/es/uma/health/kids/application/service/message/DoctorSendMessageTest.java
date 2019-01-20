package es.uma.health.kids.application.service.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.uma.health.kids.application.service.message.DoctorSendMessage;
import es.uma.health.kids.application.service.message.SendMessageRequest;
import es.uma.health.kids.domain.model.message.Message;
import es.uma.health.kids.domain.model.message.MessageId;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.DoctorId;
import es.uma.health.kids.domain.model.user.DoctorRepository;
import es.uma.health.kids.domain.model.user.PatientResponsibleId;
import es.uma.health.kids.infrastructure.persistence.message.MessageRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.patient.PatientRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.user.DoctorRepositoryStub;

public class DoctorSendMessageTest {

	@Test
	public void shouldSendMessageToAPatientResponsible() {
		
		Doctor aDoctor = new Doctor(new DoctorId(1), null, null, null);
		
		Patient aPatient = new Patient(
				new PatientId(1), null, null, 
				new PatientResponsibleId(1), 
				aDoctor.id());
		
		Message expectedMessage = new Message(
				new MessageId(1), null, null, 
				false, aDoctor.id(), aPatient.id());
		
		DoctorRepository doctorRepo = DoctorRepositoryStub.with(aDoctor);
		PatientRepository patientRepo = PatientRepositoryStub.with(aPatient);
		MessageRepository messageRepo = MessageRepositoryStub.empty();
		
		new DoctorSendMessage(doctorRepo, patientRepo, messageRepo).execute(
					new SendMessageRequest(1, 1, null)
				);
		
		Message actualMessage = messageRepo.ofId(expectedMessage.id());
		
		assertNotNull(actualMessage);
		assertEquals(expectedMessage, actualMessage);
		assertEquals(expectedMessage.doctorId(), actualMessage.doctorId());
		assertEquals(expectedMessage.patientId(), actualMessage.patientId());
		assertTrue(actualMessage.isDoctorTheSender());
	
	}
}
