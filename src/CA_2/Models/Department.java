package CA_2.Models;

import java.util.ArrayList;

/**
 * Class with department data
 */
public class Department {
    // Department name
    public String name;

    // List of department's employees
    public ArrayList<Employee> employees;
    // List of department's managers
    public ArrayList<Manager> managers;

    // Constructor
    public Department(String name) {
        // Set the name
        this.name = name;

        // Create empty lists
        employees = new ArrayList<>();
        managers = new ArrayList<>();
    }

    /**
     * Set the way how convert objects of Department type to string
     *
     * @return String representation of Department object
     */
    @Override
    public String toString() {
        return name;
    }
}
