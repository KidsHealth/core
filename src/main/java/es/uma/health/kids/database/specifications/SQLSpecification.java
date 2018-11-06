package es.uma.health.kids.database.specifications;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public interface SQLSpecification extends Specification {
    String toSQLQuery();
}
