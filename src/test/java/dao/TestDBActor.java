package dao;

import entity.Actor;
import org.junit.Test;


public class TestDBActor {

    @Test
    public void getAllFilmsTest() throws Exception {
        ActorDAO actorDAO = new ActorDAO();
        System.out.println(actorDAO.getAll());
    }

    @Test
    public void getSaveActorTest() throws Exception {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setNameActor("Actor37");

        actorDAO.save(actor);
    }

    @Test
    public void updateActorTest() throws Exception {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setIdActor(10L);
        actor.setNameActor("Actor100");

        actorDAO.update(actor);
    }

    @Test
    public void deleteActorTest() throws Exception {
        ActorDAO actorDAO = new ActorDAO();

        Actor actor = new Actor();
        actor.setIdActor(37L);
        actor.setNameActor("Actor37");

        actorDAO.delete(actor);
    }
}
