package es.uma.health.kids.domain.model.patient;

import java.util.Objects;


public class Weight {

    private float weightValue;

    public Weight(float weightValue) {
        this.weightValue = weightValue;
    }
    
    public float value() {
    	return weightValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Weight that = (Weight) o;
        return weightValue == that.weightValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weightValue);
    }

    @Override
    public String toString() {
        return weightValue + " g";
    }
}
