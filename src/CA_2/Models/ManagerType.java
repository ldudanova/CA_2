package CA_2.Models;

/**
 * Enum with manager type values
 */
public enum ManagerType {
    HEAD_MANAGER,
    ASSISTANT_MANAGER,
    TEAM_LEAD;

    /**
     * Set the way how convert enum to string
     *
     * @return String value of enum
     */

    @Override
    public String toString() {
        switch (this) {
            case HEAD_MANAGER:
                return "Head Manager";
            case ASSISTANT_MANAGER:
                return "Assistant manager";
            case TEAM_LEAD:
                return "Team Lead";
            default:
                return "unknown";
        }
    }

    /**
     * @param manager_type String value of ManagerType
     * @return ManagerType enum value
     */
    public static ManagerType parse(String manager_type) {
        // if argument is equal "Head Manager" then return ManagerType.HEAD_MANAGER
        if (manager_type.trim().equalsIgnoreCase("head manager")) {
            return ManagerType.HEAD_MANAGER;
        }

        // if argument is equal "Assistant manager" then return ManagerType.ASSISTANT_MANAGER
        if (manager_type.trim().equalsIgnoreCase("assistant manager")) {
            return ManagerType.ASSISTANT_MANAGER;
        }

        // if argument is equal "Team Lead" then return ManagerType.TEAM_LEAD
        if (manager_type.trim().equalsIgnoreCase("team lead")) {
            return ManagerType.TEAM_LEAD;
        }

        // If none of the conditions match, throw an exception
        throw new IllegalArgumentException("Invalid manager type: " + manager_type);
    }
}
