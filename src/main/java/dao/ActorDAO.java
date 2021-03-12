package dao;

import entity.Actor;
import entity.Genre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class ActorDAO implements DAO<Long, Actor> {

    @Override
    public List<Actor> getAll() {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "FROM Actor";
            return session.createQuery(query, Actor.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Actor actor) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.save(actor);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(actor);
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Actor actor) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.createQuery("DELETE FROM Actor WHERE idActor =?1").
                    setParameter(1, actor.getIdActor()).executeUpdate();
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Actor getById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Actor actor = session.createQuery("SELECT a FROM Actor a WHERE idActor = ?1", Actor.class).
                    setParameter(1, id).getSingleResult();
            transaction.commit();
            return actor;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }
}
