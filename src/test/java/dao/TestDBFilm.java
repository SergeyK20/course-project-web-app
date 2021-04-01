package dao;

import entity.Film;
import org.junit.Test;

import java.sql.Date;
import java.util.List;


public class TestDBFilm {

    @Test
    public void getAllFilmsTest() throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        List<Film> films = filmDAO.getAll();
        System.out.println(films);
    }

    @Test
    public void getSaveFilmTest() throws Exception {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setNameFilm("Film6");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(5);
        film.setCollection(2500.3);

        filmDAO.save(film);
    }

    @Test
    public void updateFilmTest() throws Exception {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setIdFilm(5L);
        film.setNameFilm("Film7");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(8);
        film.setCollection(12500.3);

        filmDAO.update(film);
    }

    @Test
    public void deleteFilmTest() throws Exception {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setIdFilm(36L);
        film.setNameFilm("Film6");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(5);
        film.setCollection(2500.3);

        filmDAO.delete(film);
    }

}
