package es.uma.health.kids.domain.valueobjects.document;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DocumentPath {

    private static final int MAXIMUM_LENGTH = 3000;

    private String pathString;

    public DocumentPath(String pathString) {
        checkNameLength(pathString);
        this.pathString = pathString;
    }

    private void checkNameLength(String stringName) {
        if (stringName.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "Document path '%s' is longer than the maximum length constraint %d.",
                            stringName, MAXIMUM_LENGTH));
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
        DocumentPath that = (DocumentPath) o;
        return Objects.equals(pathString, that.pathString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathString);
    }

}
