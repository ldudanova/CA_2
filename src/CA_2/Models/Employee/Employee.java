package CA_2.Models.Employee;

import CA_2.Models.Gender;
import CA_2.Models.Person;

public class Employee extends Person {
    public EmployeePosition position;
    public double salary;
    public String email;

    //Constructor
    public Employee(String firstName, String lastName, String email, Gender gender,
                    double salary, EmployeePosition position) {
        // Call parent's constructor
        super(firstName, lastName, gender);
        this.email = email;
        this.salary = salary;
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", email: " + (email == null ? "not set" : email)
                + ", Salary: " + salary
                + ", " + position;

    }
}
