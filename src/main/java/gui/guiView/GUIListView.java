package gui.guiView;

import datamodel.Person;
import gui.guiModell.GUIDataListModel;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.beans.PropertyChangeListener;


public class GUIListView<T> {
    private ListView<T> listView;
    public GUIDataListModel<T> guiDataListModel;
    private PropertyChangeListener changeListener = evt -> refreshListView();
    public static int selectedIndex;


    public GUIListView(ListView<T> listView, GUIDataListModel<T> guiDataListModel) {
        this.listView = listView;
        this.guiDataListModel = guiDataListModel;
        this.guiDataListModel.addListener(changeListener);
        refreshListView();
    }

    public void addSelectedItemListener(ChangeListener<T> changeListener) {
        this.listView.getSelectionModel()
                .selectedItemProperty()
                .addListener(changeListener);
    }

    public void removeSelectedItemListener(ChangeListener<T> changeListener) {
        this.listView.getSelectionModel()
                .selectedItemProperty()
                .removeListener(changeListener);
    }

    public void refreshListView() {
        this.listView.getItems()
                .setAll(guiDataListModel.getObservableDataList());
    }

    public void addToListView(T t) {
        guiDataListModel.addToDataModel(t);
    }

    public void selectLastItem() {
        this.listView.getSelectionModel().selectLast();
        this.listView.scrollTo(this.listView.getItems().size() - 1);
    }

    public T getSelectedItem() {
        return this.listView.getSelectionModel().getSelectedItem();
    }

    public void selectItem(final int selectedIndex) {
        this.listView.getSelectionModel().select(selectedIndex);
    }

    public int getSelectedIndex() {
        return this.listView.getSelectionModel()
                .getSelectedIndex();
    }


    public ListView<T> getListView() {
        return listView;
    }

    public void setCellValue(Callback<ListView<T>, ListCell<T>> p) {
        this.listView.setCellFactory(p);
    }
}
