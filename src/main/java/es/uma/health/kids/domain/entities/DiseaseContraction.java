package es.uma.health.kids.domain.entities;

import es.uma.health.kids.domain.valueobjects.disease.DiseaseId;
import es.uma.health.kids.domain.valueobjects.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.valueobjects.patient.PatientId;
import java.util.Date;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DiseaseContraction {

    private DiseaseContractionId id;
    private Date startedAt;
    private Date endedAt;
    private DiseaseId diseaseId;
    private PatientId patientId;

    public DiseaseContraction(
            DiseaseContractionId id, Date startedAt, Date endedAt,
            DiseaseId diseaseId, PatientId patientId) {
        this.id = id;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.diseaseId = diseaseId;
        this.patientId = patientId;
    }

    public DiseaseContraction(
            DiseaseContractionId id, Date startedAt,
            DiseaseId diseaseId, PatientId patientId) {
        this.id = id;
        this.startedAt = startedAt;
        this.diseaseId = diseaseId;
        this.patientId = patientId;
    }

    public DiseaseContractionId id() {
        return id;
    }

    public DiseaseContraction id(DiseaseContractionId id) {
        return new DiseaseContraction(id, startedAt, endedAt, diseaseId, patientId);
    }

    public Date startedAt() {
        return startedAt;
    }

    public DiseaseContraction startedAt(Date startedAt) {
        return new DiseaseContraction(id, startedAt, endedAt, diseaseId, patientId);
    }

    public Date endedAt() {
        return endedAt;
    }

    public DiseaseContraction endedAt(Date endedAt) {
        return new DiseaseContraction(id, startedAt, endedAt, diseaseId, patientId);
    }

    public DiseaseId diseaseId() {
        return diseaseId;
    }

    public DiseaseContraction diseaseId(DiseaseId diseaseId) {
        return new DiseaseContraction(id, startedAt, endedAt, diseaseId, patientId);
    }

    public PatientId patientId() {
        return patientId;
    }

    public DiseaseContraction patientId(PatientId patientId) {
        return new DiseaseContraction(id, startedAt, endedAt, diseaseId, patientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiseaseContraction that = (DiseaseContraction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startedAt, that.startedAt) &&
                Objects.equals(endedAt, that.endedAt) &&
                Objects.equals(diseaseId, that.diseaseId) &&
                Objects.equals(patientId, that.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startedAt, endedAt, diseaseId, patientId);
    }
}
