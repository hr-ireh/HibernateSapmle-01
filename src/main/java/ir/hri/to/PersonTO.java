package ir.hri.to;

import java.util.List;

public class PersonTO {
    int id;
    String firstName;
    String lastName;
    List<PersonContactTO> personContactTO;

    public PersonTO() {
    }

    public PersonTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonTO(String firstName, String lastName, List<PersonContactTO> personContactTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personContactTO = personContactTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PersonContactTO> getPersonContactTO() {
        return personContactTO;
    }

    public void setPersonContactTO(List<PersonContactTO> personContactTO) {
        this.personContactTO = personContactTO;
    }

    @Override
    public String toString() {
        return "PersonTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personContactTO=" + personContactTO +
                '}';
    }
}
