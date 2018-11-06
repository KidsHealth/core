package es.uma.health.kids.domain.valueobjects.message;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class MessageBody {

    private static final int MAXIMUM_LENGTH = 5000;
    private String bodyString;

    public MessageBody(String bodyString) {
        this.bodyString = bodyString;
    }

    private void checkBodyLength(String bodyString) {
        if(bodyString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Message body '%s' is longer than the maximum length constraint %d.",
                    bodyString, MAXIMUM_LENGTH));
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
        MessageBody that = (MessageBody) o;
        return Objects.equals(bodyString, that.bodyString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodyString);
    }
}
