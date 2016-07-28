package ir.hri.bl;

import ir.hri.exception.DaoException;
import ir.hri.to.PersonTO;

import java.util.List;

public interface Person {
    public void setPerson(PersonTO person) throws DaoException;

    public PersonTO getPerson(int id) throws DaoException;

    public List<PersonTO> getPersons() throws DaoException;

    public void sessionClose();
}
