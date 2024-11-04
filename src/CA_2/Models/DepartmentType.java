package CA_2.Models;

/**
 * Enum with department type values
 */
public enum DepartmentType {
    CUSTOMER_SERVICE("customer service"),
    TECHNICAL_SUPPORT("technical support"),
    HUMAN_RESOURCES("hr"),
    MARKETING("marketing"),
    SALES("sales"),
    FINANCE("finance"),
    DEVELOPMENT("development"),
    OPERATIONS("operations");

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
