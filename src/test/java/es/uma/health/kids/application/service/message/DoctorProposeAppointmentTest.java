package es.uma.health.kids.application.service.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import es.uma.health.kids.domain.model.message.AppointmentRequest;
import es.uma.health.kids.domain.model.message.AppointmentRequest.Status;
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

public class DoctorProposeAppointmentTest {

	@Test
	public void shouldADoctorProposeAnAppointment() {
		
		Doctor aDoctor = new Doctor(new DoctorId(1), null, null, null);
		
		Patient aPatient = new Patient(
				new PatientId(1), null, null, 
				new PatientResponsibleId(1), 
				aDoctor.id());
		
		AppointmentRequest expectedAR = new AppointmentRequest(
				new MessageId(1), 
				null, null,
				true,
				aDoctor.id(),
				aPatient.id(),
				LocalDateTime.of(2019, 1, 31, 9, 30),
				null,
				Status.PENDING);
		
		DoctorRepository doctorRepo = DoctorRepositoryStub.with(aDoctor);
		PatientRepository patientRepo = PatientRepositoryStub.with(aPatient);
		MessageRepository messageRepo = MessageRepositoryStub.empty();
		
		new DoctorProposeAppointment(doctorRepo, patientRepo, messageRepo).execute(
					new ProposeAppointmentRequest(1, 1, null, "2019-01-31 09:30")
				);
		
		AppointmentRequest actualAR = (AppointmentRequest) messageRepo.ofId(expectedAR.id());
		
		assertNotNull(actualAR);
		assertEquals(expectedAR, actualAR);
		assertEquals(expectedAR.doctorId(), actualAR.doctorId());
		assertEquals(expectedAR.patientId(), actualAR.patientId());
		assertEquals(expectedAR.datetimeProposed(), actualAR.datetimeProposed());
		assertEquals(expectedAR.status(), actualAR.status());
		assertTrue(actualAR.isDoctorTheSender());
	
	}

}
