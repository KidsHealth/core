package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.user.UserEmail;
import es.uma.health.kids.domain.valueobjects.user.UserFullName;
import es.uma.health.kids.domain.valueobjects.user.UserId;
import es.uma.health.kids.domain.valueobjects.user.UserPassword;
import es.uma.health.kids.domain.valueobjects.user.patientresponsible.*;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientResponsible extends User {

    private PatientResponsibleAddress address;
    private PatientResponsiblePhoneNumber phoneNumber;

    public PatientResponsible(UserId id,
            UserFullName fullName,
            UserEmail email,
            UserPassword password,
            PatientResponsibleAddress address,
            PatientResponsiblePhoneNumber phoneNumber) {
        super(id, fullName, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public PatientResponsible(UserId id,
            UserFullName fullName, UserEmail email,
            UserPassword password) {
        super(id, fullName, email, password);
    }

    public PatientResponsibleAddress address() {
        return address;
    }

    public PatientResponsible address(
            PatientResponsibleAddress address) {
        return new PatientResponsible(id, fullName, email, password, address, phoneNumber);
    }

    public PatientResponsiblePhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public PatientResponsible phoneNumber(
            PatientResponsiblePhoneNumber phoneNumber) {
        return new PatientResponsible(id, fullName, email, password, address, phoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        PatientResponsible that = (PatientResponsible) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, phoneNumber);
    }
}
