package service.serviceFilm;

import dao.CountryDAO;
import dao.FilmDAO;
import dao.GenreDAO;
import entity.Country;
import entity.Genre;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetFilteredFIlm implements Service {


    private void addAllGenre(HttpServletRequest request) throws Exception {
        GenreDAO genreDAO = new GenreDAO();
        request.setAttribute("genres", genreDAO.getAll());
    }

    private void addAllCountry(HttpServletRequest request) throws Exception {
        CountryDAO countryDAO = new CountryDAO();
        request.setAttribute("countries", countryDAO.getAll());
    }

    private void addAllFilms(HttpServletRequest request) throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        if (request.getParameter("countryFilter").equals("") && request.getParameter("genreFilter").equals("")) {
            request.setAttribute("films", filmDAO.getAll());
        } else if (request.getParameter("countryFilter").equals("")) {
            Genre genre = new Genre();
            genre.setIdGenre(Long.parseLong(request.getParameter("genreFilter")));
            request.setAttribute("films", filmDAO.findFilmsByGenre(genre));
        } else if (request.getParameter("genreFilter").equals("")){
            Country country = new Country();
            country.setIdCountry(Long.parseLong(request.getParameter("countryFilter")));
            request.setAttribute("films", filmDAO.findFilmsByCountry(country));
        } else {
            Genre genre = new Genre();
            Country country = new Country();
            country.setIdCountry(Long.parseLong(request.getParameter("countryFilter")));
            genre.setIdGenre(Long.parseLong(request.getParameter("genreFilter")));
            request.setAttribute("films", filmDAO.findFilmsByCountryAndGenre(country, genre));
        }
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        addAllFilms(request);
        addAllGenre(request);
        addAllCountry(request);

        return "jsp/film/films.jsp";
    }
}
