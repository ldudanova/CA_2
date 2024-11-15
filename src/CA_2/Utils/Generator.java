package CA_2.Utils;

import CA_2.Models.*;
import CA_2.Models.Employee.EmployeePosition;
import CA_2.Models.Manager.ManagerType;

import java.util.Random;

/**
 * Provides methods for generating data like names, emails, salaries.
 * It supports creating random attributes
 * and data elements needed for modeling people and companies.
 */
public class Generator {

    /**
     * Generates a random first name for a person that based on his or her gender.
     * If an error occurs, it creates a random string.
     *
     * @param personGender the gender of the person
     * @return a first name based on gender, or a random string if an error occurs
     */
    public static String getFirstName(Gender personGender) {
        try {
            // Filtering list of people with certain gender and saving them to array
            Person[] array = Store.people
                    .stream()
                    .filter(x -> x.getGender() == personGender)
                    .toArray(Person[]::new);
            // Getting random item from the filtered list and taking first name of it
            return array[rnd.nextInt(array.length)].getFirstName();
        } catch (Exception e) {
            System.out.println("Error msg: " + e.getMessage());
            // If there is any error generate first name from random letters
            return generateUpperCaseString(1)
                    + generateUpperCaseString(9)
                    .toLowerCase();
        }
    }

    /**
     * Returns a random last name for a person from the list of stored people.
     * If an error occurs, it generates a random string as a last name.
     *
     * @return a last name or a random set of letters on error
     */
    public static String getLastName() {
        try {
            // Getting random item from list of all people and taking last name of it
            return Store.people.get(rnd.nextInt(Store.people.size())).getLastName();
        } catch (Exception e) {
            // If there is any error generate last name from random letters
            return generateUpperCaseString(1) + generateUpperCaseString(9).toLowerCase();
        }
    }

    /**
     * Creates a random uppercase string of a specified length.
     *
     * @param length the length of the string
     * @return a random uppercase string
     */
    public static String generateUpperCaseString(int length) {
        // Amount of letters
        int charAmount = 'Z' - 'A' + 1;

        // If it is the first call generate an array of letters
        if (letters == null) {
            letters = new char[charAmount];
            for (int i = 0; i < charAmount; i++) {
                letters[i] = (char) ('A' + i);
            }
        }

        // Creating StringBuilder for more optimal building string
        StringBuilder sb = new StringBuilder();

        // Generating random string
        for (int i = 0; i < length; i++) {
            sb.append(letters[rnd.nextInt(charAmount)]);
        }

        // Returning result
        return sb.toString();
    }

    /**
     * Generates an email address based on first and last names and a company name that is used for a domain.
     *
     * @param firstName   the first name of a person
     * @param lastName    the last name of a person
     * @param companyName the company name
     * @return the generated email
     */
    public static String generateEmail(String firstName, String lastName, String companyName) {
        return firstName.toLowerCase().charAt(0)   // first letter of first name
                + lastName.toLowerCase()  //lower cased last name
                + "@" + companyName + ".com"; //company name as a domain
    }

    /**
     * Selects a random value from the specified enum type.
     *
     * @param enumData the enum type
     * @return a random enum value
     * @param <E> the enum class
     */
    public static <E extends Enum<E>> E pickFromList(Class<E> enumData) {
        E[] enumConstants = enumData.getEnumConstants();
        return enumConstants[rnd.nextInt(enumConstants.length)];
    }

    /**
     * Generates a salary for a generated employee based on manager type.
     *
     * @param managerType the type of manager
     * @return a salary in the range for the given manager type
     */
    public static double generateSalary(ManagerType managerType) {
        switch (managerType) {
            case MANAGER: {
                return generateRandomDouble(2000, 2500);
            }
            case ASSISTANT_MANAGER: {
                return generateRandomDouble(2000, 2200);
            }
            case HEAD_MANAGER: {
                return generateRandomDouble(2500, 4000);
            }
            case SENIOR_MANAGER: {
                return generateRandomDouble(4100, 10000);
            }
            case TEAM_LEAD: {
                return generateRandomDouble(3000, 5000);
            }
            default: {
                return generateRandomDouble(2000, 10000);
            }
        }
    }

    /**
     * Generates a salary based on employee position.
     *
     * @param position the employee position
     * @return a salary in the range for the position
     */
    public static double generateSalary(EmployeePosition position) {
        switch (position) {
            case INTERN: {
                return generateRandomDouble(1000, 1500);
            }
            case CONTRACT: {
                return generateRandomDouble(1000, 3000);
            }
            case JUNIOR: {
                return generateRandomDouble(1500, 2000);
            }
            case MIDDLE: {
                return generateRandomDouble(2000, 3500);
            }
            case SENIOR: {
                return generateRandomDouble(3000, 5000);
            }
            default: {
                return generateRandomDouble(1000, 5000);
            }
        }
    }

    // Object for getting random values
    private static final Random rnd = new Random();
    // Array with letters
    private static char[] letters = null;

    /**
     * Generates a random double value between the specified minimum and maximum.
     *
     * @param min the minimum value
     * @param max the maximum value
     * @return a random double within the range
     */
    private static double generateRandomDouble(int min, int max) {
        double diff = (max - min) / 10.00;
        Random random = new Random();
        return min + diff * random.nextInt(10);
    }

}
