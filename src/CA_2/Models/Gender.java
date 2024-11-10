package CA_2.Models;

/**
 * Enum class representing gender values.
 *
 * The `Gender` enum is used to define gender identifiers for employees within the company.
 * It establishes a standardized approach to represent gender, ensuring consistent formatting
 * and supporting inclusivity across the program. This enum is designed for clarity and simplicity,
 * with two primary options: "Male" and "Female," aligning with many workplace and regulatory standards
 * commonly recognized in EU countries. This structure makes the program's gender field accessible
 * and easily manageable for HR and administrative use, particularly in regions where clear binary
 * gender options are typical for most company data frameworks.
 *
 * The program is adaptable, and other options could be added in the future if needed to support
 * additional inclusivity and represent all employees appropriately.
 */
public enum Gender {
    MALE,
    FEMALE;

    /**
     * Converts the enum value to a formatted string.
     *
     * The overridden `toString()` method provides a customized way of converting enum values to a
     * human-readable string. This enhances the user experience, particularly when gender data
     * is displayed in the application. Consistent and clear gender labels help in maintaining a
     * professional tone throughout the program.
     *
     * @return String representation of the enum value
     */
    @Override
    public String toString() {
        switch (this) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            default:
                return "Unknown";
        }
    }

    /**
     * Parses a string input and returns the corresponding `Gender` enum value.
     *
     * The `parse` method is a static helper that converts user-provided or file-stored string data
     * into `Gender` enum values. By implementing case-insensitive comparison, it allows for flexible
     * input while ensuring that gender data is consistently mapped to a valid enum value.
     * This helps streamline user input processes, making the gender data management more intuitive.
     *
     * @param gender String value representing gender (e.g., "male" or "female")
     * @return The Gender enum corresponding to the input string. Defaults to FEMALE if the input
     *         does not match "male" (ignoring case).
     */
    public static Gender parse(String gender) {
        // If input matches "male" (case-insensitive), return MALE; otherwise, default to FEMALE
        if (gender.trim().equalsIgnoreCase("male"))
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }
}
