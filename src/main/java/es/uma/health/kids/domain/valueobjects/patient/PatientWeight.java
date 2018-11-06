package es.uma.health.kids.domain.valueobjects.patient;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientWeight {

    private int weightValue;

    public PatientWeight(int weightValue) {
        this.weightValue = weightValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PatientWeight that = (PatientWeight) o;
        return weightValue == that.weightValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightValue);
    }

    @Override
    public String toString() {
        return "PatientWeight{" +
                "weightValue=" + weightValue +
                '}';
    }
}
