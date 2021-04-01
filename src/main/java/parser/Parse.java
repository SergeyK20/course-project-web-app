package parser;

import java.util.Set;

public interface Parse <T, E> {

    E parse(T t) throws NullPointerException ;

    Set<E> parseCollection(Set<T> set) throws NullPointerException ;
}
