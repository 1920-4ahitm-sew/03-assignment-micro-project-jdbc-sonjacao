package at.htl.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "PUBLISHING_HOUSE")
@NamedQueries(
        @NamedQuery(
                name = "PublishingHouse.findall",
                query = "select p from PublishingHouse p"
        )
)
public class PublishingHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publisherName;
    private String street;
    private Long postalCode;
    private String city;
    private String country;

    public PublishingHouse(String publisherName, String street, Long postalCode, String city, String country) {
        this.publisherName = publisherName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public PublishingHouse() {
    }

    //region Getter and Setter

    public Long getId() {
        return id;
    }

    /*
    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("Publisher: %s", this.publisherName);
    }
}