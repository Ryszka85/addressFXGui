package gui.guiView.guiViewUtil;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableColumnValue<S, T> extends TableColumn<S, T> {
    private TableColumn<S, T> tableColumn;
    private PropertyValueFactory<S, T> propertyValueFactory;

    public TableColumnValue(final String columnName,final String propertyName) {
        this.tableColumn = new TableColumn<>(columnName);
        propertyValueFactory = new PropertyValueFactory<>(propertyName);
        this.tableColumn.setCellValueFactory(propertyValueFactory);
    }

    public TableColumn<S, T> getTableColumn() {
        return tableColumn;
    }
}
