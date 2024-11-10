package CA_2.Utils;

import CA_2.Models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static CA_2.Utils.InputUtilities.*;
import static CA_2.Utils.InputUtilities.selectFromList;

public class CompanyHelper {
    public static Department addDepartment(Company company) {

        int selectedValue = -1;
        boolean isValidInput;
        Scanner scanner = new Scanner(System.in);
        List<DepartmentDefaultType> availableDepartments = getAvailableDepartments(company);

        do {
            do {
                System.out.println("Select what department you want to add:");

                int i = 1;
                System.out.println(" " + i++ + ") Create a new custom department");

                if (!availableDepartments.isEmpty()) {
                    System.out.println("or select one of default departments:");

                    for (DepartmentDefaultType dep : availableDepartments) {
                        System.out.println(" " + i++ + ") " + dep.toString());
                    }
                }

                isValidInput = false;
                if (scanner.hasNextInt()) {
                    selectedValue = scanner.nextInt();
                    isValidInput = selectedValue > 0
                            && selectedValue <= availableDepartments.size() + 1;
                }
                scanner.nextLine();

                if (!isValidInput) {
                    System.err.println("Invalid input.");
                    System.err.println("try again");
                }

            } while (!isValidInput);

            if (selectedValue == 1) {
                do {
                    System.out.println("Enter the name of a new department:");

                    String departmentName = scanner.nextLine();

                    if (canAddDepartment(company, departmentName)) {
                        Department resDep = new CustomDepartment(departmentName);
                        company.departments.add(resDep);
                        System.out.println("Department \"" + departmentName + "\" has been added to company " + company.getName());

                        return resDep;
                    }

                    System.err.println("Department with name \"" + departmentName + "\" already exists");
                    System.err.println("try again");

                } while (true);

            } else {
                int index = selectedValue - 2;
                String departmentName = availableDepartments.get(index).toString();

                if (canAddDepartment(company, departmentName)) {
                    Department resDep = new PrecreatedDepartment(availableDepartments.get(index));
                    company.departments.add(resDep);
                    System.out.println("Department \"" + departmentName + "\" has been added to company " + company.getName());

                    return resDep;
                }

                System.err.println("Department with name \"" + departmentName + "\" already exists");
                System.err.println("try again");
            }

        } while (true);
    }

    public static boolean canAddDepartment(Company company, String newDepartmentName) {
        for (Department dep : company.departments) {
            if (dep.getName().equals(newDepartmentName)) {
                return false;
            }
        }

        return true;
    }

    public static List<DepartmentDefaultType> getAvailableDepartments(Company company) {
        ArrayList<DepartmentDefaultType> result = new ArrayList<>(Arrays.asList(DepartmentDefaultType.values()));

        for (Department dep : company.departments) {
            if (dep.getType() == DepartmentBaseType.DEFAULT) {
                result.remove(((PrecreatedDepartment) dep).GetSelectedDepartment());
            }
        }

        return result;
    }

    public static void printCompany(Company company) {

        System.out.println("\n========= Printing the company ===========");

        System.out.println("Company name: " + company.getName());

        if (company.departments.isEmpty()) {
            System.out.println("Company doesn't have any department");
        } else {
            System.out.println("Departments:");
            int i = 1;
            for (Department dep : company.departments) {
                System.out.println(" " + i++ + ") " + dep);
            }
        }

        System.out.println("============= End of print ===============\n");
    }

    /**
     * Method for input all data for creating a manager
     */
    public static Manager addManager(Company company) {
        Scanner scanner = new Scanner(System.in);
        //Select department to add a new manager
        Department selectedDepartment = null;

        System.out.println("Would you like to add a new manager to:");
        System.out.println("  1) the existing department");
        System.out.println("  2) a new department");

        int choice;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Enter 1 or 2.");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);

        scanner.nextLine();

        if (choice == 1) {
            List<Department> departments = company.departments;
            if (departments.isEmpty()) {
                System.out.println("There's no existing departments. Create a new department");
                choice = 2;
            } else {
                selectedDepartment =
                        InputUtilities.selectFromList("\nSelect a department from the list: ",
                                company.departments.toArray(new Department[0]), Department::getName);
            }
        }

        if (choice == 2) {
            selectedDepartment = addDepartment(company);
        }

        List<ManagerType> availableManagerTypes = getAvailableManagerTypes(selectedDepartment);

        // Select manager type
        ManagerType managerType = selectFromList("* Select manager's type",
                availableManagerTypes.toArray(new ManagerType[0]),
                ManagerType::toString);

        do {
            if (canAddManager(selectedDepartment, managerType)) {
                // Input first name
                String firstName = askUserForWord("* Enter manager's first name:");
                // Input last name
                String lastName = askUserForWord("* Enter manager's last name:");
                // Input gender
                Gender gender = selectFromList("* Select the gender:  (* - required)", Gender.class);
                // Input email name
                String email = askUserForEmail("Enter manager's email:");
                Manager newManager = new Manager(firstName, lastName, email, gender, managerType, selectedDepartment);
                selectedDepartment.managers.add(newManager);
                System.out.println("Manager \"" + managerType + "\" has been added to the department " + selectedDepartment.getName());

                return newManager;
            }

            System.err.println("Manager \"" + managerType + "\" already exists");
            System.err.println("try again");
            // Select manager type
            managerType = selectFromList("* Select manager's type", ManagerType.class);

        } while (true);
    }

    public static boolean canAddManager(Department department, ManagerType newManagerType) {
        for (Manager manager : department.managers) {
            if (manager.managerType.equals(newManagerType)) {
                return false;
            }
        }

        return true;
    }

    public static List<ManagerType> getAvailableManagerTypes(Department department) {
        ArrayList<ManagerType> result = new ArrayList<>(Arrays.asList(ManagerType.values()));

        for (Manager manager : department.managers) {
            for (ManagerType mt : ManagerType.values()) {
                if (manager.managerType == mt) {
                    result.remove((manager).managerType);
                }
            }
        }

        return result;
    }
}
