package dao;

import entity.Actor;
import entity.Film;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class FilmDAO implements DAO<Long, Film> {

    @Override
    public List<Film> getAll() {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "FROM Film";
            return session.createQuery(query, Film.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Film film) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.save(film);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Film film) {
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Film film) {
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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Film getById(Long id) {
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
            System.out.println(e.getMessage());
            return null;
        }
    }
}
