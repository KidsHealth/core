package es.uma.health.kids.domain.model.medication;

import java.util.Objects;

public class MedicineName {

    private String nameString;

    public MedicineName(String nameString) {
        this.nameString = nameString;
    }
    
    public String value() {
    	return nameString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MedicineName that = (MedicineName) o;
        return Objects.equals(nameString, that.nameString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameString);
    }
}
