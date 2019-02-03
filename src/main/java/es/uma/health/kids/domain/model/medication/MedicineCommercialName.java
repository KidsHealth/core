package es.uma.health.kids.domain.model.medication;

import java.util.Objects;

public class MedicineCommercialName {

    private String commercialNameString;

    public MedicineCommercialName(String commercialNameString) {
        this.commercialNameString = commercialNameString;
    }
    
    public String value() {
    	return commercialNameString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MedicineCommercialName that = (MedicineCommercialName) o;
        return Objects.equals(commercialNameString, that.commercialNameString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commercialNameString);
    }
}
