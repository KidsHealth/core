package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.message.MessageId;
import es.uma.health.kids.domain.valueobjects.message.appointmentrequest.AppointmentRequestStatus;
import java.util.Date;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class AppointmentRequest {

    private Date updatedAt;
    private AppointmentRequestStatus status;
    private MessageId messageId;

    public AppointmentRequest(Date updatedAt,
            AppointmentRequestStatus status, MessageId messageId) {
        this.updatedAt = updatedAt;
        this.status = status;
        this.messageId = messageId;
    }

    public AppointmentRequest(
            AppointmentRequestStatus status) {
        this.status = status;
    }

    public Date updatedAt() {
        return updatedAt;
    }

    public AppointmentRequest updatedAt(Date updatedAt) {
        return new AppointmentRequest(this.updatedAt, status, messageId);
    }

    public AppointmentRequestStatus status() {
        return status;
    }

    public AppointmentRequest status(
            AppointmentRequestStatus status) {
        return new AppointmentRequest(this.updatedAt, status, messageId);
    }

    public MessageId messageId() {
        return messageId;
    }

    public AppointmentRequest messageId(
            MessageId messageId) {
        return new AppointmentRequest(this.updatedAt, status, messageId);
    }

    public AppointmentRequest reject() {
        return status(AppointmentRequestStatus.rejectedStatus());
    }

    public AppointmentRequest accept() {
        return status(AppointmentRequestStatus.acceptedStatus());
    }

    public boolean isRejected() {
        return status.isRejected();
    }

    public boolean isPending() {
        return status.isPending();
    }

    public boolean isAccepted() {
        return status.isAccepted();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppointmentRequest that = (AppointmentRequest) o;
        return Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(status, that.status) &&
                Objects.equals(messageId, that.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updatedAt, status, messageId);
    }
}
