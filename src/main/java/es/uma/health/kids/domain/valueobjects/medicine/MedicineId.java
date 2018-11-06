package es.uma.health.kids.domain.valueobjects.medicine;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class MedicineId {

    private int identifier;

    public MedicineId(int identifier) {
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
        MedicineId that = (MedicineId) o;
        return identifier == that.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
