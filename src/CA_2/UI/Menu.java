package CA_2.UI;

import CA_2.Models.*;
import CA_2.Utils.Helper;
import CA_2.Utils.Generator;
import CA_2.Utils.SortAndSearchOperations;
import CA_2.Utils.Store;

import java.util.ArrayList;
import java.util.Random;

import static CA_2.Utils.InputUtilities.*;
import static CA_2.Utils.Helper.getRandomOrGeneratedCompany;

/**
 * Class for displaying a menu and asking the user for their choice.
 */
public class Menu {
    /*
     * All enums in this class contain:
     * - label: A string representation of each enum value, used to display options clearly.
     * - toString method: A method to convert enum values to their string representations.
     */

    /**
     * Enum for sorting directions.
     * This enum represents the sorting order options that can be displayed to the user.
     */
    public enum sortingDirection {
        ASC("Ascending"), // Ascending order
        DESC("Descending"); // Descending order

        // String label that stores the human-readable representation of the sorting order.
        private final String label;

        // Constructor for sortingDirection enum, setting the label for each sorting order.
        sortingDirection(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label of the sorting order.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Enum for main menu options.
     * This enum represents the different choices available to the user in the main menu.
     */
    public enum menuOptions {
        //
        CREATE_COMPANY("Create a company"),
        //
        SHOW_COMPANIES_LIST("Show the list of existing companies"),
        // Option to sort a predefined list of people.
        SORT("Sort a Dummy List of People"),
        // Option to search within the list and retrieve information.
        SEARCH("Search in the List and Return Relevant Information"),
        // Option to enable user data entry (name, manager type, and department).
        USER_INPUT("Allow for New User Input (Name, ManagerChoice, and Department)"),
        // Option to create random entries with manager types and departments.
        GENERATE("Generate Random People with Manager Types and Departments"),
        // Option to display the stored data.
        PRINT("Print stored data"),
        // Option to exit the application.
        EXIT("Exit");

        // String label that stores the human-readable representation of each menu option.
        private final String label;

        // Constructor for menuOptions enum, setting the label for each menu option.
        menuOptions(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label of the menu option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Enum representing types of objects that can be input by the user or generated by the system.
     * This enum provides the user with options for selecting a specific type of entity to add to the system.
     */
    public enum userInputOptions {
        // Option to input a Developer.
        DEVELOPER("Developer"),
        // Option to input a Manager.
        MANAGER("Manager"),
        // Option to input a Department.
        DEPARTMENT("Department");

        // String label that holds the display name for each user input option.
        private final String label;

        // Constructor for userInputOptions, which initializes the label with a human-readable string.
        userInputOptions(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the user input option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Enum representing types of objects that can be input by the user or generated by the system.
     * This enum provides the user with options for selecting a specific type of entity to add to the system.
     */
    public enum userGenerateOptions {
        // Option to generate an Employee.
        DEVELOPER("Developer"),
        // Option to generate a Manager.
        MANAGER("Manager"),
        OFFICE_EMPLOYEE("Office employee"),
        COMPANY("Company");

        // String label that holds the display name for each user input option.
        private final String label;

        // Constructor for userInputOptions, which initializes the label with a human-readable string.
        userGenerateOptions(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the user input option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     *
     */
    public enum userWayToAddANewCompany {
        CUSTOM("Input a custom name"),
        GENERATE("Generate a company name");
        // String label that holds the display name for each user input option.
        private final String label;

        // Constructor for userInputOptions, which initializes the label with a human-readable string.
        userWayToAddANewCompany(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the user input option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     *
     */
    public enum selectDepartmentToAddObjOptions {
        EXISTING("the existing department"),
        NEW("a new department");

        // String label that holds the display name for each user input option.
        private final String label;

        // Constructor for selectDepartmentToAddObjOptions, which initializes the label with a human-readable string.
        selectDepartmentToAddObjOptions(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the user input option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    public enum selectWayToCreateNewCompanyOptions {
        INPUT("Input a name for a new company"),
        GENERATE("Generate a name for a new company");

        // String label that holds the display name for each user input option.
        private final String label;

        // Constructor for selectDepartmentToAddObjOptions, which initializes the label with a human-readable string.
        selectWayToCreateNewCompanyOptions(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the user input option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Enum representing types of objects that can be printed by the system.
     * This enum allows the user to specify a particular type of data to display.
     */
    public enum printingType {
        //
        ALL_COMPANIES("All companies"),
        // Option to print all people (both employees and managers).
        ALL_PEOPLE("All people");

        // String label that holds the display name for each printing option.
        private final String label;

        // Constructor for printingType, which initializes the label with a user-friendly string.
        printingType(String label) {
            this.label = label;
        }

        /**
         * Converts the enum value to a string representation.
         *
         * @return The string label representing the printing option.
         */
        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Method for starting a menu loop, asking for user input, and performing actions
     */
    public static void showMenu() {

        // Flag to control the exit from the menu loop
        boolean needToExit = false;

        // Main menu loop that continues until 'needToExit' is set to true
        do {
            // Prompting the user to select an action from the main menu
            menuOptions action =
                    selectFromList("\n============ Main menu ===============\n",
                            menuOptions.class);

            // Evaluating the action selected by the user
            switch (action) {
                case CREATE_COMPANY: {
                    selectWayToCreateNewCompanyOptions selectWayToCreateNewCompanyOption =
                            selectFromList("\nSelect the way to create a name for a new company: ",
                                    selectWayToCreateNewCompanyOptions.class);
                    switch (selectWayToCreateNewCompanyOption) {
                        case INPUT: {
                            String companyName =
                                    askUserForText("\nEnter the name for your company: ");
                            createCompany(companyName);
                            break;
                        }
                        case GENERATE: {
                            createCompany(Generator.generateCompanyName());
                        }
                    }
                    break;
                }

                case SHOW_COMPANIES_LIST: {
                    // Print all companies
                    Printer.printCompanyNames(Store.companies);
                    break;
                }

                // If the "SORT" option is selected
                case SORT: {
                    // Asking for sort direction
                    sortingDirection sortingDirection =
                            selectFromList("\nSelect order direction:", sortingDirection.class);

                    // Create new sorted list of people
                    ArrayList<Person> sortedPeople =
                            SortAndSearchOperations.recursiveInsertionSort(Store.people, sortingDirection);

                    // Print top 20 items of sorted list
                    Printer.printPeople(sortedPeople, 20);

                    break;
                }

                // If the "SEARCH" option is selected
                case SEARCH: {
                    // Asking the user for a search input (could be first name, last name, or both)
                    String searchString = askUserForText("Enter first name, last name or both for searching: ");

                    // Performing a linear search in the list of people based on the search input
                    ArrayList<Person> searchResult = SortAndSearchOperations.linearSearchPeople(Store.people, searchString);

                    // Checking if any results were found and displaying them; otherwise, notify no results were found
                    if (searchResult.isEmpty()) {
                        System.out.println("No results were found for your request");
                    } else {
                        System.out.println("Search result: ");
                        Printer.printPeople(searchResult);
                    }

                    break;
                }

                // Third option is selected
                case USER_INPUT: {
                    //
                    if (Store.companies.isEmpty()) {
                        System.out.println("\nThere's no companies to add a new object.");
                        System.out.println("\nAdd a company first.");
                        userWayToAddANewCompany selectedOption =
                                selectFromList("Select the way to add a new company: ",
                                        userWayToAddANewCompany.class);
                        switch (selectedOption) {
                            case CUSTOM: {
                                String companyName =
                                        askUserForText("\nEnter the name for your company: ");
                                createCompany(companyName);
                                break;
                            }
                            case GENERATE: {
                                Store.companies.add(Company.generate());
                                break;
                            }
                        }
                    }
                    Company selectedCompany = selectFromList("Select a company where to add a new object: ",
                            Store.companies.toArray(new Company[0]), Company::getName);
                    System.out.println("selectedCompany: " + selectedCompany.name);

                    // Asking for type of object to create
                    userInputOptions inputOption =
                            selectFromList("What type of object do you want to add?",
                                    userInputOptions.class);

                    switch (inputOption) {
                        // Creating developer
                        case DEVELOPER: {
                            Helper.addDeveloper(selectedCompany);
                            break;
                        }
                        // Creating manager
                        case MANAGER: {
                            Helper.addManager(selectedCompany);
                            break;
                        }
                        // Creating department
                        case DEPARTMENT: {
                            Helper.addDepartment(selectedCompany);
                            break;
                        }
                    }
                    break;
                }

                // Fourth option is selected
                case GENERATE: {
                    // Asking for type of object to generate
                    userGenerateOptions userGenerateOption =
                            selectFromList("What type of object do you want to generate?",
                                    userGenerateOptions.class);
                    switch (userGenerateOption) {
                        // Generating employee
                        case DEVELOPER: {
                            Company randomCompany;
                            if (Store.companies.isEmpty()) {
                                Store.companies.add(Company.generate());
                            }
                            randomCompany =
                                    Store.companies
                                            .get(new Random()
                                                    .nextInt(Store.companies.size()));
                            Developer developer =
                                    Helper.generateDeveloperAndAddDeveloperToITDepartment(randomCompany);
                            Store.people.add(developer);

                      /*      Department itDep = randomCompany.getOrCreateDepartment(DepartmentDefaultType.IT.toString());
                            itDep.addPerson(developer);*/
                            System.out.println("Developer " + developer + "has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating manager
                        case MANAGER: {
                            Company randomCompany;
//                            Department randomDep;
//                            if (Store.companies.isEmpty()) {
//                                Store.companies.add(Company.generate());
//                            }
                            randomCompany = getRandomOrGeneratedCompany();
                            Manager manager = Helper.generateManagerAndAddManagerToDepartment(randomCompany);
                            Store.people.add(manager);
/*
                            randomDep = randomCompany.departments.get(new Random().nextInt(randomCompany.departments.size()));
                            randomDep.addPerson(manager);*/
                            System.out.println("Manager " + manager + "has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating office employee
                        case OFFICE_EMPLOYEE: {
                            Company randomCompany;
                            randomCompany = getRandomOrGeneratedCompany();
                            OfficeEmployee officeEmployee =
                                    Helper.generateOfficeEmployeeAndAddOfficeEmployeeToNonITDepartment(randomCompany);
                            Store.people.add(officeEmployee);
                            System.out.println("Office employee " + officeEmployee + "has been added to " + randomCompany.getName());
                            break;
                        }
                        // Generating company
                        case COMPANY: {
                            Company newCompany = Company.generate();
                            Store.companies.add(newCompany);
                            System.out.println("The company has been added: " + newCompany.name);
                            break;
                        }
                    }
                    break;
                }

                case PRINT: {
                    // Asking for type of objects to print
                    printingType printingOption =
                            selectFromList("What type of object do you want to print?",
                                    printingType.class);

                    switch (printingOption) {
                        //
                        case ALL_COMPANIES: {
                            Printer.printCompaniesData(Store.companies);
                            break;
                        }
                        // Printing all data from Store.people
                        case ALL_PEOPLE: {
                            System.out.println("All people:");
                            Printer.printPeople(Store.people, Store.people.size());
                            break;
                        }
                    }

                    break;
                }

                // If the "EXIT" option is selected, set the exit flag to true to terminate the menu loop
                case EXIT: {
                    needToExit = true;
                    break;
                }
            }

            // Repeat the loop as long as "needToExit" is false
        } while (!needToExit);
    }

    private static void createCompany(String companyName) {
        Company company = new Company(companyName);
        Store.companies.add(company);
        System.out.println("The company " + company.name + " was created");
    }
}
