package gui.controller;

import databaseUtil.DAOModel.AddressDAO;
import databaseUtil.DAOModel.CountryDAO;
import databaseUtil.DAOModel.PersonDAO;
import datamodel.Address;
import datamodel.Country;
import datamodel.Person;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Date;

import static java.time.LocalDate.from;

public class PersonDialogController implements ModalDialogController<Person> {
    public TextField first_name;
    public TextField last_name;
    public DatePicker birth_date;
    public TextField city;
    public TextField postal;
    public TextField address;
    public TextField country;


    public Person getNewPerson() {
        try {
            final Person person = generatePerson();

            CountryDAO countryDAO = new CountryDAO();
            final String countryName = getTrimmedInput(country);
            Country country = countryDAO.selectOneByCountryName(countryName);
            Address address1 = generateAddress(person, country);
            person.addAddress(address1);
            /*Date utilDate = new Date();
            Person person1 = new Person(
                    "Hugo",
                    "platzer",
                    new java.sql.Date(utilDate.getTime())
            );*/

            return person;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Person getDataFromDialog() {
        return getNewPerson();
    }

    private Address generateAddress(Person person, Country country) {
        final String street = getTrimmedInput(address);
        final String postalCode = getTrimmedInput(postal);
        final String cityName = getTrimmedInput(city);
        return new Address(street, postalCode, cityName, person, country);
    }

    private Person generatePerson() {
        final String first = getTrimmedInput(first_name);
        final String last = getTrimmedInput(last_name);
        final java.sql.Date birth_date = java.sql.Date.valueOf(
                from(this.birth_date.getValue())
        );
        return new Person(first, last, birth_date);
    }

    private String getTrimmedInput(TextField textField) {
        return textField.getText().trim();
    }

}
