package CA_2.Models.Menu;

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

