package CA_2.Models.Manager;

import CA_2.Models.Gender;
import CA_2.Models.Person;
import CA_2.Utils.Generator;

/**
 * Manager represents a manager-level individual within the company.
 *
 * This class extends the Person class to include additional attributes specific to managers,
 * such as `managerType`,`salary` and `email`. The Manager class is useful for storing detailed information
 * about a manager, allowing for separation and organization of personnel by hierarchy level.
 *
 */
public class Manager extends Person {
    /**
     * Stores the manager's type, which is final as it should not change after the Manager is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getManagerType() method.
     */
    private final ManagerType managerType;

    /**
     * Stores the manager's salary, which is final as it should not change after the Manager is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getSalary() method.
     */
    private final double salary;

    /**
     * Stores the manager's email, which is final as it should not change after the Manager is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getEmail() method.
     */
    private final String email;

    //START Class getters
    /**
     * Retrieves the type of the manager.
     *
     * @return the manager's type.
     */
    public ManagerType getManagerType() {
        return managerType;
    }

    /**
     * Retrieves the salary of the manager.
     *
     * @return the manager's salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Retrieves the email of the manager.
     *
     * @return the manager's email.
     */
    public String getEmail() {
        return email;
    }
    //END Class getters

    /**
     * Constructor for creating a `Manager` object.
     *
     * This constructor initializes the `Manager` object with the provided first name, last name,
     * gender, salary and manager type values. By defining these fields at the time of instantiation, we ensure
     * that all `Manager` objects carry essential, identifiable information.
     *
     * @param firstName Manager's first name
     * @param lastName Manager's last name
     * @param email Manager's email
     * @param gender Manager's gender
     * @param salary Manager's salary
     * @param managerType Manager's type
     */
    public Manager(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   double salary,
                   ManagerType managerType) {
        // Call parent's constructor
        super(firstName, lastName, gender);

        // Set fields values
        this.managerType = managerType;
        this.salary = salary;
        this.email = email;
    }

    /**
     * Set the way how convert objects of Manager type to string
     *
     * @return String representation of Manager object
     */
    @Override
    public String toString() {
        return super.toString() + ", " + email + ", Salary: " + salary + ", " + managerType;
    }

    /**
     * Prints the details of the Manager instance with a specified index and indentation.
     *
     * This method provides a formatted output for console display, making it easy to visually identify
     * individual managers within a structured list.
     * It is useful in scenarios where multiple
     * managers are printed in sequence.
     *
     * @param index Numerical index for the employee in a list.
     * @param indent Indentation to use for formatting.
     */
    public void print(int index, String indent) {
        System.out.println(
                indent
                        + "  "
                        + index
                        + ") "
                        + this
        );
    }

    /**
     * Generates a new Manager with randomized details.
     *
     * This method is useful for testing or creating demo data, quickly providing a mock Manager instance
     * with randomized but realistic attributes, such as name, email, salary, and manager type.
     *
     * @param companyName The name of the company, which is used to construct the manager's email.
     * @return A Manager object with random details.
     */
    public static Manager generate(String companyName) {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName, companyName);

        // Randomly choose the manager type
        ManagerType managerType = Generator.pickFromList(ManagerType.class);
        double salary = Generator.generateSalary(managerType);

        // Creating and returning Manager object
        return new Manager(
                firstName,
                lastName,
                email,
                gender,
                salary,
                managerType);
    }
}
