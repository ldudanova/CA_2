package CA_2.Models.Employee;

/**
 * Enum with employee type values
 */
public enum EmployeePosition {
    JUNIOR("junior"),
    MIDDLE("middle"),
    SENIOR("senior"),
    CONTRACT("contract"),
    INTERN("intern");

    // String representation of enum value
    private final String label;

    // Constructor
    EmployeePosition(String label) {
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

