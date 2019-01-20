package es.uma.health.kids.infrastructure.persistence.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import es.uma.health.kids.domain.model.user.Email;
import es.uma.health.kids.domain.model.user.PatientResponsible;
import es.uma.health.kids.domain.model.user.PatientResponsibleId;
import es.uma.health.kids.domain.model.user.PatientResponsibleRepository;
import es.uma.health.kids.domain.model.user.UserId;

public class InMemoryPatientResponsibleRepository implements PatientResponsibleRepository {

	public Map<PatientResponsibleId, PatientResponsible> responsibles;
	
	public InMemoryPatientResponsibleRepository() {
		responsibles = new HashMap<>();
	}

	@Override
	public UserId nextIdentity() {
		return new UserId(responsibles.size() + 1);
	}

	@Override
	public void add(PatientResponsible aResponsible) {
		responsibles.put(aResponsible.id(), aResponsible);
	}

	@Override
	public void update(PatientResponsible aResponsible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PatientResponsible aResponsible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PatientResponsible> all() {
		return new ArrayList<>(responsibles.values());
	}

	@Override
	public PatientResponsible ofEmail(Email anEmail) {
		return all().stream().filter(r -> r.email().equals(anEmail)).findFirst().get();
	}

	@Override
	public PatientResponsible ofId(UserId anId) {
		return responsibles.get(anId);
	}

}
