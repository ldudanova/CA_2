package CA_2.Models.Developer;

import CA_2.Models.Employee.Employee;
import CA_2.Models.Employee.EmployeePosition;
import CA_2.Models.Gender;
import CA_2.Utils.Generator;

/**
 * The Developer class represents a specific type of employee in the IT field, with additional attributes.
 *
 * This class extends the Employee class by adding a developer-specific field, `DeveloperType`, to categorize developers
 * by their area of expertise (e.g., Backend, Frontend).
 * It provides additional methods for generating developer data
 * and printing developer details.
 */

public class Developer extends Employee {

    /**
     * Represents the developer's specialty, such as FRONTEND, BACKEND, or MOBILE.
     */
    private final DeveloperType developerType;

    /**
     * Constructor for creating a Developer instance with specified attributes.
     *
     * This constructor initializes the developer's details, including name, email, position, and specialization.
     * It is used to define a new Developer object and categorize it under a specific DeveloperType.
     *
     * @param firstName     The developer's first name.
     * @param lastName      The developer's last name.
     * @param email         The developer's email.
     * @param gender        The developer's gender.
     * @param salary        The developer's salary.
     * @param position      The position level of the developer.
     * @param developerType The specific area of expertise of the developer.
     */
    public Developer(String firstName, String lastName, String email, Gender gender, double salary,
                     EmployeePosition position, DeveloperType developerType) {

        // Call parent's constructor
        super(firstName, lastName, email, gender, salary, position);
        // Set fields values
        this.developerType = developerType;
    }

    /**
     * Provides a string representation of the Developer object.
     *
     * This method overrides the `toString` method to add the developer's type to the output,
     * making it useful for displaying developer-specific details in reports.
     *
     * @return A string describing the developer's details and specialty.
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", " + developerType;
    }

    /**
     * Retrieves the DeveloperType of this developer.
     *
     * This getter provides access to the developer's specialization, which can help in categorizing or
     * filtering developers by their skills.
     *
     * @return The developer's specific DeveloperType.
     */
    public DeveloperType getDeveloperType() {
        return developerType;
    }

    /**
     * Prints the developer's details with indentation and an index.
     *
     * This method formats and outputs the developer's information to the console. It is useful for displaying
     * developer lists in an organized manner.
     *
     * @param index  The index of the developer in the list.
     * @param indent The indentation string for formatting.
     */
    public void print(int index, String indent) {
        System.out.println("  " + indent + index + ") " + this);
    }

    /**
     * Generates a new Developer object with random attributes.
     *
     * This static method uses the Generator utility to create a Developer with randomly assigned attributes,
     * making it useful for testing or populating a dataset with varied developer information.
     *
     * @param companyName The name of the company, used to generate a company-specific email.
     * @return A Developer instance with randomly generated values.
     */
    public static Developer generate(String companyName) {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName, companyName);
        //Generate developer type
        DeveloperType developerType = Generator.pickFromList(DeveloperType.class);
        // Randomly choose the player position
        EmployeePosition position = Generator.pickFromList(EmployeePosition.class);
        //Generate salary
        double salary = Generator.generateSalary(position);
        // Creating and returning Developer object
        return new Developer(firstName, lastName, email, gender, salary, position, developerType);
    }
}
