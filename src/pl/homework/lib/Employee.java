package pl.homework.lib;

public class Employee extends Person {

    private String division;
    private double salary;


    public Employee(String firstName, String lastName, String pesel, String division, double salary) {
        super(firstName, lastName, pesel);
        this.division = division;
        this.salary = salary;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel() + ";" + division + ";" +salary;
    }
    @Override
    public String toString() {
        return "Pracownik: " + super.toString() + getDivision() + " wypłata: " + salary;
    }
}
