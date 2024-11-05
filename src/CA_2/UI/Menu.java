package CA_2.UI;

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
}
