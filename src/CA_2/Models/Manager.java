package CA_2.Models;

/**
 * Class for storing manager specified information
 * Inherited from Person class
 */
public class Manager extends Person {
    // Variable for manager type: value is one of ManagerType enum values
    public ManagerType managerType;
    // Variable for manager's department
    public Department department;

    // Constructor
    public Manager(String firstName, String lastName, String email,
                   ManagerType managerType, Department department) {
        // Call parent's constructor
        super(firstName, lastName, email);

        // Set fields values
        this.managerType = managerType;
        this.department = department;

        // If there is a department then add this manager to the department as a manager
        if (department != null)
            department.managers.add(this);
    }

    /**
     * Set the way how convert objects of Manager type to string
     *
     * @return String representation of Manager object
     */
    @Override
    public String toString() {
        return super.toString() + ", " + managerType
                + "; Team: " + (department == null ? "not set" : department.name);
    }
}
