package es.uma.health.kids.database;

import static org.junit.Assert.*;

import com.thoughtworks.xstream.XStream;
import es.uma.health.kids.database.specifications.AllPatientsSQLSpecification;
import es.uma.health.kids.domain.entities.Patient;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class PatientSQLRepositoryTest {

    @Test
    public void query() throws SQLException, RepositoryException {

        Connection mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kidshealth", "root", "");

        PatientSQLRepository repo = new PatientSQLRepository(mysqlConnection);

        List<Patient> patients = repo.query(new AllPatientsSQLSpecification());

        System.out.println(patients);

    }
}