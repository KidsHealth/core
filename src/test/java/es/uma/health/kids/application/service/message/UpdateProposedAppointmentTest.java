package es.uma.health.kids.application.service.message;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import es.uma.health.kids.domain.model.message.AppointmentRequest;
import es.uma.health.kids.domain.model.message.AppointmentRequest.Status;
import es.uma.health.kids.domain.model.message.MessageId;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientId;
import es.uma.health.kids.domain.model.user.Doctor;
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;
import es.uma.health.kids.infrastructure.persistence.message.MessageRepositoryStub;
import es.uma.health.kids.infrastructure.persistence.user.UserRepositoryStub;

public class UpdateProposedAppointmentTest {

	private UserRepository userRepo;
	private MessageRepository messageRepo;
	private AppointmentRequest anAppointmentRequestProposedByDoctor;
	private AppointmentRequest anAppointmentRequestProposedByResponsible;
	private PatientResponsible aResponsible;
	private Doctor aDoctor;
	
	@Before
	public void setUp() {
		aResponsible = new PatientResponsible(new UserId(1), null, null, null);
		aDoctor = new Doctor(new UserId(2), null, null, null);
		
		Patient aPatient = new Patient(
				new PatientId(1), null, null, 
				aResponsible.id(), 
				aDoctor.id());
		
		anAppointmentRequestProposedByDoctor = new AppointmentRequest(
				new MessageId(1), 
				null, null,
				true,
				aDoctor.id(),
				aPatient.id(),
				LocalDateTime.of(2019, 1, 31, 9, 30),
				null,
				Status.PENDING);
		
		anAppointmentRequestProposedByResponsible = new AppointmentRequest(
				new MessageId(2), 
				null, null,
				false,
				aDoctor.id(),
				aPatient.id(),
				LocalDateTime.of(2019, 1, 30, 10, 30),
				null,
				Status.PENDING);
		
		userRepo = UserRepositoryStub.with(aResponsible, aDoctor);
		messageRepo = MessageRepositoryStub.with(anAppointmentRequestProposedByDoctor, anAppointmentRequestProposedByResponsible);
	}

	@Test
	public void shouldAProposedAppointmentByDoctorBeAcceptedByResponsible() {
		
		new UpdateProposedAppointment(userRepo, messageRepo).execute(
					new UpdateProposedAppointmentRequest(1,1,true)
				);
		
		AppointmentRequest actualApRequest = (AppointmentRequest) messageRepo.ofId(new MessageId(1));
		
		assertTrue(actualApRequest.isAccepted());
		
	}

}
