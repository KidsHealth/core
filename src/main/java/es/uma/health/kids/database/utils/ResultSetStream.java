package es.uma.health.kids.database.utils;

import java.lang.reflect.Proxy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Miguel González <sosa@uma.es>
 **/
public class ResultSetStream<T> {

    @SuppressWarnings("unchecked")
    public Stream<T> getStream(PreparedStatement st,
            Function<ResultSet, T> mappingFunction) throws SQLException {
        final ResultSetStreamInvocationHandler<T> handler =
                new ResultSetStreamInvocationHandler<T>();
        handler.setup(st, mappingFunction);
        return (Stream<T>) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class<?>[] {Stream.class},
                handler);
    }
}
