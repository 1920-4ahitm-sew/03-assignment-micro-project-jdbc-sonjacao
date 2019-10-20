package at.htl.library.model;

import java.time.LocalDateTime;

public class Customer extends Person{

    private Long customerId;

    public Customer(Long ssno, String firstName, String lastName, LocalDateTime dateOfBirth, String gender, String street, Long postalCode, String city, String phoneNo, String email, Long customerId) {
        super(ssno, firstName, lastName, dateOfBirth, gender, street, postalCode, city, phoneNo, email);
        this.customerId = customerId;
    }

    public Customer() {
    }

    // Getter for customer id
    public Long getCustomerId() {
        return customerId;
    }
    // Setter for customer id
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
