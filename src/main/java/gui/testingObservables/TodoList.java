package gui.testingObservables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private List<TodoItem> todoItems;
    private PropertyChangeSupport changeSupport;

    public TodoList() {
        this.todoItems = new ArrayList<>();
        this.changeSupport = new PropertyChangeSupport(this);
    }

    PropertyChangeListener changeListener =
            evt -> changeSupport.firePropertyChange("todoItems", null, todoItems);

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
        todoItem.addChangeListener(changeListener);
        changeSupport.firePropertyChange("todoItems", null, todoItems);
    }

    public List<TodoItem> getTodoItems() {
        return Collections.unmodifiableList(todoItems);
    }

    public void addChangeListener(PropertyChangeListener changeListener) {
        changeSupport.addPropertyChangeListener(changeListener);
    }

    public void removeChangeListener(PropertyChangeListener changeListener) {
        changeSupport.removePropertyChangeListener(changeListener);
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
}
