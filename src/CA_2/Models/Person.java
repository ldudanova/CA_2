package CA_2.Models;

/**
 * Class representing a person within the company.
 *
 * The `Person` class serves as a foundational model for managing information about individuals
 * associated with the company, including employees, managers, and possibly clients. This class
 * defines common attributes like first name, last name, email, and gender, which are essential
 * for storing and displaying basic personal information. By implementing `Comparable`, this class
 * allows for sorting operations on lists of people, which is valuable for organizing and managing
 * employee records in a structured way.
 */
public class Person implements Comparable<Person> {

    // Variable for the person's first name, enabling identification and personalization
    public String firstName;

    // Variable for the person's last name, essential for identification and differentiation
    public String lastName;

    // Variable for the person's email, used for contact information and communication purposes
//    public String email;

    // Enum variable for the person's gender, supporting consistent and standardized gender data
    public Gender gender;

    /**
     * Constructor for creating a `Person` object.
     *
     * This constructor initializes the `Person` object with the provided first name, last name,
     * email, and gender values. By defining these fields at the time of instantiation, we ensure
     * that all `Person` objects carry essential, identifiable information. This is particularly useful
     * for managing employee records where accurate personal data is needed for effective HR processes.
     *
     * @param firstName Person's first name
     * @param lastName Person's last name
//     * @param email Person's email address
     * @param gender Person's gender
     */
    public Person(String firstName, String lastName, Gender gender) {
        // Set fields with provided values
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    /**
     * Provides a string representation of the `Person` object.
     *
     * This `toString` method is overridden to return a readable string representation of the
     * `Person` object, combining the first name, last name, class type, email, and gender.
     * The string format improves user interface readability by providing clear details on each person
     * in the program. This is especially useful when displaying employee information in lists or logs.
     *
     * @return A formatted string containing the `Person`'s first name, last name, email, and gender
     */
    @Override
    public String toString() {
        return firstName
                + " "
                + lastName
                + " ["
                + this.getClass().getSimpleName()
                + "], "
                + gender;
    }

    /**
     * Compares the current `Person` object to another `Person` object.
     *
     * This `compareTo` method enables comparison between two `Person` objects based on their
     * string representations, making it possible to sort lists of people alphabetically.
     * Sorting by string representation (including name and other attributes) ensures that employees
     * can be organized in a user-friendly order, which is beneficial for viewing and managing employee data.
     *
     * @param o Another `Person` object to compare with
     * @return 0 if the string representations are equal; a negative value if this `Person` is
     *         lexicographically less than the other `Person`; a positive value if greater
     */
    @Override
    public int compareTo(Person o) {
        return this.toString().compareTo(o.toString());
    }
}
