package service.serviceFilm;

import dao.FilmDAO;
import entity.Film;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceDeleteFilm implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FilmDAO filmDAO = new FilmDAO();

        Film film = new Film();
        film.setIdFilm(Long.parseLong(request.getParameter("id")));
        filmDAO.delete(film);

        Service service = ServiceUtils.commandDefinition("GET_FILM", "GET_FILM");

        return service.execute(request, response);
    }
}
