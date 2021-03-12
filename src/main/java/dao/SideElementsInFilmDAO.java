package dao;

import entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class SideElementsInFilmDAO implements ManyToManyTableDAO<Film, InterfaceSideElement>, InterfaceGetSideElements {

    @Override
    public void add(Film film, InterfaceSideElement side) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            if (side instanceof Actor) {
                session.createNativeQuery("INSERT INTO actors_in_film VALUES (?1, ?2)").
                        setParameter(1, ((Actor) side).getIdActor()).
                        setParameter(2, film.getIdFilm()).
                        executeUpdate();
            } else {
                if (side instanceof Genre) {
                    session.createNativeQuery("INSERT INTO genres_in_film VALUES (?1, ?2)").
                            setParameter(1, ((Genre) side).getIdGenre()).
                            setParameter(2, film.getIdFilm()).
                            executeUpdate();
                } else {
                    session.createNativeQuery("INSERT INTO country_in_film VALUES (?1, ?2)").
                            setParameter(1, ((Country) side).getIdCountry()).
                            setParameter(2, film.getIdFilm()).
                            executeUpdate();
                }
            }

            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Film film, InterfaceSideElement side) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            if (side instanceof Actor) {
                session.createNativeQuery("DELETE FROM actors_in_film a WHERE a.id_actor =?1 and a.id_film =?2").
                        setParameter(1, ((Actor) side).getIdActor()).
                        setParameter(2, film.getIdFilm()).
                        executeUpdate();
            } else {
                if (side instanceof Genre) {
                    session.createNativeQuery("DELETE FROM genres_in_film a WHERE a.id_genre =?1 and a.id_film =?2").
                            setParameter(1, ((Genre) side).getIdGenre()).
                            setParameter(2, film.getIdFilm()).
                            executeUpdate();
                } else {
                    session.createNativeQuery("DELETE FROM country_in_film a WHERE a.id_country =?1 and a.id_film =?2").
                            setParameter(1, ((Country) side).getIdCountry()).
                            setParameter(2, film.getIdFilm()).
                            executeUpdate();
                }
            }

            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set<Film> getMainElementsBySideElement(InterfaceSideElement side) {
        return side.getFilms().isEmpty() || side.getFilms() == null ? null : side.getFilms();
    }


    @Override
    public Set<Actor> getSideElementsByMainElement(Film main, Actor actor) {
        return main.getActors().isEmpty() || main.getActors() == null ? null : main.getActors();
    }

    @Override
    public Set<Genre> getSideElementsByMainElement(Film main, Genre genre) {
        return main.getGenres().isEmpty() || main.getGenres() == null ? null : main.getGenres();
    }

    @Override
    public Set<Country> getSideElementsByMainElement(Film main, Country country) {
        return main.getCountries().isEmpty() || main.getCountries() == null ? null : main.getCountries();
    }
}
