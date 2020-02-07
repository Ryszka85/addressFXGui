package datamodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String id_country;
    private String country_name;
    /*@OneToMany(mappedBy = "country")
    private List<datamodel.Address> addresses;*/

    public Country() {}
    public Country(String id_country, String country_name) {
        this.id_country = id_country;
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return country_name;
    }

    public String getId_country() {
        return id_country;
    }

    public void setId_country(String id_country) {
        this.id_country = id_country;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
