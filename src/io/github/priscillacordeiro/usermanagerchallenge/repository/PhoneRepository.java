package io.github.priscillacordeiro.usermanagerchallenge.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.github.priscillacordeiro.usermanagerchallenge.model.Phone;
import io.github.priscillacordeiro.usermanagerchallenge.model.User;
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

	public Phone update(Phone phone) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(phone);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return phone;
	}

	public Phone getById(Long id) {
		Transaction transaction = null;
		Phone phone = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
    		phone = session.get(Phone.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return phone;
	}

	public void delete(Long id) {
		Transaction transaction = null;
		
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            
            if (phone != null) {
                session.delete(phone);
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