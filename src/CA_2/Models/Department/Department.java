package CA_2.Models.Department;

import CA_2.Models.Developer.Developer;
import CA_2.Models.Manager.Manager;
import CA_2.Models.OfficeEmployee;
import CA_2.Models.Person;

import java.util.ArrayList;

/**
 * The Department class serves as an abstract base for creating and managing departments within a company.
 *
 * This class includes methods to retrieve department information, print detailed department data, and manage
 * lists of employees categorized by roles (managers, developers, and office employees). Subclasses must implement
 * the abstract methods to define specific department types, such as PrecreatedDepartment and CustomDepartment.
 */
public abstract class Department {

    /**
     * Retrieves the department's name.
     *
     * This abstract method requires subclasses to provide a name, helping distinguish departments
     * based on their function or purpose.
     *
     * @return The name of the department.
     */
    public abstract String getName();

    /**
     * Returns the type of department base, indicating if it is custom or default.
     *
     * This abstract method helps applications differentiate between pre-defined and user-created departments.
     *
     * @return The DepartmentBaseType of the department.
     */
    public abstract DepartmentBaseType getType();

    /**
     * Prints detailed information about the department, including employees by role.
     *
     * This method organizes and displays department information in a structured format, making it easier to
     * understand the department's hierarchy and personnel. It prints the department's name and lists managers,
     * developers, and office employees, indicating if any categories are empty.
     *
     * @param index  The index of the department in a list.
     * @param indent The indentation for structured display.
     */
    public void print(int index, String indent) {
        System.out.println(indent + index + ") " + this.getName());
        //Print list of managers
        if (this.getManagers().isEmpty()) {
            System.out.println(indent + "  Managers: No managers.");
        } else {
            System.out.println(indent + "  Managers: ");
            for (int i = 0; i < this.getManagers().size(); i++) {
                Manager manager = this.getManagers().get(i);
                manager.print(i + 1, indent + "  ");
            }
        }

        //Print list of developers
        if (this.developers.isEmpty()) {
            System.out.println(indent + "  Developers: No developers.");
        } else {
            System.out.println(indent + "  Developers: ");
            for (int i = 0; i < this.developers.size(); i++) {
                Developer developer = this.developers.get(i);
                developer.print(i + 1, indent + "  ");
            }
        }

        //Print list of office employees
        if (this.officeEmployees.isEmpty()) {
            System.out.println(indent + "  Office employees: No office employees.");
        } else {
            System.out.println(indent + "  Office employees: ");
            for (int i = 0; i < this.officeEmployees.size(); i++) {
                OfficeEmployee officeEmployee = this.officeEmployees.get(i);
                officeEmployee.print(i + 1, indent + "  ");
            }
        }
        System.out.println();
    }

    /**
     * Stores the department's developers, which is final as it should not be changed directly.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getDevelopers() method.
     */
    private final ArrayList<Developer> developers = new ArrayList<>();

    /**
     * Stores the department's managers, which is final as it should not be changed directly.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getManagers() method.
     */
    private final ArrayList<Manager> managers = new ArrayList<>();

    /**
     * Stores the department's office employee, which is final as it should not be changed directly.
     * Declared private to prevent direct external modification, ensuring data consistency.
     * It is accessed via the public getOfficeEmployee() method.
     */
    private final ArrayList<OfficeEmployee> officeEmployees = new ArrayList<>();

    /**
     * Returns a string representation of the department.
     *
     * This method calls the `getName` method, allowing departments to display their name when referenced in print
     * statements or logs.
     *
     * @return The name of the department.
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Retrieves the developers of the department.
     *
     * @return the department's developers.
     */
    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    /**
     * Retrieves the managers of the department.
     *
     * @return the department's managers.
     */
    public ArrayList<Manager> getManagers() {
        return managers;
    }

    /**
     * Retrieves the office employees of the department.
     *
     * @return the department's office employees.
     */
    public ArrayList<OfficeEmployee> getOfficeEmployees() {
        return officeEmployees;
    }

    /**
     * Retrieves the all employees of the department.
     *
     * @return the people who work in the department.
     */
    public ArrayList<Person> getAllPeople() {
        ArrayList<Person> people = new ArrayList<>(getManagers());
        people.addAll(getDevelopers());
        people.addAll(getOfficeEmployees());
        return people;
    }

    /**
     * Adds a person to the department, categorizing them by role.
     *
     * This method checks the role of the person and adds them to the appropriate list. If the role is unrecognized,
     * an exception is thrown.
     *
     * @param person The person to add to the department.
     */
    public void addPerson(Person person) {
        if (person instanceof Manager) {
            this.managers.add((Manager) person);
            return;
        }
        if (person instanceof Developer) {
            this.developers.add((Developer) person);
            return;
        }
        if (person instanceof OfficeEmployee) {
            this.officeEmployees.add((OfficeEmployee) person);
            return;
        }
        throw new RuntimeException("Unknown person type");
    }
}
