package CA_2.Models;

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
            System.out.println();
        }
    }

    // List of department's employees
    public ArrayList<Developer> developers = new ArrayList<>();
    // List of department's managers
    public ArrayList<Manager> managers = new ArrayList<>();

    /**
     * Set the way how convert objects of Department type to string
     *
     * @return String representation of Department object
     */

    @Override
    public String toString() {
        return getName() + (getType() == DepartmentBaseType.CUSTOM ? " (Custom)" : "");
    }
}
