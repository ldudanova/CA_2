package CA_2.Models.Menu;

/**
 * Enum representing types of objects that can be printed by the system.
 * This enum allows the user to specify a particular type of data to display.
 */
public enum printingType {
    ALL_COMPANIES("All companies"),
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
