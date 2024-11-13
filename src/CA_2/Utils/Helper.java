package CA_2.Utils;

import CA_2.Models.*;
import CA_2.Models.Department.*;
import CA_2.Models.Developer.Developer;
import CA_2.Models.Developer.DeveloperType;
import CA_2.Models.Employee.EmployeePosition;
import CA_2.Models.Manager.Manager;
import CA_2.Models.Manager.ManagerType;
import CA_2.Models.Menu.selectDepartmentToAddObjOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import static CA_2.Utils.InputUtilities.*;
import static CA_2.Utils.InputUtilities.selectFromList;

public class Helper {
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
                // Input gender
                Gender gender = selectFromList("* Select the gender:  (* - required)", Gender.class);
                // Input first name
                String firstName = askUserForWord("* Enter manager's first name:");
                // Input last name
                String lastName = askUserForWord("* Enter manager's last name:");
                // Input email
                String email = askUserForEmail("Enter manager's email:");
                double salary = askUserForDouble("* Enter manager's salary:");
                Manager newManager = new Manager(firstName, lastName, email, gender, salary, managerType);
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
    public static void addDeveloper(Company company) {
        //Select department to add a new developer
        Department selectedDepartment = getSelectedDepartmentToAddObj(company);

        DeveloperType developerType = selectFromList("* Select developer's type    (* - required)", DeveloperType.class);

        // Select employee position
        EmployeePosition developerPosition = selectFromList("* Select developer's position",
                EmployeePosition.class);

        // Input gender
        Gender gender = selectFromList("* Select the gender: ", Gender.class);
        // Input first name
        String firstName = askUserForWord("* Enter developer's first name:");
        // Input last name
        String lastName = askUserForWord("* Enter developer's last name:");
        // Input email name
        String email = askUserForEmail("Enter developer's email:");
        double salary = askUserForDouble("* Enter developer's salary:");
        Developer newDeveloper = new Developer(
                firstName,
                lastName,
                email,
                gender,
                salary,
                developerPosition,
                developerType);
        selectedDepartment.developers.add(newDeveloper);
        System.out.println(
                "Developer \n"
                        + newDeveloper
                        + "\n has been added to the department "
                        + selectedDepartment.getName()
        );
    }

    /**
     * Method to build a Person object using data from the text file
     *
     * @param firstName
     * @param lastName
     * @param gender
     * @param email
     * @param salary
     * @param position
     * @param jobTitle
     * @return
     */
    public static Person buildPerson(String firstName,
                                     String lastName,
                                     Gender gender,
                                     String email,
                                     Double salary,
                                     EmployeePosition position,
                                     String jobTitle
    ) {
        DeveloperType developerType = null;
        ManagerType managerType = null;
        String officeEmployeeTitle = null;

        if (position != null) {
            DeveloperType[] possibleDevTypes = DeveloperType.class.getEnumConstants();
            boolean isDev = false;
            for (DeveloperType devType : possibleDevTypes) {
                if (devType.toString().equalsIgnoreCase(jobTitle.trim())) {
                    developerType = devType;
                    isDev = true;
                    break;
                }
            }
            if (!isDev) {
                officeEmployeeTitle = jobTitle.trim();
            }
        } else {
            ManagerType[] possibleManagerTypes = ManagerType.class.getEnumConstants();

            for (ManagerType manType : possibleManagerTypes) {
                if (manType.toString().equalsIgnoreCase(jobTitle.trim())) {
                    managerType = manType;
                }
            }

            if (managerType == null) {
                throw new RuntimeException("Unknown job title for manager: " + jobTitle.trim());
            }
        }

        if (managerType != null) {
            return new Manager(
                    firstName,
                    lastName,
                    email,
                    gender,
                    salary,
                    managerType
            );
        }

        if (developerType != null) {
            return new Developer(
                    firstName,
                    lastName,
                    email,
                    gender,
                    salary,
                    position,
                    developerType
            );
        }

        return new OfficeEmployee(
                firstName,
                lastName,
                email,
                gender,
                salary,
                position,
                officeEmployeeTitle
        );
    }

    public static Company getRandomOrGeneratedCompany() {
        if (Store.companies.isEmpty()) {
            Store.companies.add(Company.generate());
        }
        return Store.companies.get(new Random().nextInt(Store.companies.size()));
    }

    public static Developer generateDeveloperAndAddDeveloperToITDepartment(Company company) {
        Developer developer = Developer.generate(company.getName());
        Store.people.add(developer);
        Department ITDep =
                company.getOrCreateDepartment(DepartmentDefaultType.IT.toString());
        ITDep.addPerson(developer);
        return developer;
    }

    public static Manager generateManagerAndAddManagerToDepartment(Company company) {
        Department randomDep =
                company.getOrCreateDepartment(DepartmentDefaultType.getRandomDepartment());
        Manager newManager = Manager.generate(company.getName());
        randomDep.addPerson(newManager);
        return newManager;
    }

    public static OfficeEmployee generateOfficeEmployeeAndAddOfficeEmployeeToNonITDepartment(Company company) {
        Department randomDep;
        List<Department> nonITDepartments = company.getNonITDepartments();
        if (!nonITDepartments.isEmpty()) {
            randomDep = nonITDepartments.get(new Random().nextInt(nonITDepartments.size()));
        } else {
            randomDep = company.getOrCreateDepartment(DepartmentDefaultType.HUMAN_RESOURCES.toString());
        }
        OfficeEmployee newOfficeEmployee = OfficeEmployee.generate(company.getName());
        randomDep.addPerson(newOfficeEmployee);
        return newOfficeEmployee;
    }

    private static Department getSelectedDepartmentToAddObj(Company company) {
        selectDepartmentToAddObjOptions choice =
                InputUtilities.selectFromList("Would you like to add a new developer to:",
                        selectDepartmentToAddObjOptions.class);

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
