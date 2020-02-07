package datamodel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_address;
    private String street;
    private String postal_code;
    private String city;
    @ManyToOne
    @JoinColumn(name="id_person")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    public Address() {}
    public Address(String street, String postal_code, String city, Person person, Country country) {
        this.street = street;
        this.postal_code = postal_code;
        this.city = city;
        this.person = person;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id_address +
                ", street='" + street + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                ", person=" + person +
                ", country=" + country +
                '}';
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId_Address() {
        return id_address;
    }

    public void setId_Address(int id_Address) {
        this.id_address = id_Address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city_name) {
        this.city = city_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


}
