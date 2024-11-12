package CA_2.Models;

import CA_2.Utils.Generator;
import CA_2.Utils.Store;

/**
 * Class for storing manager specified information
 * Inherited from Person class
 */
public class Manager extends Person {
    // Variable for manager type: value is one of ManagerType enum values
    public ManagerType managerType;
    public double salary;
    public String email;

    // Variable for employee's department
    public Department department;

//    private EmployeePosition position;

    // Constructor
    public Manager(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   double salary,
                   ManagerType managerType,
                   Department department) {
        // Call parent's constructor
        super(firstName, lastName, gender);

        // Set fields values
        this.managerType = managerType;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    /**
     * Set the way how convert objects of Manager type to string
     *
     * @return String representation of Manager object
     */
    @Override
    public String toString() {
        return super.toString() + ", " + managerType
                + "; Department: " + (department == null ? "not set" : department.getName());
    }

    /**
     *
     */
    public void print(int index, String indent) {
        System.out.println(
                indent
                        + "  "
                        + index
                        + ") "
                        + super.toString()
                        + ", "
                        + managerType
                        + ", "
                        + this.email
        );
    }

    /**
     * Method for generating Manager object with random but appropriate data
     *
     * @return Generated Manager object
     */
    public static Manager generate() {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName);

        // Randomly choose the manager type
        ManagerType managerType = Generator.pickFromList(ManagerType.class);
        double salary = Generator.generateSalary(managerType, null);

        // Create variable for team
        Department department = null;

        // If there is any departments in the system pick from them else it will be null
        if (!Store.departments.isEmpty())
            department = Generator.pickFromList(Store.getDepartmentArray());

        // Creating and returning Manager object
        return new Manager(firstName,
                lastName,
                email,
                gender,
                salary,
                managerType,
                department);
    }
}
