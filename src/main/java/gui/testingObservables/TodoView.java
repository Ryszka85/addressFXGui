package gui.testingObservables;

import javafx.scene.control.TextField;

import java.beans.PropertyChangeListener;

public class TodoView {
    private TextField textField;
    private TodoItem model;
    private PropertyChangeListener changeListener = evt -> updateFields();

    public void updateFields() {
        if (!textField.getText().equals(model.getDescription()) || textField.getText() != null)
            textField.setText(model.getDescription());
    }

    public TodoView(TextField textField) {
        this.textField = textField;
        this.textField.textProperty()
                .addListener((observableValue, s, t1) -> {
                    if (textField.getText() != null)
                        model.setDescription(textField.getText());
                });

    }

    public void setModel(TodoItem model) {
        if (this.model != null)
            this.model.removeChangeListener(changeListener);
        this.model = model;
        if (this.model != null) {
            this.model.addChangeListener(changeListener);
            if (this.model.getDescription() != null) {
                textField.setText(this.model.getDescription());
                updateFields();
            }
        }
    }
}
