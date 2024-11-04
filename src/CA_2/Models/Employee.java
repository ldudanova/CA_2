package CA_2.Models;

/**
 * Class for storing employee specified information
 * Inherited from Person class
 */

public class Employee extends Person {

    // Variable for employee position: value is one of EmployeeType enum values
    public EmployeeType position;
    // Variable for employee's department
    public Department department;

    // Constructor
    public Employee(String firstName, String lastName, String email,
                   EmployeeType position, Department department) {

        // Call parent's constructor
        super(firstName, lastName, email);
        // Set fields values
        this.position = position;
        this.department = department;

        // if there is a department then add this employee to the department as an employee
        if (department != null)
            department.employees.add(this);
    }

    /**
     * Set the way how convert objects of Player type to string
     *
     * @return String representation of Player object
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", position: " + position
                + "; Department: " + (department == null ? "not set" : department.name);
    }
}
