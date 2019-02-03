package es.uma.health.kids.domain.model.diseasecontraction;

import es.uma.health.kids.domain.model.shared.ResourceDoesNotExistException;

public class DiseaseContractionDoesNotExistException extends ResourceDoesNotExistException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiseaseContractionDoesNotExistException() {
		super();
	}

	public DiseaseContractionDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DiseaseContractionDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public DiseaseContractionDoesNotExistException(String message) {
		super(message);
	}

	public DiseaseContractionDoesNotExistException(Throwable cause) {
		super(cause);
	}

}
