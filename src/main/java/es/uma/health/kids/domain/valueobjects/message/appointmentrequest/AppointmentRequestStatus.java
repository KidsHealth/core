package es.uma.health.kids.domain.valueobjects.message.appointmentrequest;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class AppointmentRequestStatus {

    public static int REJECTED = 0;
    public static int PENDING = 1;
    public static int ACCEPTED = 2;

    private int statusIdentifier;

    private AppointmentRequestStatus(int statusIdentifier) {
        this.statusIdentifier = statusIdentifier;
    }

    public static AppointmentRequestStatus rejectedStatus() {
        return new AppointmentRequestStatus(REJECTED);
    }

    public static AppointmentRequestStatus acceptedStatus() {
        return new AppointmentRequestStatus(ACCEPTED);
    }

    public int statusIdentifier() {
        return statusIdentifier;
    }

    public boolean isRejected() {
        return statusIdentifier == REJECTED;
    }

    public boolean isPending() {
        return statusIdentifier == PENDING;
    }

    public boolean isAccepted() {
        return statusIdentifier == ACCEPTED;
    }

}
