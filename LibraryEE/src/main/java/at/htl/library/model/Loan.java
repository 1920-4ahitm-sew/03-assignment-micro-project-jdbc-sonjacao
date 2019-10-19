package at.htl.library.model;

import java.time.LocalDateTime;

public class Loan {
    private Customer customer;
    private Employee employee;
    private BookCopy bookCopy;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;

    public Loan(Customer customer, Employee employee, BookCopy bookCopy, LocalDateTime loanDate, LocalDateTime returnDate) {
        this.customer = customer;
        this.employee = employee;
        this.bookCopy = bookCopy;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan() {
    }

    //region Getter and Setter

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    //endregion

    @Override
    public String toString() {
        return String.format("Lent %s to %s", this.bookCopy, this.customer);
    }
}
