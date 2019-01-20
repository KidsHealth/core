package es.uma.health.kids.infrastructure.persistence.message;

import java.util.stream.Stream;

import es.uma.health.kids.domain.model.message.AppointmentRequest;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.infrastructure.persistence.message.InMemoryMessageRepository;

public class MessageRepositoryStub {

	public static MessageRepository empty() {
		return new InMemoryMessageRepository();
	}

	public static MessageRepository with(AppointmentRequest ...apRequests) {
		MessageRepository repo = new InMemoryMessageRepository();
		Stream.of(apRequests).forEach(repo::add);
		return repo;
	}

}
