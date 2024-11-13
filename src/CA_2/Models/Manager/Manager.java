package CA_2.Models.Manager;

import CA_2.Models.Gender;
import CA_2.Models.Person;
import CA_2.Utils.Generator;

/**
 * Class for storing manager specified information
 * Inherited from Person class
 */
public class Manager extends Person {
    // Variable for manager type: value is one of ManagerType enum values
    public ManagerType managerType;
    public double salary;
    public String email;

    // Constructor
    public Manager(String firstName,
                   String lastName,
                   String email,
                   Gender gender,
                   double salary,
                   ManagerType managerType) {
        // Call parent's constructor
        super(firstName, lastName, gender);

        // Set fields values
        this.managerType = managerType;
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
        return super.toString() + ", " + managerType;
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
    public static Manager generate(String companyName) {
        // Randomly choose the gender
        Gender gender = Generator.pickFromList(Gender.class);
        // Randomly choose the first name from existing names
        String firstName = Generator.getFirstName(gender);
        // Randomly choose the last name from existing last lames
        String lastName = Generator.getLastName();
        // Generate an email based on first and last names
        String email = Generator.generateEmail(firstName, lastName, companyName);

        // Randomly choose the manager type
        ManagerType managerType = Generator.pickFromList(ManagerType.class);
        double salary = Generator.generateSalary(managerType);

        // Creating and returning Manager object
        return new Manager(
                firstName,
                lastName,
                email,
                gender,
                salary,
                managerType);
    }
}
