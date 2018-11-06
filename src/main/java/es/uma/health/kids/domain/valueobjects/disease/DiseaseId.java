package es.uma.health.kids.domain.valueobjects.disease;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DiseaseId {

    private int identifier;

    public DiseaseId(int identifier) {
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
        DiseaseId diseaseId = (DiseaseId) o;
        return identifier == diseaseId.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
