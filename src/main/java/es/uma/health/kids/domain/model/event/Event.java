package es.uma.health.kids.domain.model.event;

import java.util.Date;

import es.uma.health.kids.domain.model.patient.PatientId;


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
            Date endDatetime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.topic(topic);
        this.venue = venue;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
    }

    public Event(EventId id, EventTitle title, Date startDatetime, Date endDatetime) {
        this.id = id;
        this.title = title;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
    }

    public EventId id() {
        return id;
    }

    public EventTitle title() {
        return title;
    }

    public void title(EventTitle title) {
    	this.title = title;
    }

    public EventDescription description() {
        return description;
    }

    public void description(EventDescription description) {
    	this.description = description;
    }

    public EventVenue venue() {
        return venue;
    }

    public void venue(EventVenue venue) {
    	this.venue = venue;
    }

    public Date startDatetime() {
        return startDatetime;
    }

    public void startDatetime(Date startDatetime) {
    	this.startDatetime = startDatetime;
    }

    public Date endDatetime() {
        return endDatetime;
    }

    public void endDatetime(Date endDatetime) {
    	this.endDatetime = endDatetime;
    }

	public EventTopic topic() {
		return topic;
	}

	public void topic(EventTopic topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public PatientId patientId() {
		return patientId;
	}

	public void patientId(PatientId patientId) {
		this.patientId = patientId;
	}

}
