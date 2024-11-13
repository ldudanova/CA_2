package CA_2.Models.Menu;


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
