package CA_2.Models.Department;

import java.util.Random;

/**
 * The DepartmentDefaultType enum represents standard department types in a company.
 *
 * Each department type has a unique purpose, such as "Sales" or "Human Resources," which helps categorize
 * employees and activities. This enum is useful for creating default departments with common organizational
 * functions and facilitates consistency in department naming and usage.
 */
public enum DepartmentDefaultType {
    CUSTOMER_SERVICE("Customer Service"),
    TECHNICAL_SUPPORT("Technical Support"),
    HUMAN_RESOURCES("HR"),
    MARKETING("Marketing"),
    SALES("Sales"),
    FINANCE("Finance"),
    ACCOUNTING("Accounting"),
    IT("IT Development"),
    OPERATIONS("Operations");

    /**
     * A label that provides a readable representation of the department type, making it useful in user interfaces.
      */
    private final String label;

    /**
     * Constructor to initialize each DepartmentDefaultType with a descriptive label.
     *
     * This constructor assigns a string label to each department type, making the department name
     * easily readable in UI elements and reports.
     *
     * @param label The label representing the department type.
     */
    private DepartmentDefaultType(String label) {
        this.label = label;
    }

    /**
     * Set the way how convert enum to string
     *
     * @return String value of enum (label)
     */
    @Override
    public String toString() {
        return label;
    }

    /**
     * Returns a random DepartmentDefaultType, which can be used to randomly assign a department in testing.
     *
     * This static method selects a random department from the available types, making it useful for test data
     * generation and simulations.
     *
     * @return A randomly selected DepartmentDefaultType.
     */
    public static DepartmentDefaultType getRandomDepartment() {
        DepartmentDefaultType[] values = DepartmentDefaultType.values();
        return values[new Random().nextInt(values.length)];
    }
}
