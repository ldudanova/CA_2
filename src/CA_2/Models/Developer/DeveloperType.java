package CA_2.Models.Developer;

public enum DeveloperType {
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    FULL_STACK("Full-stack"),
    QA("QA"),
    MOBILE("Mobile Developer"),
    AI("AI Developer"),
    DATA_SCIENTIST("Data Scientist"),
    DEVOPS("DevOps");

    // String representation of enum value
    private final String label;

    // Constructor
    DeveloperType(String label) {
        this.label = label;
    }

    /**
     * Set the way how convert enum to string
     *
     * @return String value of enum (label)
     */
    @Override
    public String toString() {
        return label;
    }
}
