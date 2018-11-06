package es.uma.health.kids.domain.valueobjects.document;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DocumentType {

    private static final int MAXIMUM_LENGTH = 255;

    private String typeString;

    public DocumentType(String typeString) {
        checkNameLength(typeString);
        this.typeString = typeString;
    }

    private void checkNameLength(String stringName) {
        if (stringName.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "Document type '%s' is longer than the maximum length constraint %d.",
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
        DocumentType that = (DocumentType) o;
        return Objects.equals(typeString, that.typeString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeString);
    }
}
