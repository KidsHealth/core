package es.uma.health.kids.domain.valueobjects.patient;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientId {

    private int identifier;

    public PatientId(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatientId patientId = (PatientId) o;
        return identifier == patientId.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return "PatientId{" +
                "identifier=" + identifier +
                '}';
    }
}
