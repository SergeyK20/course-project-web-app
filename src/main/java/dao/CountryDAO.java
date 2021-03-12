package dao;

import entity.Country;
import entity.Genre;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.List;

public class CountryDAO implements DAO<Long, Country> {
    @Override
    public List<Country> getAll() {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            String query = "FROM Country";
            return session.createQuery(query, Country.class).getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void save(Country country) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.save(country);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Country country) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.update(country);
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Country country) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.createQuery("DELETE FROM Country WHERE idCountry =?1").
                    setParameter(1, country.getIdCountry()).executeUpdate();
            transaction.commit();
        } catch (HibernateException | OptimisticLockException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Country getById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            Country country = session.createQuery("SELECT c FROM Country c WHERE idCountry = ?1", Country.class).
                    setParameter(1, id).getSingleResult();
            transaction.commit();
            return country;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }
    }
}
