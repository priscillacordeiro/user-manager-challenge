package io.github.priscillacordeiro.usermanagerchallenge.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.util.HibernateUtil;

public class UserRepository {
	
	public User create(User user) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
	}

	public List<User> getAll() {
		Transaction transaction = null;
		List<User> userList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            userList = session.createQuery("from User order by id").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return userList;
	}
	
	public User getById(Long id) {
		Transaction transaction = null;
		User user = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
    		user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
	}
	
	public User getByEmail(String email) {
		User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    		user = (User) session.createQuery("from User where email = :email").setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
	}

	public User update(User user) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
	}
	
	public void delete(Long id) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            
            if (user != null) {
                session.delete(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}