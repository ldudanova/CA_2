package CA_2.Models.Developer;

/**
 * The DeveloperType enum defines different specializations for developers.
 *
 * This enum categorizes developers by their area of expertise, such as "Frontend," "Backend," or "QA."
 * DeveloperType allows for organizing developer employees by their specialty, which is useful for filtering
 * and managing developers based on their specific roles and skills within projects.
 */
public enum DeveloperType {
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    FULL_STACK("Full-stack"),
    QA("QA"),
    MOBILE("Mobile Developer"),
    AI("AI Developer"),
    DATA_SCIENTIST("Data Scientist"),
    DEVOPS("DevOps");

    /**
     *  String representation of enum value
      */
    private final String label;

    /**
     * Constructor to initialize each DeveloperType with a specific label.
     *
     * This constructor assigns a descriptive string to each developer type, making it easier to display
     * and differentiate developer specializations in the user interface or in reports.
     *
     * @param label The label representing the type of developer.
     */
    DeveloperType(String label) {
        this.label = label;
    }

    /**
     * Provides a string representation of the enum value.
     *
     * This method returns the label for each developer type, which is particularly helpful for displaying
     * the developer's role in a readable format, rather than a code.
     *
     * @return The string label of the enum value.
     */
    @Override
    public String toString() {
        return label;
    }
}
