package es.uma.health.kids.domain.valueobjects.user;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class UserEmail {

    private static int MAXIMUM_LENGTH = 255;
    private String emailString;

    public UserEmail(String emailString) {
        checkEmailLength(emailString);
        this.emailString = emailString;
    }

    private void checkEmailLength(String stringName) {
        if (stringName.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "User email '%s' is longer than the maximum length constraint %d.",
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
        UserEmail userEmail = (UserEmail) o;
        return Objects.equals(emailString, userEmail.emailString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailString);
    }
}
