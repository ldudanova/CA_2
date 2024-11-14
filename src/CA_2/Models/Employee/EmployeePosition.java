package CA_2.Models.Employee;

/**
 * The EmployeePosition enum defines various levels of employee positions within a company.
 *
 * This enum categorizes employees by their experience or contract type, with levels such as "Junior," "Middle,"
 * "Senior," "Contract," and "Intern."
 * EmployeePosition helps ensure consistent use of position titles application
 * and helps in defining employee roles for various reports, categorization and their generation.
 */
public enum EmployeePosition {
    JUNIOR("junior"),
    MIDDLE("middle"),
    SENIOR("senior"),
    CONTRACT("contract"),
    INTERN("intern");

    // String representation of enum value
    private final String label;

    /**
     * Constructor to initialize each EmployeePosition with a label.
     *
     * This constructor assigns a string label to each position, making it easier to display readable position names
     * in the UI or reports.
     *
     * @param label The label representing the position level.
     */
    EmployeePosition(String label) {
        this.label = label;
    }

    /**
     * Provides a string representation of the enum value.
     *
     * This method overrides the default `toString` to return the readable label assigned to each enum value.
     * It is especially useful when displaying the employee's position as text rather than code.
     *
     * @return The string label of the enum value.
     */
    @Override
    public String toString() {
        return label;
    }

    /**
     * Parses a string and returns the corresponding EmployeePosition enum value.
     *
     * This static method is useful for converting text input into a valid EmployeePosition value.
     * It checks for a match between the provided position string and the enum's labels.
     *
     * @param position The string representation of the position.
     * @return The matching EmployeePosition or null if no match is found.
     */
    public static EmployeePosition parse(String position) {
        if (position.trim().equalsIgnoreCase(EmployeePosition.INTERN.toString())) {
            return EmployeePosition.INTERN;
        }
        if (position.trim().equalsIgnoreCase(EmployeePosition.JUNIOR.toString())) {
            return EmployeePosition.JUNIOR;
        }
        if (position.trim().equalsIgnoreCase(EmployeePosition.MIDDLE.toString())) {
            return EmployeePosition.MIDDLE;
        }
        if (position.trim().equalsIgnoreCase(EmployeePosition.SENIOR.toString())) {
            return EmployeePosition.SENIOR;
        }
        if (position.trim().equalsIgnoreCase(EmployeePosition.CONTRACT.toString())) {
            return EmployeePosition.CONTRACT;
        }
        return null;
    }
}

