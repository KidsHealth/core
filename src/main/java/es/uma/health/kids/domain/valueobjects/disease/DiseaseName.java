package es.uma.health.kids.domain.valueobjects.disease;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DiseaseName {

    protected static final int MAXIMUM_LENGTH = 500;
    private String stringName;

    public DiseaseName(String stringName) {
        checkNameLength(stringName);
        this.stringName = stringName;
    }

    private void checkNameLength(String stringName) {
        if (stringName.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "Disease name '%s' is longer than the maximum length constraint %d.",
                            stringName, MAXIMUM_LENGTH));
        }
    }

    public String stringName() {
        return stringName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiseaseName that = (DiseaseName) o;
        return Objects.equals(stringName, that.stringName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringName);
    }
}
