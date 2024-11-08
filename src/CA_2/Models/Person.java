package CA_2.Models;

/**
 * Class for storing common information about person like:
 * First name, Last name, Email
 * Implements Comparable interface for being able to sort objects of Person type and descendants
 */
public class Person implements Comparable<Person> {
    // Variable for person's first name
    public String firstName;
    // Variable for person's last name
    public String lastName;

    // Variable for person's email
    public String email;
    // Variable for person's gender
    public Gender gender;

    public byte age;

    // Constructor
    public Person(String firstName, String lastName, String email, Gender gender, byte age) {
        // Set fields
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Set the way how convert objects of Person type to string
     *
     * @return String representation of Person object
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " [" + this.getClass().getSimpleName() + "], " +
                ((email != null && !email.isEmpty()) ? email : "no email") + ", " + gender + age;
    }

    /**
     * Method for comparison with another Person
     * Compare by string representation of objects
     *
     * @param o the object to be compared.
     * @return the value 0 if the string representation of objects are equals;
     * a value less than 0 if this object string representation is lexicographically less than the string representation of argument object;
     * and a value greater than 0 if this object string representation is lexicographically greater than the string representation of argument object.
     */
    @Override
    public int compareTo(Person o) {
        return this.toString().compareTo(o.toString());
    }
}
