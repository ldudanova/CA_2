package CA_2.Models.Manager;

/**
 * The ManagerType enum defines the types of managerial roles within the company.
 *
 * This enum is used for specifying the type of manager, helping differentiate between various managerial roles
 * such as Head Managers and Team Leads. It allows for more structured management hierarchy
 * and simplifies classification in employee data.
 */
public enum ManagerType {
    HEAD_MANAGER,
    ASSISTANT_MANAGER,
    TEAM_LEAD,
    MANAGER,
    SENIOR_MANAGER;

    /**
     * Set the way to convert enum to a formatted string
     *
     * @return String value of enum
     */
    @Override
    public String toString() {
        switch (this) {
            case HEAD_MANAGER:
                return "Head Manager";
            case ASSISTANT_MANAGER:
                return "Assistant Manager";
            case TEAM_LEAD:
                return "Team Lead";
            case MANAGER:
                return "Manager";
            case SENIOR_MANAGER:
                return "Senior Manager";
            default:
                return "Unknown";
        }
    }

    /**
     * Parses a string to find the corresponding ManagerType enum
     *
     * @param managerType String value of ManagerType
     * @return ManagerType enum value
     * @throws IllegalArgumentException if no match is found
     */
    public static ManagerType parse(String managerType) {
        if (managerType.trim().equalsIgnoreCase("head manager")) {
            return ManagerType.HEAD_MANAGER;
        }
        if (managerType.trim().equalsIgnoreCase("assistant manager")) {
            return ManagerType.ASSISTANT_MANAGER;
        }
        if (managerType.trim().equalsIgnoreCase("team lead")) {
            return ManagerType.TEAM_LEAD;
        }
        if (managerType.trim().equalsIgnoreCase("manager")) {
            return ManagerType.MANAGER;
        }
        if (managerType.trim().equalsIgnoreCase("senior manager")) {
            return ManagerType.SENIOR_MANAGER;
        }

        // If none of the conditions match, throw an exception
        throw new IllegalArgumentException("Invalid manager type: " + managerType);
    }
}
