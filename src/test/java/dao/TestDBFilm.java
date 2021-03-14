package dao;

import dao.FilmDAO;
import entity.Film;
import org.junit.Test;

import java.sql.Date;


public class TestDBFilm {

    @Test
    public void getAllFilmsTest() {
        FilmDAO filmDAO = new FilmDAO();
        System.out.println(filmDAO.getAll());
    }

    @Test
    public void getSaveFilmTest() {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setNameFilm("Film6");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(5);
        film.setCollection(2500.3);

        filmDAO.save(film);
    }

    @Test
    public void updateFilmTest() {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setIdFilm(5);
        film.setNameFilm("Film7");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(8);
        film.setCollection(12500.3);

        filmDAO.update(film);
    }

    @Test
    public void deleteFilmTest() {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setIdFilm(36);
        film.setNameFilm("Film6");
        film.setReleaseDate(new Date(new java.util.Date().getTime()));
        film.setRating(5);
        film.setCollection(2500.3);

        filmDAO.delete(film);
    }

}
