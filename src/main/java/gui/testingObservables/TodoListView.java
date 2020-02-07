package gui.testingObservables;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.beans.PropertyChangeListener;

public class TodoListView {
    public ListView<TodoItem> itemListView;
    private TodoList model;
    private PropertyChangeListener changeListener = evt -> {
        itemListView.setItems(FXCollections.observableArrayList(this.model.getTodoItems()));
    };
    private TodoView todoView;
    private Button addButton;

    public TodoListView(ListView<TodoItem> itemListView,
                        TodoView todoView,
                        Button addButton) {
        this.itemListView = itemListView;
        this.todoView = todoView;
        this.addButton = addButton;

        this.itemListView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observableValue, todoItem, t1) -> {
                    if (t1 != null) {
                        final TodoItem selectedTodoItem = getSelectedTodoItem(t1);
                        todoView.setModel(selectedTodoItem);
                    }
                });


        this.addButton.setOnAction(actionEvent -> {
            TodoItem todoItem = new TodoItem("New item");
            this.model.addTodoItem(todoItem);
            this.itemListView.getSelectionModel().selectLast();
            todoView.setModel(todoItem);
        });
    }

    private TodoItem getSelectedTodoItem(TodoItem t1) {
        final int selectedTodoIndex = model.getTodoItems()
                .indexOf(t1);
        return model
                .getTodoItems()
                .get(selectedTodoIndex);
    }

    private void refreshListView() {
        itemListView.setItems(FXCollections.observableArrayList(this.model.getTodoItems()));
    }

    public void setModel(TodoList model) {
        if (this.model != null)
            model.removeChangeListener(changeListener);
        this.model = model;
        if (this.model != null) {
            model.addChangeListener(changeListener);
            refreshListView();
        }

    }

}
