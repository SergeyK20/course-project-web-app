package service.serviceFilm;

import dao.FilmDAO;
import dao.SideElementsInFilmDAO;
import entity.Actor;
import entity.Country;
import entity.Film;
import entity.Genre;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class ServiceEditFilm implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        Film film = buildFilmFromSingleElements(request);
        filmDAO.update(film);

        SideElementsInFilmDAO sideElementsInFilmDAO = new SideElementsInFilmDAO();
        sideElementsInFilmDAO.remove(film, new Actor());
        long[] actors = ServiceUtils.fromStringArrayInIntArray(request.getParameter("actor"));
        for(Long el: actors) {
            Actor actor = new Actor();
            actor.setIdActor(el);
            sideElementsInFilmDAO.add(film, actor);
        }

        sideElementsInFilmDAO.remove(film, new Genre());
        long[] genres = ServiceUtils.fromStringArrayInIntArray(request.getParameter("genre"));
        for(Long el: genres) {
            Genre genre = new Genre();
            genre.setIdGenre(el);
            sideElementsInFilmDAO.add(film, genre);
        }

        sideElementsInFilmDAO.remove(film, new Country());
        long[] countries = ServiceUtils.fromStringArrayInIntArray(request.getParameter("country"));
        for(Long el: countries) {
            Country country = new Country();
            country.setIdCountry(el);
            sideElementsInFilmDAO.add(film, country);
        }

        Service service = ServiceUtils.commandDefinition("GET_FILM", "GET_FILM");

        return service.execute(request, response);
    }

    private Film buildFilmFromSingleElements(HttpServletRequest request){
        Film film = new Film();
        film.setIdFilm(Long.parseLong(request.getParameter("id")));
        film.setNameFilm(request.getParameter("nameFilm"));
        film.setReleaseDate(Date.valueOf(request.getParameter("releaseDate")));
        film.setRating(Integer.parseInt(request.getParameter("rating")));
        film.setCollection(Double.parseDouble(request.getParameter("collection")));
        return film;
    }
}
