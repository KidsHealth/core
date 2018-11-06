package es.uma.health.kids.domain.valueobjects.event;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class EventDescription {

    private static final int MAXIMUM_LENGTH = 2000;
    private String descriptionString;

    public EventDescription(String descriptionString) {
        checkDescriptionLength(descriptionString);
        this.descriptionString = descriptionString;
    }
    
    private void checkDescriptionLength(String descriptionString) {
        if(descriptionString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Event title '%s' is longer than the maximum length constraint %d.",
                    descriptionString, MAXIMUM_LENGTH));
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
        EventDescription that = (EventDescription) o;
        return Objects.equals(descriptionString, that.descriptionString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptionString);
    }
}
