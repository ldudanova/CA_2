package CA_2.Models.Menu;

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
    SEARCH_PERSON("Search for a person in the List and Return Relevant Information"),
    SEARCH_COMPANY("Search for a company in the List and Return Relevant Information"),
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
