package at.htl.library.model;

public class BookCopy {

    private Book book;
    private Bookshelf bookshelf;

    public BookCopy(Book book, Bookshelf bookshelf) {
        this.book = book;
        this.bookshelf = bookshelf;
    }

    public BookCopy(Book book) {
        this.book = book;
    }

    public BookCopy() {
    }

    //region Getter and Setter

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    //endregion


    @Override
    public String toString() {
        return String.format("copy of '" + this.book + "'");
    }
}

