package CA_2.Models;

/**
 * Enum with department type values
 */
public enum DepartmentType {
    CUSTOMER_SERVICE("Customer Service"),
    TECHNICAL_SUPPORT("Technical Support"),
    HUMAN_RESOURCES("HR"),
    MARKETING("Marketing"),
    SALES("Sales"),
    FINANCE("Finance"),
    DEVELOPMENT("Development"),
    OPERATIONS("Operations");

    // String representation of enum value
    private final String label;

    // Constructor
    DepartmentType(String label) {
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
}
