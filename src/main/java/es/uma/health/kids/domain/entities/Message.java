package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.message.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Message {

    private MessageId id;
    private MessageBody body;
    private Date sendedAt;
    private MessageInteractor sender;
    private MessageInteractor receiver;

    public Message(MessageId id, MessageBody body, Date sendedAt,
            MessageInteractor sender,
            MessageInteractor receiver) {
        this.id = id;
        this.body = body;
        this.sendedAt = sendedAt;
        this.sender = sender;
        this.receiver = receiver;
    }

    public MessageId id() {
        return id;
    }

    public Message id(MessageId id) {
        return new Message(id, body, sendedAt, sender, receiver);
    }

    public MessageBody body() {
        return body;
    }

    public Message body(MessageBody body) {
        return new Message(id, body, sendedAt, sender, receiver);
    }

    public Date sendedAt() {
        return sendedAt;
    }

    public Message sendedAt(Date sendedAt) {
        return new Message(id, body, sendedAt, sender, receiver);
    }

    public MessageInteractor sender() {
        return sender;
    }

    public Message sender(MessageInteractor sender) {
        return new Message(id, body, sendedAt, sender, receiver);
    }

    public MessageInteractor receiver() {
        return receiver;
    }

    public Message receiver(MessageInteractor receiver) {
        return new Message(id, body, sendedAt, sender, receiver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(body, message.body) &&
                Objects.equals(sendedAt, message.sendedAt) &&
                Objects.equals(sender, message.sender) &&
                Objects.equals(receiver, message.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, sendedAt, sender, receiver);
    }
}
