package service.serviceGenre;

import dao.GenreDAO;
import entity.Genre;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceDeleteGenre implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GenreDAO genreDAO = new GenreDAO();

        Genre genre = new Genre();
        genre.setIdGenre(Long.parseLong(request.getParameter("id")));

        genreDAO.delete(genre);

        Service service = ServiceUtils.commandDefinition("GET_GENRE", "GET_GENRE");

        return service.execute(request, response);
    }
}
