package dao;

import entity.Film;
import entity.Genre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class GenreDAO implements DAO<Long, Genre> {
    @Override
    public List<Genre> getAll() {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "FROM Genre";
            return session.createQuery(query, Genre.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Genre genre) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.save(genre);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Genre genre) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(genre);
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Genre genre) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.createQuery("DELETE FROM Genre WHERE idGenre =?1").
                    setParameter(1, genre.getIdGenre()).executeUpdate();
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Genre getById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Genre genre = session.createQuery("SELECT g FROM Genre g WHERE idGenre = ?1", Genre.class).
                    setParameter(1, id).getSingleResult();
            transaction.commit();
            return genre;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }
}
