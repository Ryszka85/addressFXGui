package gui.guiView;

import gui.guiModell.GUIDataListModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.beans.PropertyChangeListener;

public class GUITableView<T> {
    private TableView<T> tableView;
    private GUIDataListModel<T> guiDataListModel;
    private PropertyChangeListener changeListener = evt -> refreshTableView();


    public GUITableView(TableView<T> tableView, GUIDataListModel<T> dataListModel) {
        this.tableView = tableView;
        this.guiDataListModel = dataListModel;
        this.guiDataListModel.addListener(changeListener);
    }

    public void addColumn(TableColumn<T, ?> column) {
        this.tableView.getColumns().setAll(column);
    }

    public GUIDataListModel<T> getGuiDataListModel() {
        return guiDataListModel;
    }

    public TableView<T> getTableView() {
        return tableView;
    }

    public void addToTableView(T t) {
        guiDataListModel.addToDataModel(t);
    }


    public void refreshTableView() {
        this.tableView.setItems(this.guiDataListModel.getObservableDataList());
    }
}
