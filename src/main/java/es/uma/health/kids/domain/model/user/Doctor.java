package es.uma.health.kids.domain.model.user;

import es.uma.health.kids.domain.model.patient.Patient;

public class Doctor extends User {
	
    public Doctor(UserId id,
            UserFullName fullName,
            Email email,
            Password password) {
        super(id, fullName, email, password);
    }

	@Override
	public boolean isDoctor() {
		return true;
	}

	@Override
	protected void checkMessageAuthorization(Patient patientAbout) {
		if(!patientAbout.doctorId().equals(id)) {
			throw new NotAuthorizedException();
		}
	}
}
