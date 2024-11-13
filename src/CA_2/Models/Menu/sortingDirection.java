package CA_2.Models.Menu;

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

