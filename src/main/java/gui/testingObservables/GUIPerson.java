package gui.testingObservables;

import datamodel.Person;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GUIPerson {
    private Person person;
    private PropertyChangeSupport propertyChangeSupport;

    public GUIPerson(Person person) {
        this.person = person;
        this.propertyChangeSupport = new PropertyChangeSupport(person);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public void setFirstName(String firstName) {
        String old = person.getFirst_name();
        person.setFirst_name(firstName);
        propertyChangeSupport.firePropertyChange("first_name", old, person.getFirst_name());
    }
}
