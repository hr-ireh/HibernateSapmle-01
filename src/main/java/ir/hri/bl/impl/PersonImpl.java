package ir.hri.bl.impl;

import ir.hri.bl.Person;
import ir.hri.exception.DaoException;
import ir.hri.util.HibernateUtil;
import ir.hri.to.PersonTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonImpl implements Person {
    Session session;

    {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void setPerson(PersonTO personTO) throws DaoException {
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(personTO);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
    }

    public PersonTO getPerson(int id) throws DaoException {
        Transaction transaction = session.beginTransaction();
        PersonTO personTO;

        try {
            personTO = (PersonTO) session.load(PersonTO.class, new Integer(id));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
        return personTO;
    }

    public List<PersonTO> getPersons() throws DaoException {
        Transaction transaction = session.beginTransaction();
        List<PersonTO> personTOs;

        try {
            personTOs = session.createQuery("FROM ir.hri.to.PersonTO").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                try {
                    transaction.rollback();
                } catch (HibernateException e1) {
                    throw new DaoException("Fetal exception in " + e1.getMessage());
                }
            throw new DaoException("Fetal to retrieve " + e.getMessage());
        }
        return personTOs;
    }

    public void sessionClose() {
        session.close();
    }
}
