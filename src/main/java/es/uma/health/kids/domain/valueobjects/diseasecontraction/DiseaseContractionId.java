package es.uma.health.kids.domain.valueobjects.diseasecontraction;

import es.uma.health.kids.domain.valueobjects.disease.DiseaseId;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DiseaseContractionId {

    private int identifier;

    public DiseaseContractionId(int identifier) {
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
        DiseaseContractionId that = (DiseaseContractionId) o;
        return identifier == that.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

}
