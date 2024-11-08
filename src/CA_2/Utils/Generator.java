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
}
