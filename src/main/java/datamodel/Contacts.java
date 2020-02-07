package datamodel;

import databaseUtil.DAOModel.PersonDAO;
import databaseUtil.session.DbSession;
import validation.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contacts {
    private List<Person> contactList;

    public Contacts() {
        this.contactList = new ArrayList<>();
    }

    public void addToContacts(Person person) {
        try {
            Validator.objectNotNull(person);
            contactList.add(person);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void setContactList(List<Person> contactList) {
        this.contactList = contactList;
    }

    public List<Person> getContactList() {
        return Collections.unmodifiableList(contactList);
    }
}
