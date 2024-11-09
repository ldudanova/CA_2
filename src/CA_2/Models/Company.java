package CA_2.Models;

import CA_2.Utils.Generator;

import java.util.ArrayList;

public class Company {
    public String name;
    public ArrayList<DepartmentBase> departments;

    // Constructor
    public Company(String name) {
        // Set the name
        this.name = name;

        // Create empty lists
        departments = new ArrayList<>();
    }

    /**
     * Set the way how convert objects of Company type to string
     *
     * @return String representation of Company object
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Method for generating Company object with random but appropriate data
     *
     * @return Generated Company object
     */
    public static Company generate() {
        String name = Generator.generateCompanyName();

        return new Company(name);
    }
}
