package gui.guiView.guiViewUtil;


import datamodel.Address;
import javafx.scene.control.TableView;

public class TableColumnUtil {
    public static final String CITY_COLUMN = "City";
    public static final String CITY_VALUE = "city";
    public static final String ZIP_CODE_COLUMN = "Zip code";
    public static final String POSTAL_CODE_VALUE = "postal_code";
    public static final String STREET_COLUMN = "Street";
    public static final String STREET_VALUE = "street";
    public static final String COUNTRY_COLUMN = "Country";
    public static final String COUNTRY_VALUE = "country";

    public static void initTableColumns(TableView<Address> tableView) {
        TableColumnValue<Address, String> city = new TableColumnValue<>(CITY_COLUMN, CITY_VALUE);
        TableColumnValue<Address, String> zipCode = new TableColumnValue<>(ZIP_CODE_COLUMN, POSTAL_CODE_VALUE);
        TableColumnValue<Address, String> address = new TableColumnValue<>(STREET_COLUMN, STREET_VALUE);
        TableColumnValue<Address, String> country = new TableColumnValue<>(COUNTRY_COLUMN, COUNTRY_VALUE);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().setAll(zipCode.getTableColumn(),
                city.getTableColumn(),
                address.getTableColumn(),
                country.getTableColumn());
    }

}
