package datamodel;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_person;
    private String first_name;
    private String last_name;
    private Date birth_date;
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;

    public Person() { }
    public Person(int id_person, String first_name, String last_name, Date birth_date) {
        this(first_name, last_name, birth_date);
        this.id_person = id_person;
    }
    public Person(String first_name, String last_name, Date birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.addresses = new ArrayList<>();
    }

    public Person(String first_name, String last_name, Date birth_date, Address address) {
        this(first_name, last_name, birth_date);
        this.addresses.add(address);
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return first_name + " " + last_name;
    }
}
