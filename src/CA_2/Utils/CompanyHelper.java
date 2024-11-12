package CA_2.Utils;

import CA_2.Models.*;
import CA_2.UI.Menu;

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

/*    public static void printCompany(Company company) {

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
    }*/

    /**
     * Method for input all data for creating a manager
     */
    public static void addManager(Company company) {
        //Select department to add a new manager
        Department selectedDepartment = getSelectedDepartmentToAddObj(company);

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
                // Input email
                String email = askUserForEmail("Enter manager's email:");
                double salary = askUserForDouble("Enter manager's salary:");
                Manager newManager = new Manager(firstName, lastName, email, gender, salary, managerType, selectedDepartment);
                selectedDepartment.managers.add(newManager);
                System.out.println("Manager \"" + managerType + "\" has been added to the department " + selectedDepartment.getName());

                return;
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


    /**
     * Method for input all data for creating a developer
     */
    public static Developer addDeveloper(Company company) {
        //Select department to add a new developer
        Department selectedDepartment = getSelectedDepartmentToAddObj(company);

        DeveloperType developerType = selectFromList("* Select developer's type", DeveloperType.class);

        List<EmployeePosition> availableEmployeePositions = getAvailableEmployeePositions(selectedDepartment);

        // Select employee position
        EmployeePosition developerPosition = selectFromList("* Select developer's position",
                availableEmployeePositions.toArray(new EmployeePosition[0]),
                EmployeePosition::toString);

        do {
            if (canAddDeveloper(selectedDepartment, developerPosition)) {
                // Input first name
                String firstName = askUserForWord("* Enter developer's first name:");
                // Input last name
                String lastName = askUserForWord("* Enter developer's last name:");
                // Input gender
                Gender gender = selectFromList("* Select the gender:  (* - required)", Gender.class);
                // Input email name
                String email = askUserForEmail("Enter developer's email:");
                double salary = askUserForDouble("Enter developer's salary:");
                Developer newDeveloper = new Developer(
                        firstName,
                        lastName,
                        email,
                        gender,
                        salary,
                        developerPosition,
                        developerType,
                        selectedDepartment);
                selectedDepartment.developers.add(newDeveloper);
                System.out.println(
                        "Developer \n"
                                + newDeveloper
                                + "\n has been added to the department "
                                + selectedDepartment.getName()
                );

                return newDeveloper;
            }

            System.err.println(
                    "Developer \""
                            + developerPosition
                            + "\" already exists"
            );
            System.err.println("try again");

        } while (true);
    }

    public static boolean canAddDeveloper(Department department, EmployeePosition newEmployeePosition) {
        for (Developer developer : department.developers) {
            if (developer.position.equals(newEmployeePosition)) {
                return false;
            }
        }

        return true;
    }

    public static List<EmployeePosition> getAvailableEmployeePositions(Department department) {
        ArrayList<EmployeePosition> result = new ArrayList<>(Arrays.asList(EmployeePosition.values()));

        for (Developer developer : department.developers) {
            for (EmployeePosition ep : EmployeePosition.values()) {
                if (developer.position == ep) {
                    result.remove((developer).position);
                }
            }
        }

        return result;
    }

    private static Department getSelectedDepartmentToAddObj(Company company) {
        Menu.selectDepartmentToAddObjOptions choice =
                InputUtilities.selectFromList("Would you like to add a new developer to:",
                        Menu.selectDepartmentToAddObjOptions.class);

        switch (choice) {
            case EXISTING: {
                List<Department> departments = company.departments;

                if (departments.isEmpty()) {
                    System.out.println("There's no existing departments. Create a new department");
                    return addDepartment(company);
                } else {
                    return InputUtilities.selectFromList("\nSelect a department from the list: ",
                            company.departments.toArray(new Department[0]), Department::getName);
                }
            }
            case NEW:
            default: {
                return addDepartment(company);
            }
        }
    }
}
