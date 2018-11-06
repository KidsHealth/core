package es.uma.health.kids.domain.valueobjects.event;

import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class EventId {

    private int identifier;

    public EventId(int identifier) {
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
        EventId eventId = (EventId) o;
        return identifier == eventId.identifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
