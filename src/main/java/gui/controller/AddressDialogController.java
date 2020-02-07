package gui.controller;

import databaseUtil.DAOModel.AddressDAO;
import databaseUtil.DAOModel.CountryDAO;
import databaseUtil.DAOModel.PersonDAO;
import datamodel.Address;
import datamodel.Country;
import datamodel.Person;
import gui.guiModell.GUIDataListModel;
import gui.guiView.GUIListView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.annotations.Fetch;

public class AddressDialogController implements ModalDialogController<Address> {
    @FXML
    public TextField street;
    @FXML
    public TextField city;
    @FXML
    public TextField zip_code;
    @FXML
    public TextField country;

    public Address getNewAddress() {
        final String streetValue = getTrimmedInput(street);
        final String cityValue = getTrimmedInput(city);
        final String zipValue = getTrimmedInput(zip_code);
        PersonDAO personDAO = new PersonDAO();
        GUIDataListModel<Person> personList = new GUIDataListModel<>(personDAO);
        final Person selectedPerson = personList.getObservableDataList()
                .stream()
                .filter(person -> person.getId_person() == GUIListView.selectedIndex)
                .findAny()
                .get();


        /*System.out.println(filteredPerson);*/
        /*Person selectedPerson = FXPerson.transformToPerson(FxPersonTableList.personSelected);*/
        System.out.println(GUIListView.selectedIndex);
        final String countryName = getTrimmedInput(country);
        CountryDAO countryDAO = new CountryDAO();
        AddressDAO addressDAO = new AddressDAO();
        Country filteredCountry = countryDAO.selectOneByCountryName(countryName);
        return new Address(streetValue, zipValue, cityValue, selectedPerson, filteredCountry);



        /*CountryDAO countryDAO = new CountryDAO();

        final String countryName = getTrimmedInput(country);
        Country country = countryDAO.selectOneByCountryName(countryName);

        final String streetValue = getTrimmedInput(street);
        final String cityValue = getTrimmedInput(city);
        final String zipValue = getTrimmedInput(zip_code);
        AddressDAO addressDAO = new AddressDAO();*/

        /*final Address newAddress = new Address(
                streetValue,
                zipValue,
                cityValue,
                selectedPerson,
                country
        );
        addressDAO.save(newAddress);*/
        /*System.out.println("From Address Dialog");
        return null;*/
    }

    @Override
    public Address getDataFromDialog() {
        return getNewAddress();
    }

    private String getTrimmedInput(TextField textField) {
        return textField.getText().trim();
    }
}
