package es.uma.health.kids.infrastructure.persistence.message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.uma.health.kids.domain.model.message.Message;
import es.uma.health.kids.domain.model.message.MessageId;
import es.uma.health.kids.domain.model.message.MessageRepository;

public class InMemoryMessageRepository implements MessageRepository {

	private Map<MessageId, Message> messages;
	
	public InMemoryMessageRepository() {
		messages = new HashMap<>();
	}

	@Override
	public MessageId nextIdentity() {
		return new MessageId(messages.size() + 1);
	}

	@Override
	public void add(Message aMessage) {
		messages.put(aMessage.id(), aMessage);
	}

	@Override
	public void update(Message aMessage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Message aMessage) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Message> all() {
		return new ArrayList<>(messages.values());
	}

	@Override
	public Message ofId(MessageId anId) {
		return messages.get(anId);
	}

}
