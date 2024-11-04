package CA_2.Models;

import java.util.ArrayList;

/**
 * Class with department data
 */
public class Department {
    // Team name
    public String name;

    // List of team's players
    public ArrayList<Employee> employees;
    // List of team's coaches
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
