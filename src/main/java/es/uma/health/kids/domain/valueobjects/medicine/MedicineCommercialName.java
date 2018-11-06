package es.uma.health.kids.domain.valueobjects.medicine;

import es.uma.health.kids.domain.FieldTooLongException;
import java.util.Objects;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class MedicineCommercialName {

    private static final int MAXIMUM_LENGTH = 255;
    private String commercialNameString;

    public MedicineCommercialName(String commercialNameString) {
        checkCommercialNameLength(commercialNameString);
        this.commercialNameString = commercialNameString;
    }

    private void checkCommercialNameLength(String commercialNameString) {
        if(commercialNameString.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(String.format(
                    "Medicine commercial name '%s' is longer than the maximum length constraint %d.",
                    commercialNameString, MAXIMUM_LENGTH));
        }
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
