package gui.guiView.guiViewUtil;

import datamodel.Person;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class PersonListCell implements Callback<ListView<Person>, ListCell<Person>> {
    @Override
    public ListCell<Person> call(ListView<Person> personListView) {
        return new ListCell<>() {
            @Override
            protected void updateItem(Person person, boolean b) {
                super.updateItem(person, b);
                final boolean isNull = b || person == null ||
                        person.getFirst_name() == null || person.getLast_name() == null;
                setText(isNull ? null : person.getFirst_name() + " " + person.getLast_name());
            }
        };
    }
}
