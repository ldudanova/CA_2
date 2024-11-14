package CA_2.Models;

import CA_2.Models.Department.CustomDepartment;
import CA_2.Models.Department.Department;
import CA_2.Models.Department.DepartmentDefaultType;
import CA_2.Models.Department.PrecreatedDepartment;
import CA_2.Utils.Generator;
import CA_2.Utils.Helper;
import CA_2.Utils.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * The Company class represents a company entity within the application, holding
 * essential data about the company, such as its name and associated departments with employees.
 *
 * This class provides key functionality and structure for creating, managing,
 * and retrieving companies in the system. It can be used by administrators,
 * data managers, and automated systems within the application to establish a
 * basic organizational structure.
 */
public class Company {

    /**
     * Stores the company's name, which is final as it should not change after the company is created.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getName() method.
     */
    private final String name;

    /**
     * Stores the list of departments within the company.
     * Marked as private to encapsulate the list and
     * ensure only controlled modifications through provided methods.
     * Accessed via getDepartments().
     */
    private final ArrayList<Department> departments; // Stores the list of departments within the company.

    //START class getters

    /**
     * Retrieves the name of the company.
     *
     * @return the company's name.
     */
    public String getName() {
        return name;
    }


    /**
     * Retrieves the list of departments in the company.
     *
     * @return an ArrayList of Department objects representing each department.
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * Searches for a department with the specified name.
     * If no such department exists, creates a new department
     * with that name and adds it to the company's department list.
     *
     * Purpose:
     * - To ensure that a department with the specified name exists
     * and can be easily retrieved or created.
     *
     * Use Case:
     * - This method is useful for dynamically managing departments as the company grows.
     *
     * @param departmentName the name of the department to search for or create.
     * @return the existing or newly created Department.
     */
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


    /**
     * Searches for a department with the specified type.
     * If there's no such department, it creates a new one
     * based on the provided DepartmentDefaultType and adds it to the company's departments.
     *
     * Purpose:
     * - To manage departments by type,
     * allowing a standardized creation of departments as per the department type.
     *
     * Use Case:
     * - Useful for creating departments based on predefined types and adding them to the company.
     *
     * @param departmentType the predefined type of the department to search for or create.
     * @return the existing or newly created Department.
     */
    public Department getOrCreateDepartment(DepartmentDefaultType departmentType) {
        for (Department department : this.departments) {
            if (department
                    .getName()
                    .equalsIgnoreCase(departmentType.toString())) {
                return department;
            }
        }
        Department resDepartment = new PrecreatedDepartment(departmentType);
        this.departments.add(resDepartment);
        return resDepartment;
    }

    /**
     * Extracts a list of all non-IT departments.
     *
     * Purpose:
     * - To allow easy filtering of departments,
     * separating IT from other departments for specific operations.
     *
     * Use Case:
     * - Manage non-IT departments exclusively;
     * - Display non-IT departments exclusively;
     * - Perform operations with non-IT departments exclusively
     *  (e.g. adding employees to any department except ID Department).
     *
     * @return a List of Department objects that are not IT.
     */
    public List<Department> getNonITDepartments() {
        return this.departments
                .stream()
                .filter(department -> !department.getName().equalsIgnoreCase(DepartmentDefaultType.IT.toString()))
                .collect(Collectors.toList());
    }

    //END Class getters

    /**
     * Constructor for creating a Company object with a specified name.
     *
     * Purpose:
     * - To initialize a new company with a unique name and prepare it to
     * have departments added.
     * - Provides a foundation for establishing the company's organizational
     * structure within the system.
     *
     * Use Case:
     * - This constructor is essential for creating new companies.
     *
     * @param name The name of the company.
     */
    public Company(String name) {
        this.name = name; // Sets the company name to the provided value.
        departments = new ArrayList<>(); // Initializes an empty department list, allowing departments to be added later.
    }

    /**
     * Method toString provides a string representation of the Company object.
     *
     * Purpose:
     * - Overriding the toString() method allows for a clear, simple representation
     * of a Company object when printed or converted to a string.
     * - Specifically returns the company's name, which is often the most
     * relevant identifier.
     *
     * Use Case:
     * - Print object information.
     *
     * @return The name of the company.
     */
    @Override
    public String toString() {
        return getName(); // Returns only the company's name for clarity and simplicity.
    }

    /**
     * Generates a Company object with a random but appropriate name.
     *
     * Purpose:
     * - Automates the creation of companies with pre-defined or randomly
     * generated names, saving users time in generating names manually.
     * - Useful for testing, creating placeholder companies, and scenarios
     * where multiple companies need to be generated quickly for testing
     * or simulation purposes.
     *
     * Use Case:
     * - Can be used by developers and testers for creating sample data.
     * - Can be used by automated systems that initialize company data in
     * bulk or in development environments.
     *
     * @return A new Company object with a randomly generated name.
     */
    public static Company generate() {
        // Calls an external utility to generate a unique, random company name.
        String name;
        name = generateName();

        boolean isUniqueName = false;

        //Check that there are some companies in the store
        if (!Store.companies.isEmpty()) {
            while (!isUniqueName) {
                for (int i = 0; i < Store.companies.size(); i++) {
                    //Check that the name is unique
                    if (Store.companies.get(i)
                            .getName()
                            .equalsIgnoreCase(name)) {
                        name = generateName();
                        isUniqueName = false;
                        break;
                    } else {
                        isUniqueName = true;
                    }
                }
            }
        }

        Company newCompany = new Company(name);
        int randomNumber = new Random().nextInt(10) + 1;

        //Generate random quantity of different objects for the company
        for (int i = 0; i <= randomNumber; i++) {
            //Generate developer
            Helper.generateDeveloperAndAddDeveloperToITDepartment(newCompany);
            //Generate dep and manager
            Helper.generateManagerAndAddManagerToDepartment(newCompany);
            //Generate nonITDep and Office employee
            Helper.generateOfficeEmployeeAndAddOfficeEmployeeToNonITDepartment(newCompany);
        }

        return newCompany;
    }

    /**
     * Generates a name for the company
     * by combining elements from predefined arrays.
     *
     * @return a randomly generated name of type String for a new company.
     */
    public static String generateName() {
        Random random = new Random();
        int number = random.nextInt(10); //
        String name;

        if (number % 2 == 0) {
            name = companyPredicate[random.nextInt(companyPredicate.length)];
            return name + "-" + Generator.generateUpperCaseString(3);
        } else {
            name = companySuffix[random.nextInt(companySuffix.length)];
            return Generator.generateUpperCaseString(3) + "-" + name;
        }
    }

    /**
     * Creates a new Company with the specified name
     * and adds it to the Store.
     *
     * @param companyName the name of the new company.
     */
    public static void create(String companyName) {
        Company company = new Company(companyName);
        Store.companies.add(company);
        System.out.println("The company " + company.name + " was created");
    }


    /**
     * Prints the company's information including its departments.
     *
     * @param index the index of the company.
     * @param indent the indentation to use when printing for clarity.
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


    /**
     * Array with company predicates for generating company names
      */
    private static final String[] companyPredicate =
            new String[]{"I", "IT", "Tech", "Group", "Web", "Dev", "Data", "Net"};

    /**
     * Array with company suffixes for generating company names
     */
    private static final String[] companySuffix =
            new String[]{"IT", "Tech", "Group", "Pro", "Max", "Technologies", "Hub", "Computing", "Development"};

}
