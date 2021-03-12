package dao;

import entity.Actor;
import entity.Country;
import entity.Film;
import entity.Genre;

import java.util.Set;

public interface InterfaceGetSideElements {

    Set<Actor> getSideElementsByMainElement(Film main, Actor actor);

    Set<Genre> getSideElementsByMainElement(Film main, Genre genre);

    Set<Country> getSideElementsByMainElement(Film main, Country country);
}
