package CA_2.Models;

/**
 * Enum with department type values
 */
public enum DepartmentType {
    CUSTOMER_SERVICE,
    TECHNICAL_SUPPORT,
    HUMAN_RESOURCES,
    MARKETING,
    SALES,
    FINANCE,
    DEVELOPMENT,
    OPERATIONS;

    /**
     * Converts enum value to a formatted string representation
     *
     * @return String value of the department type
     */
    @Override
    public String toString() {
        switch (this) {
            case CUSTOMER_SERVICE:
                return "Customer Service";
            case TECHNICAL_SUPPORT:
                return "Technical Support";
            case HUMAN_RESOURCES:
                return "HR";
            case MARKETING:
                return "Marketing";
            case SALES:
                return "Sales";
            case FINANCE:
                return "Finance";
            case DEVELOPMENT:
                return "Development";
            case OPERATIONS:
                return "Operations";
            default:
                return "Unknown";
        }
    }

    /**
     * Parses a string to find the corresponding DepartmentType enum
     *
     * @param departmentType String value of DepartmentType
     * @return DepartmentType enum value
     * @throws IllegalArgumentException if no match is found
     */
    public static DepartmentType parse(String departmentType) {
        if (departmentType.trim().equalsIgnoreCase("customer service")) {
            return DepartmentType.CUSTOMER_SERVICE;
        }
        if (departmentType.trim().equalsIgnoreCase("technical support")) {
            return DepartmentType.TECHNICAL_SUPPORT;
        }
        if (departmentType.trim().equalsIgnoreCase("human resources")
                || departmentType.trim().equalsIgnoreCase("hr")) {
            return DepartmentType.HUMAN_RESOURCES;
        }
        if (departmentType.trim().equalsIgnoreCase("marketing")) {
            return DepartmentType.MARKETING;
        }
        if (departmentType.trim().equalsIgnoreCase("sales")) {
            return DepartmentType.SALES;
        }
        if (departmentType.trim().equalsIgnoreCase("finance")) {
            return DepartmentType.FINANCE;
        }
        if (departmentType.trim().equalsIgnoreCase("development")) {
            return DepartmentType.DEVELOPMENT;
        }
        if (departmentType.trim().equalsIgnoreCase("operations")) {
            return DepartmentType.OPERATIONS;
        }

        // If none of the conditions match, throw an exception
        throw new IllegalArgumentException("Invalid department type: " + departmentType);
    }
}
