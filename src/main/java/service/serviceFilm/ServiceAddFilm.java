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
import java.util.HashSet;

/**
 * Добавление в БД нового фильма с его зависимостями(актерами, жанрамт, странами)
 */
public class ServiceAddFilm implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        Film film = buildFilmFromSingleElements(request);
        Long idFIlm = filmDAO.save(film);
        film.setIdFilm(idFIlm);

        SideElementsInFilmDAO sideElementsInFilmDAO = new SideElementsInFilmDAO();
        long[] actors = ServiceUtils.fromStringArrayInIntArray(request.getParameter("actor"));
        for(Long el: actors) {
            Actor actor = new Actor();
            actor.setIdActor(el);
            sideElementsInFilmDAO.add(film, actor);
        }

        long[] genres = ServiceUtils.fromStringArrayInIntArray(request.getParameter("genre"));
        for(Long el: genres) {
            Genre genre = new Genre();
            genre.setIdGenre(el);
            sideElementsInFilmDAO.add(film, genre);
        }

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
        film.setNameFilm(request.getParameter("nameFilm"));
        film.setReleaseDate(Date.valueOf(request.getParameter("releaseDate")));
        film.setRating(Integer.parseInt(request.getParameter("rating")));
        film.setCollection(Double.parseDouble(request.getParameter("collection")));
        return film;
    }
}
