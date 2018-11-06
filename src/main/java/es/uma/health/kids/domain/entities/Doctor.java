package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.message.MessageInteractor;
import es.uma.health.kids.domain.valueobjects.user.UserEmail;
import es.uma.health.kids.domain.valueobjects.user.UserFullName;
import es.uma.health.kids.domain.valueobjects.user.UserId;
import es.uma.health.kids.domain.valueobjects.user.UserPassword;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Doctor extends User implements MessageInteractor {

    public Doctor(UserId id,
            UserFullName fullName,
            UserEmail email,
            UserPassword password) {
        super(id, fullName, email, password);
    }

    public Doctor id(UserId id) {
        return new Doctor(id, fullName, email, password);
    }

    public Doctor fullName(UserFullName fullName) {
        return new Doctor(id, fullName, email, password);
    }

    public Doctor email(UserEmail email) {
        return new Doctor(id, fullName, email, password);
    }

    public Doctor password(UserPassword password) {
        return new Doctor(id, fullName, email, password);
    }
}
