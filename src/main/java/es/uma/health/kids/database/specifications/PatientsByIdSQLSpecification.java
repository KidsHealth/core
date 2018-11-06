package es.uma.health.kids.database.specifications;

import es.uma.health.kids.database.PatientTable;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientsByIdSQLSpecification implements SQLSpecification {

    private final int id;

    public PatientsByIdSQLSpecification(int id) {
        this.id = id;
    }

    @Override
    public String toSQLQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = %3$d';",
                PatientTable.TABLE_NAME,
                PatientTable.Fields.ID,
                id
        );
    }
}
