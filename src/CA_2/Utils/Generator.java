package CA_2.Utils;

import CA_2.Models.*;

import java.util.Random;

public class Generator {

    /**
     * Method for getting first name form the store depending on gender
     *
     * @param personGender target name gender
     * @return First name
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
     * Method for getting last name form the store
     *
     * @return Last name
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
     * @param length
     * @return
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
     * Method to generate email based on first and last names
     *
     * @param firstName first name
     * @param lastName  last name
     * @return generated email
     */
    public static String generateEmail(String firstName, String lastName, String companyName) {
        return firstName.toLowerCase().charAt(0)   // first letter of first name
                + lastName.toLowerCase()  //lower cased last name
                + "@" + companyName + ".com"; //company name as a domain
    }

    /**
     * Method to choose random value of any Enum
     *
     * @param enumData type of enum that contains options
     * @return Randomly selected value of Enum
     */
    public static <E extends Enum<E>> E pickFromList(Class<E> enumData) {
        E[] enumConstants = enumData.getEnumConstants();
        return enumConstants[rnd.nextInt(enumConstants.length)];
    }

    /**
     * Method to choose random item from array
     *
     * @param array array of objects
     * @param <E>   type of objects in the array
     * @return Item from array
     */
    public static <E> E pickFromList(E[] array) {
        return array[rnd.nextInt(array.length)];
    }

    /**
     * @param managerType
     * @return
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
     * @param position
     * @return
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
     * @param min
     * @param max
     * @return
     */
    private static double generateRandomDouble(int min, int max) {
        Random random = new Random();
        return max + (min * random.nextDouble());
    }

}
