package es.uma.health.kids.domain.model.user;

import es.uma.health.kids.domain.model.patient.Patient;

public class PatientResponsible extends User {

    private Address address;
    private PhoneNumber phoneNumber;

    public PatientResponsible(PatientResponsibleId id,
            UserFullName fullName,
            Email email,
            Password password,
            Address address,
            PhoneNumber phoneNumber) {
        super(id, fullName, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public PatientResponsibleId id() {
    	return (PatientResponsibleId) id;
    }

    public PatientResponsible(PatientResponsibleId id,
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
	protected boolean isDoctor() {
		return false;
	}

	@Override
	protected void checkMessageAuthorization(Patient patientAbout) {
		if (!patientAbout.patientResponsibleId().equals(id)) {
			throw new NotAuthorizedException();
		}
	}
    
}
