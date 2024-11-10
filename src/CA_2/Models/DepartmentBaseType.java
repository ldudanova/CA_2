package CA_2.Models;

/**
 * Enum with department type values
 */
public enum DepartmentBaseType {
    DEFAULT("Default"),
    CUSTOM("Custom");

    // String representation of enum value
    private final String title;

    // Constructor
    DepartmentBaseType(String title) {
        this.title = title;
    }

    /**
     * Set the way how convert enum to string
     *
     * @return String value of enum (title)
     */
    @Override
    public String toString() {
        return title;
    }

}
