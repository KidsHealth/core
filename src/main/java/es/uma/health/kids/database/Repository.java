package es.uma.health.kids.database;

import es.uma.health.kids.database.specifications.Specification;
import java.util.List;

/**
 * @author Miguel González <sosa@uma.es>
 **/
interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    void remove(Specification specification);

    List<T> query(Specification specification) throws RepositoryException;

}