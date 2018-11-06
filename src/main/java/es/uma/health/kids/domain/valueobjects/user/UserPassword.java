package es.uma.health.kids.domain.valueobjects.user;

import es.uma.health.kids.util.PasswordUtils;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class UserPassword {

    private String encryptedPasswordString;

    public UserPassword(String encryptedPasswordString) {
        this.encryptedPasswordString = encryptedPasswordString;
    }

    public static UserPassword createNewEncrypted(String password, String salt) {
        return new UserPassword(PasswordUtils.generateSecurePassword(password, salt));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPassword that = (UserPassword) o;
        return Objects.equals(encryptedPasswordString, that.encryptedPasswordString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encryptedPasswordString);
    }
}
