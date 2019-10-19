package at.htl.library.model;

import java.time.LocalDateTime;

public class Book {

    private String isbn;
    private String title;
    private LocalDateTime publicationDate;
    private double price;

    private Genre genre;
    private Author author;
    private PublishingHouse publishingHouse;

    public Book(String isbn, String title, LocalDateTime publicationDate, double price, Genre genre, Author author, PublishingHouse publishingHouse) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
        this.genre = genre;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public Book() {
    }

    //region Getter and Setter

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    //endregion

    @Override
    public String toString() {
        return this.title;
    }
}
