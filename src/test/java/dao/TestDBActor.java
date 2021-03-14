package dao;

import dao.ActorDAO;
import entity.Actor;
import org.junit.Test;


public class TestDBActor {

    @Test
    public void getAllFilmsTest() {

        ActorDAO actorDAO = new ActorDAO();
        System.out.println(actorDAO.getAll());
    }

    @Test
    public void getSaveActorTest() {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setNameActor("Actor37");

        actorDAO.save(actor);
    }

    @Test
    public void updateActorTest() {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setIdActor(10);
        actor.setNameActor("Actor100");

        actorDAO.update(actor);
    }

    @Test
    public void deleteActorTest() {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setIdActor(37);
        actor.setNameActor("Actor37");

        actorDAO.delete(actor);
    }
}
