package es.uma.health.kids.util;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public interface Mapper<From, To> {
    To map(From from);
}
