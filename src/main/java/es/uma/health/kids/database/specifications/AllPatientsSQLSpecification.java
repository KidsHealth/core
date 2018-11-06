package es.uma.health.kids.database.specifications;

import es.uma.health.kids.database.PatientTable;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class AllPatientsSQLSpecification implements SQLSpecification {

    @Override
    public String toSQLQuery() {
        return String.format(
                "SELECT * FROM %1$s;",
                PatientTable.TABLE_NAME
        );
    }
}
