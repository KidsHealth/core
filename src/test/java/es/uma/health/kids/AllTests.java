package es.uma.health.kids;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uma.health.kids.application.service.message.UpdateProposedAppointmentTest;
import es.uma.health.kids.application.service.message.UserProposeAppointmentTest;
import es.uma.health.kids.application.service.message.UserSendMessageTest;
import es.uma.health.kids.application.service.message.UserViewMessagesTest;
import es.uma.health.kids.application.service.patient.ViewDetailedPatientTest;
import es.uma.health.kids.application.service.user.UserViewTheirPatientsTest;
import es.uma.health.kids.application.service.user.doctor.DoctorAddTreatmentTest;
import es.uma.health.kids.application.service.user.doctor.DoctorAssignNewPatientTest;
import es.uma.health.kids.application.service.user.doctor.DoctorDiagnosesAPatientTest;
import es.uma.health.kids.application.service.user.doctor.DoctorUnassignAPatientTest;
import es.uma.health.kids.application.service.user.patientresponsible.ResponsibleAddPatientTest;
import es.uma.health.kids.application.service.user.patientresponsible.ResponsibleDeletePatientTest;
import es.uma.health.kids.application.service.user.patientresponsible.ResponsibleUpdatePatientTest;

@RunWith(Suite.class)
@SuiteClasses({
	UpdateProposedAppointmentTest.class,
	UserProposeAppointmentTest.class,
	UserSendMessageTest.class,
	UserViewMessagesTest.class,
	ViewDetailedPatientTest.class,
	DoctorAddTreatmentTest.class,
	DoctorAssignNewPatientTest.class,
	DoctorDiagnosesAPatientTest.class,
	DoctorUnassignAPatientTest.class,
	ResponsibleAddPatientTest.class,
	ResponsibleDeletePatientTest.class,
	ResponsibleUpdatePatientTest.class,
	UserViewTheirPatientsTest.class,
})
public class AllTests {}
