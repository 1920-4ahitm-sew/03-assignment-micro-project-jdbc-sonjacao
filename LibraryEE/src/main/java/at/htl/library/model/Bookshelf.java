package at.htl.library.model;

import java.util.LinkedList;
import java.util.List;

public class Bookshelf {

    private Long shelfId;
    private Genre genre;
    private List<Book> storedBooks = new LinkedList<>();

    public Bookshelf(Long shelfId, Genre genre, List<Book> storedBooks) {
        this.shelfId = shelfId;
        this.genre = genre;
        this.storedBooks = storedBooks;
    }

    public Bookshelf(Long shelfId, Genre genre) {
        this.shelfId = shelfId;
        this.genre = genre;
    }

    public Bookshelf() {
    }

    //region Getter and Setter

    public Long getShelfId() {
        return shelfId;
    }

    public void setShelfId(Long shelfId) {
        this.shelfId = shelfId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Book> getStoredBooks() {
        return storedBooks;
    }

    public void setStoredBooks(List<Book> storedBooks) {
        this.storedBooks = storedBooks;
    }

    //endregion


    @Override
    public String toString() {
        return String.format("Bookshelf %d from genre %s", this.shelfId, this.genre);
    }
}
