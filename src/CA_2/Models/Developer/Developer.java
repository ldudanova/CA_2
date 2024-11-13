package CA_2.Models.Developer;

import CA_2.Models.Employee.Employee;
import CA_2.Models.Employee.EmployeePosition;
import CA_2.Models.Gender;
import CA_2.Utils.Generator;

/**
 * Class for storing employee specified information
 * Inherited from Person class
 */

public class Developer extends Employee {

    // Variable for employee position: value is one of EmployeeType enum values
    public DeveloperType developerType;

    // Constructor
    public Developer(String firstName, String lastName, String email, Gender gender, double salary,
                     EmployeePosition position, DeveloperType developerType) {

        // Call parent's constructor
        super(firstName, lastName, email, gender, salary, position);
        // Set fields values
        this.developerType = developerType;
    }

    /**
     * Set the way how convert objects of Player type to string
     *
     * @return String representation of Player object
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", " + developerType;
    }

    /**
     *
     */
    public void print(int index, String indent) {
        System.out.println("  "+indent + index+") " + this);
    }

    /**
     * Method for generating Developer object with random but appropriate data
     *
     * @return Generated Developer object
     */
    public static Developer generate(String companyName) {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName, companyName);
        //Generate developer type
        DeveloperType developerType = Generator.pickFromList(DeveloperType.class);
        // Randomly choose the player position
        EmployeePosition position = Generator.pickFromList(EmployeePosition.class);
        //Generate salary
        double salary = Generator.generateSalary(position);
        // Creating and returning Developer object
        return new Developer(firstName, lastName, email, gender, salary, position, developerType);
    }
}
