package at.htl.library.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate publishingDate;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private PublishingHouse publishingHouse;

    public Book() {
    }

    public Book(String title, LocalDate publishingDate, Author author, Genre genre, PublishingHouse publishingHouse) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.author = author;
        this.genre = genre;
        this.publishingHouse = publishingHouse;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public String toString() {
        return "Book: " + title;
    }
}
