package es.uma.health.kids.domain.model.user;

import es.uma.health.kids.domain.model.patient.Patient;

public class PatientResponsible extends User {

    private Address address;
    private PhoneNumber phoneNumber;

    public PatientResponsible(UserId id,
            UserFullName fullName,
            Email email,
            Password password,
            Address address,
            PhoneNumber phoneNumber) {
        super(id, fullName, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public PatientResponsible(UserId id,
            UserFullName fullName, Email email,
            Password password) {
        super(id, fullName, email, password);
    }

    public Address address() {
        return address;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

	@Override
	public boolean isDoctor() {
		return false;
	}

	@Override
	protected void checkMessageAuthorization(Patient patientAbout) {
		if (!patientAbout.patientResponsibleId().equals(id)) {
			throw new NotAuthorizedException();
		}
	}
    
}
