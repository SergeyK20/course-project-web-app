package service.serviceFilm;

import dao.ActorDAO;
import dao.CountryDAO;
import dao.FilmDAO;
import dao.GenreDAO;
import org.postgresql.jdbc.PreferQueryMode;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Класс обеспечивающий передачу в атрибутах всех фильмов
 */
public class ServiceGetFilm implements Service {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        request.setAttribute("films", filmDAO.getAll());
        addAllGenre(request);
        addAllCountry(request);

        return "jsp/film/films.jsp";
    }

    private void addAllGenre(HttpServletRequest request) throws Exception {
        GenreDAO genreDAO = new GenreDAO();
        request.setAttribute("genres", genreDAO.getAll());
    }

    private void addAllCountry(HttpServletRequest request) throws Exception {
        CountryDAO countryDAO = new CountryDAO();
        request.setAttribute("countries", countryDAO.getAll());
    }
}
