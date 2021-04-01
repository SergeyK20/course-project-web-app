package service.serviceFilm;

import dao.ActorDAO;
import dao.CountryDAO;
import dao.FilmDAO;
import dao.GenreDAO;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceBeforeAddFilm implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        GenreDAO genreDAO = new GenreDAO();
        CountryDAO countryDAO = new CountryDAO();
        request.setAttribute("films", filmDAO.getAll());
        request.setAttribute("actors", actorDAO.getAll());
        request.setAttribute("genres", genreDAO.getAll());
        request.setAttribute("countries", countryDAO.getAll());
        return "jsp/film/addFilm.jsp";
    }
}
