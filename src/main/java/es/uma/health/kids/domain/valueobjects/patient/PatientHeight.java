package es.uma.health.kids.domain.valueobjects.patient;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientHeight {

    private int heightValue;

    public PatientHeight(int heightValue) {
        this.heightValue = heightValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatientHeight that = (PatientHeight) o;
        return heightValue == that.heightValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heightValue);
    }

    @Override
    public String toString() {
        return "PatientHeight{" +
                "heightValue=" + heightValue +
                '}';
    }
}
