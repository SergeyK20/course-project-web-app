package service.serviceGenre;

import dao.GenreDAO;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetGenre implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GenreDAO genreDAO = new GenreDAO();
        request.setAttribute("genres", genreDAO.getAll());
        return "jsp/genre/genres.jsp";
    }
}
