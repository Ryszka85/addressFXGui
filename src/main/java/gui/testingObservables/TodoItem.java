package gui.testingObservables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TodoItem {
    private String description;
    private PropertyChangeSupport changeSupport;
    public TodoItem() {
        this.changeSupport = new PropertyChangeSupport(this);
    }

    public TodoItem(String description) {
        this.description = description;
        this.changeSupport = new PropertyChangeSupport(this);
    }

    public void addChangeListener(PropertyChangeListener changeListener) {
        changeSupport.addPropertyChangeListener(changeListener);
    }

    public void removeChangeListener(PropertyChangeListener changeListener) {
        changeSupport.removePropertyChangeListener(changeListener);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldVal = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldVal, description);
    }

    @Override
    public String toString() {
        return description;
    }
}
