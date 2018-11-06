package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.event.*;
import es.uma.health.kids.domain.valueobjects.patient.PatientId;
import java.util.Date;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Event {

    private EventId id;
    private EventTitle title;
    private EventDescription description;
    private EventVenue venue;
    private EventTopic topic;
    private Date startDatetime;
    private Date endDatetime;
    private PatientId patientId;

    public Event(EventId id, EventTitle title,
            EventDescription description, EventTopic topic, EventVenue venue, Date startDatetime,
            Date endDatetime, PatientId patientId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.venue = venue;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.patientId = patientId;
    }

    public Event(EventId id, EventTitle title, Date startDatetime, Date endDatetime,
            PatientId patientId) {
        this.id = id;
        this.title = title;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.patientId = patientId;
    }

    public EventId id() {
        return id;
    }

    public Event id(EventId id) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public EventTitle title() {
        return title;
    }

    public Event title(EventTitle title) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public EventDescription description() {
        return description;
    }

    public Event description(EventDescription description) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public EventVenue venue() {
        return venue;
    }

    public Event venue(EventVenue venue) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public Date startDatetime() {
        return startDatetime;
    }

    public Event startDatetime(Date startDatetime) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public Date endDatetime() {
        return endDatetime;
    }

    public Event endDatetime(Date endDatetime) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    public PatientId patientId() {
        return patientId;
    }

    public Event patientId(PatientId patientId) {
        return new Event(id, title, description, topic, venue, startDatetime, endDatetime, patientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(id, event.id) &&
                Objects.equals(title, event.title) &&
                Objects.equals(description, event.description) &&
                Objects.equals(venue, event.venue) &&
                Objects.equals(startDatetime, event.startDatetime) &&
                Objects.equals(endDatetime, event.endDatetime) &&
                Objects.equals(patientId, event.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, venue, startDatetime, endDatetime, patientId);
    }
}
