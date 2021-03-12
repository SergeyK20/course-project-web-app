package dao;

import java.util.List;

public interface DAO<T, E> {

    List<E> getAll();

    void save(E e);

    void update(E e);

    void delete(E e);

    E getById(T t);
}
