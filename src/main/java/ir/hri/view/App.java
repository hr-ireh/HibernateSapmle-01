package ir.hri.view;

import ir.hri.exception.DaoException;

public class App {
    public static void main(String[] args) throws DaoException {
        PersonView personView = new PersonView();
        //personView.showPerson();
        //personView.newPerson();
        //personView.addPersonContact();
        personView.showPersons();
    }
}