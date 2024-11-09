package CA_2.Utils;

import CA_2.Models.Gender;
import CA_2.Models.Person;

import java.util.Random;

public class Generator {

    // Object for getting random values
    private static final Random rnd = new Random();
    // Array with letters
    private static char[] letters = null;


    /**
     * Method for getting first name form the store depending on gender
     *
     * @param gender target name gender
     * @return First name
     */
    public static String getFirstName(Gender gender) {
        try {
            // Filtering list of people with certain gender and saving them to array
            Person[] array = Store.people.stream().filter(x -> x.gender == gender).toArray(Person[]::new);
            // Getting random item from the filtered list and taking first name of it
            return array[rnd.nextInt(array.length)].firstName;
        } catch (Exception e) {
            // If there is any error generate first name from random letters
            return generateUpperCaseString(1) + generateUpperCaseString(9).toLowerCase();
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
            return Store.people.get(rnd.nextInt(Store.people.size())).lastName;
        } catch (Exception e) {
            // If there is any error generate last name from random letters
            return generateUpperCaseString(1) + generateUpperCaseString(9).toLowerCase();
        }
    }

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
    public static String generateEmail(String firstName, String lastName) {
        return firstName.toLowerCase().charAt(0) +   // first letter of first name
                lastName.toLowerCase() + "@domain-" +  // last name + constant
                generateUpperCaseString(3).toLowerCase() + "." + // 3 letters and dot
                generateUpperCaseString(2).toLowerCase();       // 2 letters
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


    // Array with company predicates for generating team names
    private static final String[] companyPredicate = new String[]{"I", "IT", "Tech", "Group", "Web", "Dev", "Data", "Net"};
    private static final String[] companySuffix = new String[]{"IT", "Tech", "Group", "Pro", "Max", "Technologies", "Hub", "Computing", "Development"};

    /**
     *
     */
    public static String generateCompanyName() {
        Random random = new Random();
        int number = random.nextInt(10); //
        String name;

        if (number % 2 == 0) {
            name = companyPredicate[rnd.nextInt(companyPredicate.length)];
            return name + "-" + generateUpperCaseString(3);
        } else {
            name = companySuffix[rnd.nextInt(companySuffix.length)];
            return generateUpperCaseString(3) + "-" + name;
        }
    }
}
