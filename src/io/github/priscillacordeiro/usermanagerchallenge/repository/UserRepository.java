package io.github.priscillacordeiro.usermanagerchallenge.repository;

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

}