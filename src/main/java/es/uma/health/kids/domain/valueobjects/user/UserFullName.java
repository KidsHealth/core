package es.uma.health.kids.domain.valueobjects.user;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class UserFullName {

    private static int MAXIMUM_NAME_LENGTH = 255;
    private static int MAXIMUM_SURNAME_LENGTH = 255;

    private String nameString;
    private String surnameString;

    public UserFullName(String nameString, String surnameString) {
        checkNameLength(nameString);
        checkSurnameLength(surnameString);
        this.nameString = nameString;
        this.surnameString = surnameString;
    }

    private void checkNameLength(String stringName) {
        if (stringName.length() > MAXIMUM_NAME_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "User name '%s' is longer than the maximum length constraint %d.",
                            stringName, MAXIMUM_NAME_LENGTH));
        }
    }

    private void checkSurnameLength(String stringName) {
        if (stringName.length() > MAXIMUM_SURNAME_LENGTH) {
            throw new FieldTooLongException(
                    String.format(
                            "User surname '%s' is longer than the maximum length constraint %d.",
                            stringName, MAXIMUM_SURNAME_LENGTH));
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
        UserFullName that = (UserFullName) o;
        return Objects.equals(nameString, that.nameString) &&
                Objects.equals(surnameString, that.surnameString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameString, surnameString);
    }

}
