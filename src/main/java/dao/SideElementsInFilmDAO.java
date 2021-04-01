package dao;

import entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class SideElementsInFilmDAO implements ManyToManyTableDAO<Film, InterfaceSideElement>, InterfaceGetSideElements {

    /**
     * Добавление определенного побочного элемента
     * @param film в какой фильм будет добовляться побочный элемент
     * @param side какой побочный элемент добавляется
     * @throws Exception ошибка возникающая в результате работы с БД
     */
    @Override
    public void add(Film film, InterfaceSideElement side) throws Exception {
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
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Удаляются все побочные элементы заданого объекта side
     * @param film из какого фильма удаляются побоыне элементы
     * @param side какой побочный элемент удаляется
     * @throws Exception происходит в резульатте неудавшейся операции с БД
     */
    @Override
    public void remove(Film film, InterfaceSideElement side) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            if (side instanceof Actor) {
                session.createNativeQuery("DELETE FROM actors_in_film a WHERE a.id_film =?1").
                        setParameter(1,  film.getIdFilm()).
                        executeUpdate();
            } else {
                if (side instanceof Genre) {
                    session.createNativeQuery("DELETE FROM genres_in_film a WHERE a.id_film =?1").
                            setParameter(1,  film.getIdFilm()).
                            executeUpdate();
                } else {
                    session.createNativeQuery("DELETE FROM country_in_film a WHERE a.id_film =?1").
                            setParameter(1,  film.getIdFilm()).
                            executeUpdate();
                }
            }

            transaction.commit();
        } catch (HibernateException | NullPointerException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
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
