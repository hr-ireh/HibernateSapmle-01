package ir.hri.view;

import ir.hri.bl.Person;
import ir.hri.bl.impl.PersonImpl;
import ir.hri.exception.DaoException;
import ir.hri.to.PersonContactTO;
import ir.hri.to.PersonTO;

import java.util.ArrayList;
import java.util.List;

public class PersonView {

    public void newPerson() {
        Person person = new PersonImpl();
        List<PersonContactTO> personContactTOList = new ArrayList<PersonContactTO>();
        PersonContactTO personContactTO = new PersonContactTO("88860000", "09350000000", "Tehran");
        personContactTOList.add(personContactTO);
        PersonTO personTO = new PersonTO("Hamid Reza", "Ireh", personContactTOList);
        try {
            person.setPerson(personTO);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        person.sessionClose();
    }

    public void showPerson() {
        Person person = new PersonImpl();
        PersonTO personTO = null;
        try {
            personTO = person.getPerson(1);
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(personTO.getId());
        System.out.println(personTO.getFirstName());
        System.out.println(personTO.getLastName());
        for (PersonContactTO personContactTO : personTO.getPersonContactTO()) {
            System.out.println("   " + personContactTO.getRow());
            System.out.println("   " + personContactTO.getPhoneNumber());
            System.out.println("   " + personContactTO.getMobileNumber());
            System.out.println("   " + personContactTO.getAddress());
        }
        person.sessionClose();
    }

    public void addPersonContact() {
        Person person = new PersonImpl();
        PersonTO personTO = null;
        try {
            personTO = person.getPerson(1);
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }
        personTO.getPersonContactTO().add(new PersonContactTO("33850000", "0921000000", "Tehran"));
        try {
            person.setPerson(personTO);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        person.sessionClose();
    }

    public void showPersons() {
        Person person = new PersonImpl();
        List<PersonTO> personTOs = null;
        try {
            personTOs = person.getPersons();
        } catch (DaoException e) {
            e.printStackTrace();
            return;
        }

        for (PersonTO personTO : personTOs) {
            System.out.println(personTO.getId());
            System.out.println(personTO.getFirstName());
            System.out.println(personTO.getLastName());
            for (PersonContactTO personContactTO : personTO.getPersonContactTO()) {
                System.out.println("   " + personContactTO.getRow());
                System.out.println("   " + personContactTO.getPhoneNumber());
                System.out.println("   " + personContactTO.getMobileNumber());
                System.out.println("   " + personContactTO.getAddress());
            }
        }
        person.sessionClose();
    }
}
