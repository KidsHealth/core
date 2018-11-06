package es.uma.health.kids.domain.valueobjects.medicine;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class MedicineName {

    private static final int MAXIMUM_LENGTH = 255;
    private String nameString;

    public MedicineName(String nameString) {
        checkTitleLength(nameString);
        this.nameString = nameString;
    }

    private void checkTitleLength(String nameString) {
        if(nameString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Medicine name '%s' is longer than the maximum length constraint %d.",
                    nameString, MAXIMUM_LENGTH));
        }
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
