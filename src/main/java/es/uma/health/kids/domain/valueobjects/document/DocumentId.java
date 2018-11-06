package es.uma.health.kids.domain.valueobjects.document;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DocumentId {

    private int identifier;

    public DocumentId(int identifier) {
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
        DocumentId that = (DocumentId) o;
        return identifier == that.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
