package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.message.MessageInteractor;
import es.uma.health.kids.domain.valueobjects.patient.*;
import es.uma.health.kids.domain.valueobjects.user.UserId;
import java.util.Date;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Patient implements MessageInteractor {

    private PatientId id;
    private PatientFullName fullName;
    private PatientHeight height;
    private PatientWeight weight;
    private Date birthdate;
    private UserId patientResponsibleId;

    public Patient(PatientId id,
            PatientFullName fullName,
            PatientHeight height, PatientWeight weight, Date birthdate,
            UserId patientResponsibleId) {
        this.id = id;
        this.fullName = fullName;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.patientResponsibleId = patientResponsibleId;
    }

    public Patient(PatientId id,
            PatientFullName fullName, Date birthdate,
            UserId patientResponsibleId) {
        this.id = id;
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.patientResponsibleId = patientResponsibleId;
    }

    public PatientId id() {
        return id;
    }

    public Patient id(PatientId id) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    public PatientFullName fullName() {
        return fullName;
    }

    public Patient fullName(PatientFullName fullName) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    public PatientHeight height() {
        return height;
    }

    public Patient height(PatientHeight height) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    public PatientWeight weight() {
        return weight;
    }

    public Patient weight(PatientWeight weight) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    public Date birthdate() {
        return birthdate;
    }

    public Patient birthdate(Date birthdate) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    public UserId patientResponsibleId() {
        return patientResponsibleId;
    }

    public Patient patientResponsibleId(UserId patientResponsibleId) {
        return new Patient(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(fullName, patient.fullName) &&
                Objects.equals(height, patient.height) &&
                Objects.equals(weight, patient.weight) &&
                Objects.equals(birthdate, patient.birthdate) &&
                Objects.equals(patientResponsibleId, patient.patientResponsibleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, height, weight, birthdate, patientResponsibleId);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", height=" + height +
                ", weight=" + weight +
                ", birthdate=" + birthdate +
                ", patientResponsibleId=" + patientResponsibleId +
                '}';
    }
}
