package es.uma.health.kids.domain.valueobjects.event;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class EventTopic {

    private static final int MAXIMUM_LENGTH = 500;
    private String topicString;

    public EventTopic(String venueString) {
        checkTopicLength(venueString);
        this.topicString = venueString;
    }

    private void checkTopicLength(String venueString) {
        if(venueString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Event topic '%s' is longer than the maximum length constraint %d.",
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
        EventTopic that = (EventTopic) o;
        return Objects.equals(topicString, that.topicString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicString);
    }
}
