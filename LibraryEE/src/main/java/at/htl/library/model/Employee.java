package at.htl.library.model;

import java.time.LocalDateTime;

public class Employee extends Person {

    private Long empno;
    private LocalDateTime hireDate;
    private Double salary;
    private Person manager;

    public Employee(Long ssno, String firstName, String lastName, LocalDateTime dateOfBirth, String gender, String street, Long postalCode, String city, String phoneNo, String email, Long empno, LocalDateTime hireDate, Double salary, Person manager) {
        super(ssno, firstName, lastName, dateOfBirth, gender, street, postalCode, city, phoneNo, email);
        this.empno = empno;
        this.hireDate = hireDate;
        this.salary = salary;
        this.manager = manager;
    }

    public Employee() {
    }

    //region Getter and Setter

    public Long getEmpno() {
        return empno;
    }

    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    //endregion
}
