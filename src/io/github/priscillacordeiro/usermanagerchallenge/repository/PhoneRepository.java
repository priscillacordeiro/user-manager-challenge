package io.github.priscillacordeiro.usermanagerchallenge.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.github.priscillacordeiro.usermanagerchallenge.model.Phone;
import io.github.priscillacordeiro.usermanagerchallenge.util.HibernateUtil;

public class PhoneRepository {

	public Phone create(Phone phone) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return phone;
	}

}
