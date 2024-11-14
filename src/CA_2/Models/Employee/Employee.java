package CA_2.Models.Employee;

import CA_2.Models.Gender;
import CA_2.Models.Person;

/**
 * The Employee class represents an employee within the company, extending the Person class.
 *
 * This class adds specific attributes for an employee, including salary, email and position.
 * It serves as a base class for different types of employees (e.g., OfficeEmployee),
 * enabling a structured representation of all employees.
 */
public class Employee extends Person {
    /**
     * Stores the Employee's position, which is final as it should not change after the Employee is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getEmployeePosition() method.
     */
    private final EmployeePosition position;

    /**
     * Stores the Employee's salary, which is final as it should not change after the Employee is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getSalary() method.
     */
    private final double salary;

    /**
     * Stores the Employee's email, which is final as it should not change after the Employee is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getEmail() method.
     */
    private final String email;

    /**
     * Constructor for creating an Employee object.
     *
     * Purpose:
     * - To initialize a new employee with all necessary information and prepare it to
     * be added to a department.
     *
     * Use Case:
     * - This constructor is essential for creating new employees for proper categorization and salary assignment.
     *
     * @param firstName The employee's first name.
     * @param lastName The employee's last name.
     * @param email The employee's email address.
     * @param gender The gender of the employee.
     * @param salary The employee's salary.
     * @param position The employee's position within the company.
     */
    public Employee(String firstName, String lastName, String email, Gender gender,
                    double salary, EmployeePosition position) {
        // Call parent's constructor
        super(firstName, lastName, gender);
        this.email = email;
        this.salary = salary;
        this.position = position;
    }

    /**
     * Method toString provides a string representation of the Employee object.
     *
     * Purpose:
     * - Overriding the toString() method allows for a clear, simple representation
     * of an Employee object when printed or converted to a string.
     *
     * Use Case:
     * - Print object information.
     *
     * @return The string with all information of employee.
     */
    @Override
    public String toString() {
        return super.toString()
                + ", " + (email == null ? "email not set" : email)
                + ", Salary: " + salary
                + ", " + position;

    }

    //START Class getters
    /**
     * Retrieves the salary of the employee.
     *
     * @return the employee's salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Retrieves the email of the employee.
     *
     * @return the employee's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the position of the employee.
     *
     * @return the employee's position.
     */
    public EmployeePosition getPosition() {
        return position;
    }
    //END Class getters
}
