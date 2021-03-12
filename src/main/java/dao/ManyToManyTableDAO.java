package dao;

import java.util.List;
import java.util.Set;

public interface ManyToManyTableDAO<T, E> {

    void add(T to, E saveElement);

    void remove(T from, E removeElement);

    Set<T> getMainElementsBySideElement(E side);
}
