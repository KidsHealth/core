package es.uma.health.kids.application.dto.message;

public class AppointmentRequestDetails {

	public String updatedAt;
	public String status;
	public String datetimeProposed;
	
	public AppointmentRequestDetails(String updatedAt, String status, String datetimeProposed) {
		this.updatedAt = updatedAt;
		this.status = status;
		this.datetimeProposed = datetimeProposed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetimeProposed == null) ? 0 : datetimeProposed.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		AppointmentRequestDetails other = (AppointmentRequestDetails) obj;
		if (datetimeProposed == null) {
			if (other.datetimeProposed != null)
				return false;
		} else if (!datetimeProposed.equals(other.datetimeProposed))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}
	
}
