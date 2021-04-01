package dao;

import entity.Country;
import entity.Film;
import entity.Genre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class FilmDAO implements DAO<Long, Film> {

    @Override
    public List<Film> getAll() throws Exception {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "FROM Film";
            return session.createQuery(query, Film.class).getResultList();
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Long save(Film film) throws Exception {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            return (Long) session.save(film);
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void update(Film film) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(film);
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Film film) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.createQuery("DELETE FROM Film WHERE idFilm =?1").
                    setParameter(1, film.getIdFilm()).executeUpdate();
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Film getById(Long id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Film film = session.createQuery("SELECT f FROM Film f WHERE idFilm = ?1", Film.class).
                    setParameter(1, id).getSingleResult();
            transaction.commit();
            return film;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.getMessage());
        }
    }

    public List<Film> findFilmsByGenre(Genre genre) throws Exception {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            List<Film> film = session.createQuery("SELECT f FROM Film f inner join f.genres g WHERE g.idGenre = ?1", Film.class).
                    setParameter(1, genre.getIdGenre()).getResultList();
            return film;
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Film> findFilmsByCountry(Country country) throws Exception {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            List<Film> film = session.createQuery("SELECT f FROM Film f inner join f.countries c WHERE c.idCountry = ?1", Film.class).
                    setParameter(1, country.getIdCountry()).getResultList();
            return film;
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Film> findFilmsByCountryAndGenre(Country country, Genre genre) throws Exception {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            List<Film> film = session.createQuery("SELECT f FROM Film f inner join f.countries c inner join f.genres g WHERE c.idCountry = ?1 and g.idGenre = ?2", Film.class).
                    setParameter(1, country.getIdCountry()).setParameter(2, genre.getIdGenre()).getResultList();
            return film;
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        }
    }
}
