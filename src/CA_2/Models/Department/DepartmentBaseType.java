package CA_2.Models.Department;


/**
 * The DepartmentBaseType enum categorizes departments by creation type: either DEFAULT or CUSTOM.
 *
 * This enum differentiates between standard, predefined departments and user-defined custom departments.
 * It is useful for applications that need to organize departments based on their source or creation process.
 */
public enum DepartmentBaseType {
    DEFAULT("Default"),
    CUSTOM("Custom");

    /**
     * Stores a readable title for the department base type, useful for displaying to users in interfaces.
      */
    private final String title;

    /**
     * Constructor to initialize each DepartmentBaseType with a title.
     *
     * This constructor assigns a descriptive title to each base type, making it easy to identify whether a department
     * is a default or custom type in displays and reports.
     *
     * @param title The title representing the base type of the department.
     */
    DepartmentBaseType(String title) {
        this.title = title;
    }

    /**
     * Returns the string representation of the department base type.
     *
     * This method overrides `toString` to return the title, providing a user-friendly display option for the base type.
     *
     * @return The string title of the department base type.
     */
    @Override
    public String toString() {
        return title;
    }

}
