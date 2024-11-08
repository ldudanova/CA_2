package CA_2.Models;


/**
 * Enum class representing gender values.
 *
 * The Gender enum is used to define the gender of employees within the company.
 * By establishing a standardized approach to represent gender, the company can ensure that
 * employee data is consistently formatted and supportive of inclusivity within the workplace.
 * This enum provides easy-to-use identifiers for specifying gender,
 * enhancing readability and reliability when managing employee data.
 */
public enum Gender {
    MALE,
    FEMALE;

    /**
     * Converts the enum value to a formatted string.
     *
     * The overridden `toString()` method provides a custom way of converting enum values to a
     * string. By using this method, the string representation of each enum value is formatted
     * for easy readability, which can help improve user experience in the application and
     * maintain consistency across various parts of the program that display employee information.
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
                return "unknown";
        }
    }


    /**
     * Parses a string and returns the corresponding Gender enum value.
     *
     * The `parse` method is a static method that takes a string as input and returns the appropriate
     * Gender enum based on the string’s value. This method allows the program to convert string
     * inputs, such as those provided by users or stored in text files, into standardized Gender
     * enum values. By using this method, the program can handle gender inputs in a case-insensitive
     * way, allowing flexibility in user input while maintaining data consistency.
     *
     * @param gender String value representing gender (e.g., "male" or "female")
     * @return The Gender enum corresponding to the input string. Defaults to FEMALE if the input
     *         does not match "male" (ignoring case).
     */
    public static Gender parse(String gender) {
        // if argument is equal "male" then return Gender.MALE else Gender.FEMALE
        if (gender.trim().equalsIgnoreCase("male"))
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }
}
