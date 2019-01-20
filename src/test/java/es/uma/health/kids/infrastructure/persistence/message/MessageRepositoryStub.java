package es.uma.health.kids.infrastructure.persistence.message;

import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.infrastructure.persistence.message.InMemoryMessageRepository;

public class MessageRepositoryStub {

	public static MessageRepository empty() {
		return new InMemoryMessageRepository();
	}

}
