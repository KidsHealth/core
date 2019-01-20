package es.uma.health.kids;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.uma.health.kids.application.service.message.UserProposeAppointmentTest;
import es.uma.health.kids.application.service.message.UserSendMessageTest;

@RunWith(Suite.class)
@SuiteClasses({
	UserSendMessageTest.class,
	UserProposeAppointmentTest.class
})
public class AllTests {}
