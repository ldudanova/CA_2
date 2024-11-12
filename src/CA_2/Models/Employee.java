package CA_2.Models;

public class Employee extends Person  {
    public EmployeePosition position;
    public double salary;
    public String email;

    // Variable for employee's department
    public Department department;

    //Constructor
    public Employee(String firstName, String lastName, String email, Gender gender,
                    double salary, EmployeePosition position, Department department) {
        // Call parent's constructor
        super(firstName, lastName, gender);
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", email: " + (email == null ? "not set" : email)
                + ", position: " + position
                + "; Department: " + (department == null ? "not set" : department.getName()
                + "; Salary: " + salary);
    }
}
