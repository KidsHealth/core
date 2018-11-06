package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.document.*;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Document {

    private DocumentId id;
    private DocumentPath path;
    private DocumentType type;

    public Document(DocumentId id, DocumentPath path,
            DocumentType type) {
        this.id = id;
        this.path = path;
        this.type = type;
    }

    public Document(DocumentId id, DocumentPath path) {
        this.id = id;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(path, document.path) &&
                Objects.equals(type, document.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, type);
    }
}
