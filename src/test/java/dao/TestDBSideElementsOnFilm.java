package dao;

import dao.ActorDAO;
import dao.FilmDAO;
import dao.HibernateUntil;
import dao.SideElementsInFilmDAO;
import entity.Actor;
import entity.Film;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

public class TestDBSideElementsOnFilm {
    @Test
    public void getAllSidesInFilm() {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "SELECT f FROM Film f WHERE idFilm = ?1";
            Film film = session.createQuery(query, Film.class).setParameter(1, 2L).getSingleResult();
            System.out.println(film);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deleteSideInFilm() throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        SideElementsInFilmDAO sideElementsInFilmDAO = new SideElementsInFilmDAO();

        Film film = filmDAO.getById(2L);
        Actor actor = actorDAO.getById(15L);
        System.out.println(film.getActors().size());
        sideElementsInFilmDAO.remove(film, actor);
        System.out.println(film.getActors().size());
    }

    //соххраняется только со стороны фильма
    @Test
    public void saveSideInFilm() throws Exception {
        FilmDAO filmDAO = new FilmDAO();
        ActorDAO actorDAO = new ActorDAO();
        SideElementsInFilmDAO sideElementsInFilmDAO = new SideElementsInFilmDAO();

        Film film = filmDAO.getById(2L);
        Actor actor = actorDAO.getById(15L);
        System.out.println(film.getActors().size());
        sideElementsInFilmDAO.add(film, actor);
        //film.addActor(actor);
        System.out.println(filmDAO.getById(2L).getActors().size());
    }
}
