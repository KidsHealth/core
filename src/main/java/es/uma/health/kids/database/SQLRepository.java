package es.uma.health.kids.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Miguel González <sosa@uma.es>
 **/
abstract class SQLRepository {

    protected final Connection connection;

    public SQLRepository(Connection connection) throws RepositoryException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        this.connection = connection;
    }

}
