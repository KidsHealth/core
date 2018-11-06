package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.user.*;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public abstract class User {

    protected UserId id;
    protected UserFullName fullName;
    protected UserEmail email;
    protected UserPassword password;

    public User(UserId id, UserFullName fullName,
            UserEmail email, UserPassword password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public UserId id() {
        return id;
    }

    public UserFullName fullName() {
        return fullName;
    }

    public UserEmail email() {
        return email;
    }

    public UserPassword password() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password);
    }
}
