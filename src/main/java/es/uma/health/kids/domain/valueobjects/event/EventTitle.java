package es.uma.health.kids.domain.valueobjects.event;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class EventTitle {

    private static final int MAXIMUM_LENGTH = 255;
    private String titleString;

    public EventTitle(String titleString) {
        checkTitleLength(titleString);
        this.titleString = titleString;
    }

    private void checkTitleLength(String descriptionString) {
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
        EventTitle that = (EventTitle) o;
        return Objects.equals(titleString, that.titleString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleString);
    }
}
