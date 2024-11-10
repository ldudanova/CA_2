package CA_2.Utils;

// Importing the Company, DepartmentBase, and Person classes from the Models package
import CA_2.Models.Company;
import CA_2.Models.Department;
import CA_2.Models.Person;

// Importing ArrayList from java.util package for dynamic array functionality
import java.util.ArrayList;

/**
 * The Store class acts as an in-memory data storage for managing the company's employees, departments,
 * and related information. Using a singleton-like design, this class provides centralized, static lists
 * that hold instances of Company, Person, and DepartmentBase, which can be accessed and modified
 * by other components within the program.
 *
 * Purpose:
 * - Centralizes all data management within a single class, enabling consistent access across the program
 *   without relying on an external database.
 * - Facilitates streamlined storage and retrieval of data for operations related to employee and department
 *   management within the company's organizational structure.
 *
 * Usage:
 * - This class is critical for any functionality within the program that requires access to employees,
 *   departments, or companies.
 */
public class Store {

    /**
     * Static list to store instances of Company, representing all companies in memory.
     * Purpose:
     * - Centralizes storage for all `Company` objects, allowing quick access to the list of companies
     *   when performing company-related operations within the program.
     *
     * Usage:
     * - Accessed by functions that need to retrieve or modify information about companies, such as
     *   assigning departments to a company or iterating over companies to generate reports.
     */
    public static ArrayList<Company> companies = new ArrayList<>();

    /**
     * Static list to store instances of Person, representing all employees and managers in memory.
     * Purpose:
     * - Acts as the main storage for `Person` objects, allowing program-wide access to employee and
     *   manager data. This simplifies tasks related to employee management, such as searching for
     *   specific people or managing roles within departments.
     *
     * Usage:
     * - Used throughout the program when retrieving employee data for tasks like sorting, searching,
     *   and displaying employee lists.
     */
    public static ArrayList<Person> people = new ArrayList<>();

    /**
     * Static list to store instances of DepartmentBase, representing all departments in memory.
     * Purpose:
     * - Stores department data, enabling efficient department management within the program. This
     *   includes department retrieval, adding or removing departments, and assigning employees.
     *
     * Usage:
     * - Accessed by functions that handle department-specific operations, such as assigning employees
     *   to a department or generating department reports.
     */
    public static ArrayList<Department> departments = new ArrayList<>();

    /**
     * Converts the ArrayList of departments into a fixed-size array of DepartmentBase objects.
     *
     * Purpose:
     * - Converts the dynamic list of departments into a fixed-size array, which may be required by
     *   certain functions or libraries that only accept arrays.
     *
     * Usage:
     * - Useful when exporting department data or interacting with specific program components that
     *   require an array structure. This function provides compatibility with operations where
     *   ArrayLists may not be suitable.
     *
     * @return an array of DepartmentBase objects representing all departments currently stored in the ArrayList.
     */
    public static Department[] getDepartmentArray() {
        // Initialize a new array of DepartmentBase with the size of the departments list
        Department[] array = new Department[departments.size()];

        // Convert the departments ArrayList into an array and store it in 'array'
        array = departments.toArray(array);

        // Return the array of departments
        return array;
    }
}
