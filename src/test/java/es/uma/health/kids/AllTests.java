package es.uma.health.kids;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uma.health.kids.application.service.message.UpdateProposedAppointmentTest;
import es.uma.health.kids.application.service.message.UserProposeAppointmentTest;
import es.uma.health.kids.application.service.message.UserSendMessageTest;
import es.uma.health.kids.application.service.message.UserViewMessagesTest;

@RunWith(Suite.class)
@SuiteClasses({
	UserSendMessageTest.class,
	UserProposeAppointmentTest.class,
	UpdateProposedAppointmentTest.class,
	UserViewMessagesTest.class
})
public class AllTests {}
