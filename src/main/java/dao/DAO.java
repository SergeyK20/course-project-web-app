package dao;

import java.util.List;

public interface DAO<T, E> {

    List<E> getAll() throws Exception;

    T save(E e) throws Exception;

    void update(E e) throws Exception;

    void delete(E e) throws Exception;

    E getById(T t) throws Exception;
}
