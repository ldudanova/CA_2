package CA_2.Models;

/**
 * Enum with employee type values
 */
public enum EmployeeType {
    FULL_TIME("full time"),
    PART_TIME("part time"),
    CONTRACT("contract"),
    INTERN("intern");

    // String representation of enum value
    private final String label;

    // Constructor
    EmployeeType(String label) {
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

