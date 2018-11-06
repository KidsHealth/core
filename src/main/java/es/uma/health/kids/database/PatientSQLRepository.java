package es.uma.health.kids.database;

import es.uma.health.kids.database.specifications.SQLSpecification;
import es.uma.health.kids.database.specifications.Specification;
import es.uma.health.kids.domain.entities.Patient;
import es.uma.health.kids.domain.valueobjects.patient.PatientFullName;
import es.uma.health.kids.domain.valueobjects.patient.PatientHeight;
import es.uma.health.kids.domain.valueobjects.patient.PatientId;
import es.uma.health.kids.domain.valueobjects.patient.PatientWeight;
import es.uma.health.kids.domain.valueobjects.user.UserId;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientSQLRepository extends SQLRepository implements Repository<Patient> {

    public PatientSQLRepository(Connection connection) throws RepositoryException {
        super(connection);
    }

    @Override
    public void add(Patient item) {

    }

    @Override
    public void add(Iterable<Patient> items) {

    }

    @Override
    public void update(Patient item) {

    }

    @Override
    public void remove(Patient item) {

    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public List<Patient> query(Specification specification) throws RepositoryException {

        final SQLSpecification sqlSpecification = (SQLSpecification) specification;
        final List<Patient> patients = new ArrayList<>();

        try (
                PreparedStatement statement = connection.prepareStatement(sqlSpecification.toSQLQuery());
        ) {
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                patients.add(rowToPatient(rs));
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }

        return patients;
    }

    private Patient rowToPatient(ResultSet rs) throws RepositoryException {
        try {
            Integer heightVal = rs.getInt(PatientTable.Fields.HEIGHT);
            PatientHeight height = rs.wasNull() ? null : new PatientHeight(heightVal);

            Integer weightVal = rs.getInt(PatientTable.Fields.WIDTH);
            PatientWeight weight = rs.wasNull() ? null : new PatientWeight(weightVal);

            return new Patient(
                    new PatientId(rs.getInt(PatientTable.Fields.ID)),
                    new PatientFullName(
                            rs.getString(PatientTable.Fields.NAME),
                            rs.getString(PatientTable.Fields.SURNAME)),
                    height,
                    weight,
                    rs.getDate(PatientTable.Fields.BIRTHDATE),
                    new UserId(rs.getInt(PatientTable.Fields.PATIENTRESPONSIBLE_ID))
            );
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

}
