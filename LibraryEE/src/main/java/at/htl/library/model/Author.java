package at.htl.library.model;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Author extends Person {

    private Long authorNo;
    private List<Book> publications = new LinkedList<>();

    public Author(Long authorNo, List<Book> publications, Long ssno, String firstName, String lastName, LocalDateTime dateOfBirth, String gender, String street, Long streetNo, Long postalCode, String city, String phoneNo, String email) {
        super(ssno, firstName, lastName, dateOfBirth, gender, street, streetNo, postalCode, city, phoneNo, email);
        this.authorNo = authorNo;
        this.publications = publications;
    }

    public Author() {
    }

    //region Getter and Setter
    public Long getAuthorNo() {
        return authorNo;
    }

    public void setAuthorNo(Long authorNo) {
        this.authorNo = authorNo;
    }

    public List<Book> getPublications() {
        return publications;
    }

    public void setPublications(List<Book> publications) {
        this.publications = publications;
    }
    //endregion

}
