package CA_2.Models.Department;

/**
 * The CustomDepartment class represents a department created by users with a custom name.
 *
 * This class allows the creation of departments with any user-specified name, making it flexible for
 * unique organizational needs beyond the default options.
 */
public class CustomDepartment extends Department {

    /**
     * Holds the custom name of the department.
     * It's private and final, ensuring it can't be modified directly.
      */
    private final String EnteredName;

    /**
     * Constructor to initialize a CustomDepartment with a specific name.
     *
     * @param name The custom name for the department.
     */
    public CustomDepartment(String name) {
        EnteredName = name;
    }

    /**
     * Returns the custom name of the department.
     *
     * This method provides access to the department's name as entered by the user.
     *
     * @return The name of the department.
     */
    @Override
    public String getName() {
        return EnteredName;
    }

    /**
     * Returns the type of the department as CUSTOM, indicating it was user-defined.
     *
     * @return The CUSTOM base type for this department.
     */
    @Override
    public DepartmentBaseType getType() {
        return DepartmentBaseType.CUSTOM;
    }

}
