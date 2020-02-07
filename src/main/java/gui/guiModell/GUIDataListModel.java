package gui.guiModell;

import databaseUtil.DAOModel.DbDAO;
import databaseUtil.DAOModel.PersonDAO;
import datamodel.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import validation.Validator;

import javax.swing.event.ChangeListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class GUIDataListModel<T> implements ObservMe {
    private ObservableList<T> observableDataList;
    private DbDAO<T> dataAccessObject;
    PropertyChangeSupport propertyChangeSupport;

    public GUIDataListModel(DbDAO<T> dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
        this.observableDataList = FXCollections.observableArrayList();
        this.observableDataList = FXCollections.observableArrayList(dataAccessObject.selectAll());
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void addListener(PropertyChangeListener changeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(changeListener);
    }

    @Override
    public void removeListener(PropertyChangeListener changeListener) {
        this.propertyChangeSupport.removePropertyChangeListener(changeListener);
    }

    public void refreshObservableDataList() {
        this.observableDataList.setAll(dataAccessObject.selectAll());
    }

    public ObservableList<T> getObservableDataList() {
        return observableDataList;
    }

    public void setObservableDataList(List<T> observableDataList) {
        this.observableDataList = FXCollections.observableArrayList(observableDataList);
        this.propertyChangeSupport.firePropertyChange("observableDataList",
                null, this.observableDataList);
    }

    public T getDataAtIndex(final int index) {
        if (index >= 0) {
            this.propertyChangeSupport.firePropertyChange("observableDataList",
                    null, this.observableDataList.get(index));
            return this.observableDataList.get(index);
        }
        return null;
    }


    public void addToDataModel(T t) {
        try {
            Validator.objectNotNull(t);
            observableDataList.add(t);
            dataAccessObject.save(t);
            refreshObservableDataList();
            this.propertyChangeSupport
                    .firePropertyChange("observableDataList",
                            null, observableDataList);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void removeFromDataModel(T t) {
        try {
            Validator.objectNotNull(t);
            observableDataList.remove(t);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
