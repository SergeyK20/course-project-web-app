package controllers;

import java.util.List;
import java.util.Set;

public interface Controller <E> {

    List<E> getAllFilms() throws Exception;
}
