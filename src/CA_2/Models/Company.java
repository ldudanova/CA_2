package CA_2.Models;

import CA_2.Utils.Generator;
import CA_2.Utils.Store;

import java.util.ArrayList;

/**
 * The Company class represents a company entity within the application, holding
 * essential data about the company, such as its name and associated departments.
 * <p>
 * This class provides key functionality and structure for creating, managing,
 * and retrieving companies in the system. It can be used by administrators,
 * data managers, and automated systems within the application to establish a
 * basic organizational structure.
 */
public class Company {
    public String name; // Stores the company's name.
    public ArrayList<Department> departments; // Stores the list of departments within the company.

    public String getName() {
        return name;
    }

    /**
     * Constructor for creating a Company object with a specified name.
     * <p>
     * Purpose:
     * - To initialize a new company with a unique name and prepare it to
     * have departments added.
     * - Provides a foundation for establishing the company's organizational
     * structure within the system.
     * <p>
     * Use Case:
     * - This constructor is essential for creating new companies, which can
     * then be customized by adding departments.
     *
     * @param name The name of the company.
     */
    public Company(String name) {
        this.name = name; // Sets the company name to the provided value.
        departments = new ArrayList<>(); // Initializes an empty department list, allowing departments to be added later.
    }

    /**
     * Provides a string representation of the Company object.
     * <p>
     * Purpose:
     * - Overriding the toString() method allows for a clear, simple representation
     * of a Company object when printed or converted to a string.
     * - Specifically returns the company's name, which is often the most
     * relevant identifier.
     * <p>
     * Use Case:
     * - Useful for logging, debugging, displaying a list of companies, or
     * anytime a concise identifier for the company is needed.
     *
     * @return The name of the company.
     */
    @Override
    public String toString() {
        return name; // Returns only the company's name for clarity and simplicity.
    }

    /**
     * Generates a Company object with a random but appropriate name.
     * <p>
     * Purpose:
     * - Automates the creation of companies with pre-defined or randomly
     * generated names, saving users time in generating names manually.
     * - Useful for testing, creating placeholder companies, and scenarios
     * where multiple companies need to be generated quickly for testing
     * or simulation purposes.
     * <p>
     * Use Case:
     * - Used by developers and testers for creating sample data. It can
     * also be used by automated systems that initialize company data in
     * bulk or in development environments.
     *
     * @return A new Company object with a randomly generated name.
     */
    public static Company generate() {
        // Calls an external utility to generate a unique, random company name.
        String name = Generator.generateCompanyName();


        return new Company(name); // Returns a new Company object initialized with the generated name.
    }

    /**
     * Searches for a Company object by its name within a list of companies.
     * <p>
     * Purpose:
     * - Provides a way to retrieve a specific company by its name, which is
     * a key attribute when identifying companies.
     * - Helps maintain efficiency by enabling a quick search for a particular
     * company, essential in scenarios where users need to access or modify
     * data for specific companies.
     * <p>
     * Use Case:
     * - Useful for administrators, users, and systems needing to quickly
     * locate a specific company by its name.
     * - Helps in data management tasks where a company needs to be accessed
     * individually, for instance, when adding departments or updating records.
     *
     * @param companies List of Company objects to search within.
     * @param name      The name of the company to find.
     * @return The Company object with the specified name, or null if not found.
     */
    public static Company findCompanyByName(ArrayList<Company> companies, String name) {
        // Loops through each company in the list to find one with the specified name.
        for (Company company : companies) {
            // Checks for a name match, ignoring case to make the search more flexible.
            if (company.name.equalsIgnoreCase(name)) {
                return company; // Returns the matching Company object if found.
            }
        }
        return null; // Returns null if no company with the specified name is found.
    }

    /**
     *
     */
    public void print(int index, String indent) {
        System.out.println("====================================");
        System.out.println();
        System.out.println(indent + index + ") " + this.getName());
        if (this.departments.isEmpty()) {
            System.out.println(indent + "  Departments: No departments.");
        } else {
            System.out.println(indent + "  Departments: ");
            for (int i = 0; i < this.departments.size(); i++) {
                Department department = this.departments.get(i);
                department.print(i + 1, indent + "    ");
            }
        }
    }

    public Department getOrCreateDepartment(String departmentName) {
        for (Department department : this.departments) {
            if (department
                    .getName()
                    .equalsIgnoreCase(departmentName)) {
                return department;
            }
        }
        Department resDepartment = new CustomDepartment(departmentName);
        this.departments.add(resDepartment);
        return resDepartment;
    }
}
