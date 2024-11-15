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
    /**
     * Method adds a new department to the company.
     * The user chooses between creating a new department or adding an existing department.
     * If a new department is selected, the user enters its name.
     * If the department already exists, it can't be added.
     * @param company a company to add a new department
     * @return an added department
     */
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
                        company.getDepartments().add(resDep);
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
                    company.getDepartments().add(resDep);
                    System.out.println("Department \"" + departmentName + "\" has been added to company " + company.getName());

                    return resDep;
                }

                System.err.println("Department with name \"" + departmentName + "\" already exists");
                System.err.println("try again");
            }

        } while (true);
    }

    /**
     * Checks if it is possible to add a department with the given name.
     * Returns `false` if a department with this name already exists.
     *
     * This method helps to avoid duplicate departments,
     * keeping a clear and concise list of objects without confusion.
     *
     * @param company company to add a department
     * @param newDepartmentName the name of an adding department
     * @return boolean value
     */
    public static boolean canAddDepartment(Company company, String newDepartmentName) {
        for (Department dep : company.getDepartments()) {
            if (dep.getName().equals(newDepartmentName)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a list of available standard departments from the enum list
     * DepartmentBaseType that have not yet been added to the company.
     * Department names added to the company are removed from the list of available departments to select.
     *
     * @param company company to add a department
     * @return list of names of the default departments
     */
    public static List<DepartmentDefaultType> getAvailableDepartments(Company company) {
        ArrayList<DepartmentDefaultType> result = new ArrayList<>(Arrays.asList(DepartmentDefaultType.values()));

        for (Department dep : company.getDepartments()) {
            if (dep.getType() == DepartmentBaseType.DEFAULT) {
                result.remove(((PrecreatedDepartment) dep).GetSelectedDepartment());
            }
        }

        return result;
    }


    /**
     * Allows the user to add a manager to the selected department.
     * The user selects the type of manager, enters name, gender, email and salary.
     * If the department already has a manager of that type, the addition is cancelled.
     * This check is implemented using the method сanAddManager
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
                selectedDepartment.getManagers().add(newManager);
                System.out.println("Manager \"" + managerType + "\" has been added to the department " + selectedDepartment.getName());

                return;
            }

            System.err.println("Manager \"" + managerType + "\" already exists");
            System.err.println("try again");
            // Select manager type
            managerType = selectFromList("* Select manager's type", ManagerType.class);

        } while (true);
    }

    /**
     * Checks if a manager of the specified type can be added to the department.
     * Returns `false` if a manager of this type already exists in the department.
     * This method helps to avoid errors when adding a manager to a department on the user side.
     * This method is used in the addManager.
     *
     * @param department department to add a manager
     * @param newManagerType type of adding manager
     * @return boolean value
     */
    public static boolean canAddManager(Department department, ManagerType newManagerType) {
        for (Manager manager : department.getManagers()) {
            if (manager.getManagerType().equals(newManagerType)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a list of available manager types for the department,
     * excluding those that are already occupied.
     *
     * @param department
     * @return
     */
    public static List<ManagerType> getAvailableManagerTypes(Department department) {
        ArrayList<ManagerType> result = new ArrayList<>(Arrays.asList(ManagerType.values()));

        for (Manager manager : department.getManagers()) {
            for (ManagerType mt : ManagerType.values()) {
                if (manager.getManagerType() == mt) {
                    result.remove((manager).getManagerType());
                }
            }
        }
        return result;
    }


    /**
     * Method adds a developer to the selected department.
     * The user selects the developer type, position, gender, enters name, email and salary.
     * A developer object is then created and added to the department.
     * @param company
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
        selectedDepartment.getDevelopers().add(newDeveloper);
        System.out.println(
                "Developer \n"
                        + newDeveloper
                        + "\n has been added to the department "
                        + selectedDepartment.getName()
        );
    }

    /**
     * Method to build a Person object using data from the text file.
     * Depending on the position, it can return developer, manager, or office employee.
     * This method is used to collect the data from the text file.
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

    /**
     * Returns a random company from the `Store.companies` list.
     * If there are no companies, creates a new one.
     * @return
     */
    public static Company getRandomOrGeneratedCompany() {
        if (Store.companies.isEmpty()) {
            Store.companies.add(Company.generate());
        }
        return Store.companies.get(new Random().nextInt(Store.companies.size()));
    }

    /**
     * Generates a developer and adds him to the company's IT department.
     * If the IT department does not exist,the method creates it.
     *
     * @param company - company to add a new developer
     * @return a generated developer
     */
    public static Developer generateDeveloperAndAddDeveloperToITDepartment(Company company) {
        Developer developer = Developer.generate(company.getName());
        Store.people.add(developer);
        Department ITDep =
                company.getOrCreateDepartment(DepartmentDefaultType.IT.toString());
        ITDep.addPerson(developer);
        return developer;
    }

    /**
     * Generates a manager and adds it to a random department of the company.
     * If no department is found, a new one is created.
     * @param company - company to add a new manager
     * @return a generated manager
     */
    public static Manager generateManagerAndAddManagerToDepartment(Company company) {
        Department randomDep =
                company.getOrCreateDepartment(DepartmentDefaultType.getRandomDepartment());
        Manager newManager = Manager.generate(company.getName());
        randomDep.addPerson(newManager);
        return newManager;
    }

    /**
     * Generates an office employee and adds them to a random non-IT department.
     * If there is no matching department, an office employee department is generated.
     * @param company - company to add a new office employee
     * @return a generated office employee
     */
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

    /**
     * Selects or creates a department to add a new employee.
     * The user chooses between an existing department and a new department.
     * @param company where to select a department
     * @return a department where then a user will add an employee
     */
    private static Department getSelectedDepartmentToAddObj(Company company) {
        selectDepartmentToAddObjOptions choice =
                InputUtilities.selectFromList("Would you like to add a new developer to:",
                        selectDepartmentToAddObjOptions.class);

        switch (choice) {
            case EXISTING: {
                List<Department> departments = company.getDepartments();

                if (departments.isEmpty()) {
                    System.out.println("There's no existing departments. Create a new department");
                    return addDepartment(company);
                } else {
                    return InputUtilities.selectFromList("\nSelect a department from the list: ",
                            company.getDepartments().toArray(new Department[0]), Department::getName);
                }
            }
            case NEW:
            default: {
                return addDepartment(company);
            }
        }
    }
}
