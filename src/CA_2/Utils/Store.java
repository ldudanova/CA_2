package CA_2.Utils;

// Importing the Department and Person classes from the Models package
import CA_2.Models.Department;
import CA_2.Models.Person;

// Importing ArrayList from java.util package for dynamic array functionality
import java.util.ArrayList;

/**
 * Singleton class for storing data
 * in memory "database".
 * This class acts as an in-memory storage for data related to people (employees and managers)
 * and departments. Using a singleton-like design, it holds static lists of Person and Department
 * instances, making the data accessible globally across the application.
 */
public class Store {

    // Static ArrayList to store instances of Person, representing all employees and managers in memory
    public static ArrayList<Person> people = new ArrayList<>();

    // Static ArrayList to store instances of Department, representing all departments in memory
    public static ArrayList<Department> departments = new ArrayList<>();

    /**
     * Method to convert the ArrayList of departments into a standard array of Department objects.
     * This method is useful for cases where a fixed-size array is required, such as for certain
     * library functions or when interacting with APIs that require arrays rather than collections.
     *
     * @return an array of Department objects representing all departments currently stored in the ArrayList
     */
    public static Department[] getDepartmentArray() {
        // Initialize a new array of Department with the size of the departments list
        Department[] array = new Department[departments.size()];

        // Convert the departments ArrayList into an array and store it in 'array'
        array = departments.toArray(array);

        // Return the array of departments
        return array;
    }
}
