package CA_2.Utils;

// Importing the Company, DepartmentBase, and Person classes from the Models package
import CA_2.Models.Company;
import CA_2.Models.Department.Department;
import CA_2.Models.Person;

// Importing ArrayList from java.util package for dynamic array functionality
import java.util.ArrayList;

/**
 * Acts as a data warehouse for managing company employees, departments,
 * and other related information.
 * This class provides centralised static lists.
 * that contain instances of the Company, Person, and DepartmentBase classes.
 * <p>
 * Purpose:
 * - Centralises all data management within a single class.
 * - Provides consistent access to all data in a programme.
 * - Provides organised storage of data.
 * - Provides data retrieval for employee and department related transactions.
 * <p>
 * Uses:
 * - This class is important for programme functionality that requires access to employees, departments or companies.
 */
public class Store {

    /**
     * Static list for storing company instances, representing all companies in memory.
     * Purpose:
     * - Provides centralised storage of all objects of type `Company`.
     * - Allows quick access to the list of companies when needed.
     * <p>
     * Usage:
     * - Can be used when referring to functions,
     * that need to access or modify company information.
     */
    public static ArrayList<Company> companies = new ArrayList<>();

    public static Company getOrCreateCompany(String companyName) {
        for (int i = 0; i < Store.companies.size(); i++) {
            if (Store.companies.get(i)
                    .getName()
                    .equalsIgnoreCase(companyName)) {
                return Store.companies.get(i);
            }
        }
        Company resCompany = new Company(companyName);
        Store.companies.add(resCompany);
        return resCompany;
    }

    /**
     * A static list to store in-memory Person instances that represent all employees and managers.
     * Purpose:
     * - Acts as the primary storage for `Person` objects.
     * - Provides access to employee and manager data.
     * - Simplifies employee management tasks such as finding specific
     * people or managing roles within departments.
     *
     * Usage:
     * - Used in the program when retrieving employee data to sort,
     * search, and display lists of employees.
     */
    public static ArrayList<Person> people = new ArrayList<>();
}
