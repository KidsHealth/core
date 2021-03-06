package es.uma.health.kids.application.service.message;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import es.uma.health.kids.application.dto.message.ConversationDTO;
import es.uma.health.kids.application.dto.message.MessageDTO;
import es.uma.health.kids.application.dto.message.MessageMapper;
import es.uma.health.kids.application.dto.patient.PatientMapper;
import es.uma.health.kids.domain.model.message.MessageRepository;
import es.uma.health.kids.domain.model.patient.Patient;
import es.uma.health.kids.domain.model.patient.PatientRepository;
import es.uma.health.kids.domain.model.user.User;
import es.uma.health.kids.domain.model.user.UserDoesNotExistException;
import es.uma.health.kids.domain.model.user.UserId;
import es.uma.health.kids.domain.model.user.UserRepository;

public class UserViewMessages {

	private UserRepository userRepo;
	private PatientRepository patientRepo;
	private MessageRepository messageRepo;
	private MessageMapper messageMapper;
	private PatientMapper patientMapper;

	public UserViewMessages(UserRepository userRepo, PatientRepository patientRepo,
			MessageRepository messageRepo, MessageMapper messageMapper, PatientMapper patientMapper) {
		this.userRepo = userRepo;
		this.patientRepo = patientRepo;
		this.messageRepo = messageRepo;
		this.messageMapper = messageMapper;
		this.patientMapper = patientMapper;
	}

	public Collection<ConversationDTO> execute(UserViewMessagesRequest request) {
		
		User user = userRepo.ofId(
				new UserId(request.requesterId));
		
		if (null == user) {
			throw new UserDoesNotExistException("User does not exist.");
		}
		
		Collection<Patient> patients = patientRepo.relatedWith(user.id());
				
		Collection<ConversationDTO> conversations = patients.stream().map(patient -> {
			Collection<MessageDTO> patientMessages = messageRepo.ofPatient(patient.id())
					.stream().map(messageMapper::toDTO).collect(toList());
			return new ConversationDTO(patientMapper.toDTO(patient), patientMessages);
		}).collect(toList());
		
		return conversations;
	}
}
