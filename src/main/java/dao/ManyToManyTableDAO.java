package dao;

import java.util.List;
import java.util.Set;

public interface ManyToManyTableDAO<T, E> {

    void add(T to, E saveElement) throws Exception;

    void remove(T from, E removeElement) throws Exception;

    Set<T> getMainElementsBySideElement(E side);
}
