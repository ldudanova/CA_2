package CA_2.Models.Department;

/**
 * The PrecreatedDepartment class represents a department that is pre-defined with a specific type.
 *
 * This class extends the abstract Department class and uses a DepartmentDefaultType to define a default department,
 * such as "Sales" or "Technical Support." By inheriting Department, it uses common department functions
 * like employee lists, while using its own methods to define and access a specific department type. This class is
 * useful when there is a need to create a department with a well-known, standard purpose.
 */
public class PrecreatedDepartment extends Department {
    /**
     * Stores the pre-defined department type.
     * It is private to enforce encapsulation and limit direct modification.
      */
    private final DepartmentDefaultType SelectedDepartment;

    /**
     * Constructor to initialize a PrecreatedDepartment with a specific default department type.
     *
     * This constructor assigns the chosen department type to the SelectedDepartment field, allowing the creation
     * of a department based on predefined options.
     *
     * @param department The predefined department type.
     */
    public PrecreatedDepartment(DepartmentDefaultType department) {
        SelectedDepartment = department;
    }

    /**
     * Returns the selected department type.
     *
     * This getter provides access to the predefined department type, which may be useful for identifying the
     * specific purpose of the department in the application.
     *
     * @return The selected DepartmentDefaultType.
     */
    public DepartmentDefaultType GetSelectedDepartment() {
        return SelectedDepartment;
    }

    /**
     * Provides the name of the department based on the selected department type.
     *
     * This method overrides the abstract `getName` method from the Department class and returns the name of the
     * pre-created department by calling `toString` on the SelectedDepartment.
     *
     * @return The name of the selected department.
     */
    @Override
    public String getName() {
        return SelectedDepartment.toString();
    }

    /**
     * Provides the base type of the department, which is always DEFAULT for pre-created departments.
     *
     * This method indicates that this department type is pre-defined rather than custom-created by the user.
     *
     * @return The base type of the department as DEFAULT.
     */
    @Override
    public DepartmentBaseType getType() {
        return DepartmentBaseType.DEFAULT;
    }
}
