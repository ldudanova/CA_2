package CA_2.UI;

import CA_2.Models.*;
import CA_2.Utils.SortAndSearchOperations;
import CA_2.Utils.Store;

import static CA_2.Utils.InputUtilities.*;

import java.util.ArrayList;

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
        // Option to input or generate an Employee.
        EMPLOYEE("Employee"),
        // Option to input or generate a Manager.
        MANAGER("Manager"),
        // Option to input or generate a Department.
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
     * Enum representing types of objects that can be printed by the system.
     * This enum allows the user to specify a particular type of data to display.
     */
    public enum printingType {
        // Option to print all people (both employees and managers).
        ALL_PEOPLE("All people"),
        // Option to print only employees.
        EMPLOYEE("Employees"),
        // Option to print only managers.
        MANAGER("Managers"),
        // Option to print only departments.
        DEPARTMENT("Departments");

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
            menuOptions action = selectFromList("\n============ Main menu ===============\n", menuOptions.class);

            // Evaluating the action selected by the user
            switch (action) {

                // If the "SORT" option is selected
                case SORT:
                    // Asking for sort direction
                    sortingDirection sortingDirection =
                            selectFromList("\nSelect order direction:", sortingDirection.class);

                    // Create new sorted list of people
                    ArrayList<Person> sortedPeople =
                            SortAndSearchOperations.recursiveInsertionSort(Store.people, sortingDirection);

                    // Print top 20 items of sorted list
                    Printer.printPeople(sortedPeople, 20);

                    break;

                // If the "SEARCH" option is selected
                case SEARCH: {
                    // Asking the user for a search input (could be first name, last name, or both)
                    String searchString = askUserForText("Enter first name, last name or both for searching: ");

                    // Performing a linear search in the list of people based on the search input
                    ArrayList<Person> searchResult = SortAndSearchOperations.linearSearchPeople(Store.people, searchString);

                    // Checking if any results were found and displaying them; otherwise, notify no results were found
                    if (searchResult.isEmpty()) System.out.println("No results were found for your request");
                    else {
                        System.out.println("Search result: ");
                        Printer.printPeople(searchResult);
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


}
