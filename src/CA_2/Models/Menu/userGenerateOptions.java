package CA_2.Models.Menu;

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


