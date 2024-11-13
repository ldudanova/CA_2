package CA_2.Models.Department;

import CA_2.Models.Developer.Developer;
import CA_2.Models.Manager.Manager;
import CA_2.Models.OfficeEmployee;
import CA_2.Models.Person;

import java.util.ArrayList;

/**
 * Class with department data
 */
public abstract class Department {
    public abstract String getName();

    public abstract DepartmentBaseType getType();

    public void print(int index, String indent) {
        System.out.println(indent + index + ") " + this.getName());
//        Print list of managers
        if (this.managers.isEmpty()) {
            System.out.println(indent + "  Managers: No managers.");
        } else {
            System.out.println(indent + "  Managers: ");
            for (int i = 0; i < this.managers.size(); i++) {
                Manager manager = this.managers.get(i);
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

    // List of department's employees
    public ArrayList<Developer> developers = new ArrayList<>();
    // List of department's managers
    public ArrayList<Manager> managers = new ArrayList<>();
    public ArrayList<OfficeEmployee> officeEmployees = new ArrayList<>();

    /**
     * Set the way how convert objects of Department type to string
     *
     * @return String representation of Department object
     */

    @Override
    public String toString() {
        return getName();
    }

    public ArrayList<Developer> getDevelopers() {
        return developers;
    }
    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public ArrayList<OfficeEmployee> getOfficeEmployees() {
        return officeEmployees;
    }
    public ArrayList<Person> getAllPeople() {
        ArrayList<Person> people = new ArrayList<>(getManagers());
        people.addAll(getDevelopers());
        people.addAll(getOfficeEmployees());
        return people;
    }

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
