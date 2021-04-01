package service.serviceActor;

import dao.ActorDAO;
import entity.Actor;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceEditActor implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setIdActor(Long.parseLong(request.getParameter("id")));
        actor.setNameActor(request.getParameter("nameActor"));

        actorDAO.update(actor);

        Service service = ServiceUtils.commandDefinition("GET_ACTOR", "GET_ACTOR");

        return service.execute(request, response);
    }
}
