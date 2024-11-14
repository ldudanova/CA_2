package CA_2.Models;

import CA_2.Models.Employee.Employee;
import CA_2.Models.Employee.EmployeePosition;
import CA_2.Utils.Generator;

import java.util.Random;

/**
 * OfficeEmployee represents an employee working in within the company.
 *
 * This class extends the `Employee` class and adds a `title` field, specific to office employees,
 * to denote the job title of the employee within the office. Job title is an absolutely custom property.
 * We consider the user to know what kind of job titles for the company he or she needs.
 * It's the user's responsibility to create them in the way the user wants them to be,
 * because the user only knows what kind of job titles can exist within the company.
 * Examples include "Clerk" or "Desk Jockey". They are used for generating method.
 * The created variates are general and vague to give an opportunity to generate any employee to any department.
 * The `OfficeEmployee` class is designed to support scenarios where specific titles are needed for
 * categorizing office employees, helping to organize employee data more effectively.
 *
 * OfficeEmployee provides functionality for generating random office employee instances, which is useful
 * in testing environments or when building initial data sets. This class is also designed to print
 * formatted employee details, enhancing the usability of employee data displays in user interfaces.
 */

public class OfficeEmployee extends Employee {
    public String title;

    /**
     * Constructor for the OfficeEmployee class.
     *
     * This constructor initializes an OfficeEmployee object with values for first and last name, email,
     * gender, salary, position, and an office-specific title.
     * It is used whenever an office employee with specific
     * attributes needs to be created and stored.
     * This helps the application manage office-specific details more easily.
     *
     * @param firstName First name of the office employee.
     * @param lastName Last name of the office employee.
     * @param email Contact email for the employee.
     * @param gender Gender of the employee.
     * @param salary Salary of the employee.
     * @param position General position of the employee (e.g., junior, senior).
     * @param title Office-specific title (e.g., "Desk Jockey").
     */
    public OfficeEmployee(String firstName, String lastName, String email, Gender gender, double salary,
                          EmployeePosition position, String title) {
        // Call parent's constructor
        super(firstName, lastName, email, gender, salary, position);
        // Set fields values
        this.title = title;
    }

    /**
     * Returns a string representation of an OfficeEmployee object.
     *
     * This overridden `toString` method combines details from the Employee class
     * with the title of the office employee.
     * This detailed output is useful in displaying structured employee information,
     * especially when printing lists of employees.
     *
     * @return A formatted string representation of OfficeEmployee data.
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", " + title;
    }

    /**
     * Prints the details of the OfficeEmployee instance with a specified index and indentation.
     *
     * This method provides a formatted output for console display, making it easy to visually identify
     * individual employees within a structured list.
     * It is useful in scenarios where multiple
     * employees are printed in sequence.
     *
     * @param index Numerical index for the employee in a list.
     * @param indent Indentation to use for formatting.
     */
    public void print(int index, String indent) {
        System.out.println("  " + indent + index+") " + this);
    }

    /**
     * Generates a new OfficeEmployee instance with random data.
     *
     * This static method utilizes helper methods from the Generator class to create an office employee
     * with randomly chosen attributes. It is particularly useful for testing, data seeding, or creating
     * mock data. Randomly generated employees help developers quickly populate data for various purposes.
     *
     * @param companyName The name of the company used to generate the employee’s email.
     * @return A new OfficeEmployee object with random data.
     */
    public static OfficeEmployee generate(String companyName) {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName, companyName);
        //Generate employee type
        String title = generateJobTitle();
        // Randomly choose the player position
        EmployeePosition position = Generator.pickFromList(EmployeePosition.class);
        //Generate salary
        double salary = Generator.generateSalary(position);

        // Creating and returning Developer object
        return new OfficeEmployee(firstName, lastName, email, gender, salary, position, title);
    }

    /**
     * Generates a random job title from a predefined set of possible office titles.
     *
     * This method provides a random office-related title that can be assigned to an OfficeEmployee.
     * This is useful for creating diverse employee data with varied roles for a realistic data model.
     *
     * @return A random title from the array of possible office titles.
     */
    public static String generateJobTitle() {
        return possibleOfficeEmployeeJobTitles[new Random().nextInt(possibleOfficeEmployeeJobTitles.length)];
    }

    /**
     * Array of possible Office Employee job titles which a used for generateJobTitle method
     */
    private static final String[] possibleOfficeEmployeeJobTitles =
            new String[]{"Clerk", "White-collar", "Office rat", "Office plankton", "Salary person", "Corporate stooge", "Cubicle mouse", "Desk jockey", "Office monkey", "Dweller of a cubicle farm", "Lemming", "Cubicle dweller", "Pin-striped worker"};

}
