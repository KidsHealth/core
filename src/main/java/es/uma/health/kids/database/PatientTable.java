package es.uma.health.kids.database;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientTable {

    public static final String TABLE_NAME = "Patient";

    public static final class Fields {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String HEIGHT = "height";
        public static final String WIDTH = "weight";
        public static final String BIRTHDATE = "birthdate";
        public static final String PATIENTRESPONSIBLE_ID = "PatientResponsible_User_id";
    }

}
