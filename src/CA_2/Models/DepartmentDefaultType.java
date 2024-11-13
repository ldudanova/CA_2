package CA_2.Models;

import java.util.Random;

/**
 * Enum with department type values
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

    // String representation of enum value
    private final String label;

    // Constructor
    private DepartmentDefaultType(String label) {
        this.label = label;
    }

    private DepartmentDefaultType() {
        this.label = this.name();
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

    public static DepartmentDefaultType getRandomDepartment() {
        DepartmentDefaultType[] values = DepartmentDefaultType.values();
        return values[new Random().nextInt(values.length)];
    }
}
