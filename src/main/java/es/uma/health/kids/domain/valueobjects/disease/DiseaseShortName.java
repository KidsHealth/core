package es.uma.health.kids.domain.valueobjects.disease;

import es.uma.health.kids.domain.FieldTooLongException;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class DiseaseShortName extends DiseaseName {

    protected static final int MAXIMUM_LENGTH = 255;

    public DiseaseShortName(String stringName) {
        super(stringName);
    }

    private void checkNameLength(String stringName) {
        if(stringName.length() > MAXIMUM_LENGTH) {
            throw new FieldTooLongException(
                    String.format("Disease short name '%s' is longer than the maximum length constraint %d.", stringName, MAXIMUM_LENGTH));
        }
    }

}
