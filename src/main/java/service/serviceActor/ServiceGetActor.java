package service.serviceActor;

import dao.ActorDAO;
import service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetActor implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActorDAO actorDAO = new ActorDAO();
        request.setAttribute("actors", actorDAO.getAll());
        return "jsp/actor/actors.jsp";
    }
}
