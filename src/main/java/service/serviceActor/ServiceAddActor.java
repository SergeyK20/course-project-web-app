package service.serviceActor;

import dao.ActorDAO;
import entity.Actor;
import service.Service;
import service.ServiceUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceAddActor implements Service {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setNameActor(request.getParameter("nameActor"));

        actorDAO.save(actor);

        Service service = ServiceUtils.commandDefinition("GET_ACTOR", "GET_ACTOR");

        return service.execute(request, response);
    }
}
