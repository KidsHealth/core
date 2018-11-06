package es.uma.health.kids.domain.valueobjects.event;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class EventVenue {

    private static final int MAXIMUM_LENGTH = 500;
    private String venueString;

    public EventVenue(String venueString) {
        checkVenueLength(venueString);
        this.venueString = venueString;
    }

    private void checkVenueLength(String venueString) {
        if(venueString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Event venue '%s' is longer than the maximum length constraint %d.",
                    venueString, MAXIMUM_LENGTH));
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
        EventVenue that = (EventVenue) o;
        return Objects.equals(venueString, that.venueString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueString);
    }
}
