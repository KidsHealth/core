package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.disease.*;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Disease {

    private DiseaseId id;
    private DiseaseName name;
    private DiseaseShortName shortName;

    public Disease(DiseaseId id, DiseaseName name,
            DiseaseShortName shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Disease(DiseaseId id, DiseaseName name) {
        this.id = id;
        this.name = name;
    }

    public DiseaseId id() {
        return id;
    }

    public Disease id(DiseaseId id) {
        return new Disease(id, name, shortName);
    }

    public DiseaseName name() {
        return name;
    }

    public Disease name(DiseaseName name) {
        return new Disease(id, name, shortName);
    }

    public DiseaseShortName shortName() {
        return shortName;
    }

    public Disease shortName(DiseaseShortName shortName) {
        return new Disease(id, name, shortName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Disease disease = (Disease) o;
        return Objects.equals(id, disease.id) &&
                Objects.equals(name, disease.name) &&
                Objects.equals(shortName, disease.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }
}
