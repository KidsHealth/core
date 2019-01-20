package es.uma.health.kids.domain.model.event;

import java.util.Collection;

public interface EventRepository {

	public EventId nextIdentity();
	
	public void add(Event anEvent);
	
	public void update(Event anEvent);

	public void delete(Event anEvent);

	public Collection<Event> all();
	
	public Event ofId(EventId anId);
	
}
