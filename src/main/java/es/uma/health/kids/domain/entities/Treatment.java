package es.uma.health.kids.domain.entities;


import es.uma.health.kids.domain.valueobjects.diseasecontraction.DiseaseContractionId;
import es.uma.health.kids.domain.valueobjects.medicine.MedicineId;
import es.uma.health.kids.domain.valueobjects.treatment.*;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class Treatment {

    private TreatmentId id;
    private TreatmentPosology posology;
    private TreatmentTiming timing;
    private DiseaseContractionId diseaseContractionId;
    private MedicineId medicineId;

    public Treatment(TreatmentId id,
            TreatmentPosology posology,
            TreatmentTiming timing,
            DiseaseContractionId diseaseContractionId,
            MedicineId medicineId) {
        this.id = id;
        this.posology = posology;
        this.timing = timing;
        this.diseaseContractionId = diseaseContractionId;
        this.medicineId = medicineId;
    }

    public DiseaseContractionId diseaseContractionId() {
        return diseaseContractionId;
    }

    public Treatment diseaseContractionId(
            DiseaseContractionId diseaseContractionId) {
        return new Treatment(id, posology, timing, diseaseContractionId, medicineId);
    }

    public MedicineId medicineId() {
        return medicineId;
    }

    public Treatment medicineId(MedicineId medicineId) {
        return new Treatment(id, posology, timing, diseaseContractionId, medicineId);
    }

    public TreatmentId id() {
        return id;
    }

    public Treatment id(TreatmentId id) {
        return new Treatment(id, posology, timing, diseaseContractionId, medicineId);
    }

    public TreatmentPosology posology() {
        return posology;
    }

    public Treatment posology(TreatmentPosology posology) {
        return new Treatment(id, posology, timing, diseaseContractionId, medicineId);
    }

    public TreatmentTiming timing() {
        return timing;
    }

    public Treatment timing(TreatmentTiming timing) {
        return new Treatment(id, posology, timing, diseaseContractionId, medicineId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Treatment treatment = (Treatment) o;
        return Objects.equals(id, treatment.id) &&
                Objects.equals(posology, treatment.posology) &&
                Objects.equals(timing, treatment.timing) &&
                Objects.equals(diseaseContractionId, treatment.diseaseContractionId) &&
                Objects.equals(medicineId, treatment.medicineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, posology, timing, diseaseContractionId, medicineId);
    }
}
