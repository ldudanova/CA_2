package CA_2.Models;

import CA_2.Utils.Generator;
import CA_2.Utils.Store;

import java.util.Random;

public class OfficeEmployee extends Employee {
    public String title;

    //Constructor
    public OfficeEmployee(String firstName, String lastName, String email, Gender gender, double salary,
                          EmployeePosition position, String title) {
        // Call parent's constructor
        super(firstName, lastName, email, gender, salary, position);
        // Set fields values
        this.title = title;
    }

    /**
     * Set the way how convert objects of Player type to string
     *
     * @return String representation of Player object
     */
    @Override
    public String toString() {
        // Call parent's toString method and add player specific values
        return super.toString() + ", position: " + position;
    }

    /**
     *
     */
    public void print(int index, String indent) {
        System.out.println("  " + indent + index+") " + super.toString() + ", " + title);
    }

    /**
     * Method for generating Developer object with random but appropriate data
     *
     * @return Generated Developer object
     */
    public static OfficeEmployee generate() {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName);
        //Generate employee type
        String title = generateJobTitle();
        // Randomly choose the player position
        EmployeePosition position = Generator.pickFromList(EmployeePosition.class);
        //Generate salary
        double salary = Generator.generateSalary(position);

        // Creating and returning Developer object
        return new OfficeEmployee(firstName, lastName, email, gender, salary, position, title);
    }

    public static String generateJobTitle() {
        return possibleOfficeEmployeeJobTitles[new Random().nextInt(possibleOfficeEmployeeJobTitles.length)];
    }
    private static final String[] possibleOfficeEmployeeJobTitles =
            new String[]{"Clerk", "White-collar", "Office rat", "Office plankton", "Salary person", "Corporate stooge", "Cubicle mouse", "Desk jockey", "Office monkey", "Dweller of a cubicle farm", "Lemming", "Cubicle dweller", "Pin-striped worker"};

}
