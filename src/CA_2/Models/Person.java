package CA_2.Models;

/**
 * Class representing a person within the company.
 *
 * The `Person` class serves as a foundational model for managing information about individuals
 * associated with the company, including office employees, managers, and developers.
 * This class defines common attributes like first name, last name, email, and gender, which are essential
 * for storing and displaying basic personal information.
 * By implementing `Comparable`, it enables sorting,
 * which is beneficial for managing lists of individuals in a structured order.
 */
public class Person implements Comparable<Person> {

     /**
     * Stores the person's first name, which is final as it should not change after the Person is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getFirstName() method.
     */
    private final String firstName;

    /**
     * Stores the person's last name, which is final as it should not change after the Person is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getLastName() method.
     */
    private final String lastName;

    /**
     * Enum variable for the person's gender, which is final as it should not change after the Person is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getGender() method.
     */
    private final Gender gender;

    //START Class getters
    /**
     * Retrieves the first name of the person.
     *
     * @return the person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return the person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Retrieves the gender of the person.
     *
     * @return the person's gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Constructor for creating a `Person` object.
     *
     * This constructor initializes the `Person` object with the provided first name, last name,
     * and gender values. By defining these fields at the time of instantiation, we ensure
     * that all `Person` objects carry essential, identifiable information. This is particularly useful
     * for managing employee records where accurate personal data is needed for effective HR processes.
     *
     * @param firstName Person's first name
     * @param lastName Person's last name
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
     * `Person` object, combining the first name, last name, class type, and gender.
     * The string format improves user interface readability by providing clear details on each person
     * in the program. This is especially useful when displaying employee information in lists.
     *
     * @return A formatted string containing the `Person`'s first name, last name, and gender
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
