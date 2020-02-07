package gui.controller;

import databaseUtil.DAOModel.AddressDAO;
import databaseUtil.DAOModel.PersonDAO;
import datamodel.Address;
import datamodel.Person;
import gui.guiModell.GUIDataListModel;
import gui.guiView.*;
import gui.guiView.guiViewUtil.PersonListCell;
import gui.guiView.guiViewUtil.TableColumnUtil;
import gui.guiView.guiViewUtil.LinkViews;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    public static final String ADDRESS_DIALOG_FXML = "addressDialog.fxml";
    public static final String PERSON_DIALOG_FXML = "personDialog.fxml";
    @FXML
    public ListView<Person> personListView;
    @FXML
    public Button addPersonBtn;
    @FXML
    public Button addAddressBtn;
    @FXML
    public TableView<Address> addressTable;
    @FXML
    public BorderPane mainBorderPane;
    @FXML
    private GUIListView<Person> guiListView;
    @FXML
    private GUITableView<Address> addressTableView;

    public void initialize() {
        PersonListCell personCell = new PersonListCell();
        PersonDAO personDAO = new PersonDAO();
        GUIDataListModel<Person> guiDataListModel = new GUIDataListModel<>(personDAO);
        guiListView = new GUIListView<>(personListView, guiDataListModel);
        guiListView.setCellValue(personCell);
        AddressDAO addressDAO = new AddressDAO();
        GUIDataListModel<Address> addressDataModel = new GUIDataListModel<>(addressDAO);
        TableColumnUtil.initTableColumns(addressTable);
        addressTableView = new GUITableView<>(addressTable, addressDataModel);
        LinkViews displayPersonAddress = new LinkViews(guiListView, addressTableView);
    }

    public void addPerson() {
        final Window window = mainBorderPane.getScene().getWindow();
        ModalDialog<Person> personDialog = new ModalDialog(window, PERSON_DIALOG_FXML);
        PersonDialogController personController = personDialog.getFxmlLoader().getController();
        personDialog.setDialogController(personController);
        final Person person = personDialog.getDialogData();
        guiListView.addToListView(person);
        final Address address = person.getAddresses().get(0);
        addressTableView.addToTableView(address);
        guiListView.selectLastItem();
    }

    public void addAddress() {
        final Window window = mainBorderPane.getScene().getWindow();
        ModalDialog<Address> addressDialog = new ModalDialog(window, ADDRESS_DIALOG_FXML);
        AddressDialogController addressController = addressDialog.getFxmlLoader().getController();
        addressDialog.setDialogController(addressController);
        final Address address = addressDialog.getDialogData();
        addressTableView.addToTableView(address);
        final List<Address> addresses = filterAddresses();
        addressTableView.getGuiDataListModel()
                .setObservableDataList(FXCollections.observableArrayList(addresses));
    }

    private List<Address> filterAddresses() {
        return addressTableView.getGuiDataListModel()
                    .getObservableDataList()
                    .stream()
                    .filter(address1 -> address1.getPerson().getId_person() == GUIListView.selectedIndex)
                    .collect(Collectors.toList());
    }
}