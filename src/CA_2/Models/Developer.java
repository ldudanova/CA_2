package CA_2.Models;

import CA_2.Utils.Generator;
import CA_2.Utils.Store;

/**
 * Class for storing employee specified information
 * Inherited from Person class
 */

public class Developer extends Person {

    // Variable for employee position: value is one of EmployeeType enum values
    public DeveloperType position;
    // Variable for employee's department
    public static Department department;

    // Constructor
    public Developer(String firstName, String lastName, String email, Gender gender,
                     DeveloperType position, Department department) {

        // Call parent's constructor
        super(firstName, lastName, email, gender);
        // Set fields values
        this.position = position;
        this.department = department;

        // if there is a department then add this employee to the department as an employee
        if (department != null)
            department.developers.add(this);
    }

    /**
     * Set the way how convert objects of Player type to string
     *
     * @return String representation of Player object
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", position: " + position
                + "; Department: " + (department == null ? "not set" : department.getName());
    }

    /**
     *
     */
    public void print(int index, String indent) {
        System.out.println(indent + index+") " + super.toString() + ", " + position);
    }

    /**
     * Method for generating Developer object with random but appropriate data
     *
     * @return Generated Developer object
     */
    public static Developer generate() {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName);

        // Randomly choose the player position
        DeveloperType position = Generator.pickFromList(DeveloperType.class);

        // Create variable for team
        Department departmnet = null;

        // If there is any teams in the system pick from them else it will be null
        if (!Store.departments.isEmpty())
            departmnet = Generator.pickFromList(Store.getDepartmentArray());

        // Creating and returning Developer object
        return new Developer(firstName, lastName, email, gender, position, department);
    }
}
