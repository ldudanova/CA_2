package CA_2.Utils;

//import java utils

import java.util.Scanner;
import java.util.function.Function;

public class InputUtilities {

    /**
     * Prompt the user to enter a text string. If no text is entered, display an error message
     * and continue prompting until valid text is entered.
     *
     * @param prompt The prompt or message to display to the user.
     * @return The valid text entered by the user.
     */
    public static String askUserForText(String prompt) {

        // Create a new Scanner object to read user input
        Scanner myKB = new Scanner(System.in);
        // Display the prompt message
        System.out.println(prompt);

        // Return the user input from the next line
        return myKB.nextLine();
    }

    /**
     * Prompt the user to enter a single word (no spaces). If the input is empty,
     * contains spaces, or is a number, display an error and ask again until a valid word is entered.
     *
     * @param prompt The prompt or message to display to the user.
     * @return A valid word entered by the user.
     */
    public static String askUserForWord(String prompt) {

        // Create a new Scanner object
        Scanner myKB = new Scanner(System.in);

        // Variable to store the user input
        String userInput;
        // Boolean flag to check input validity
        boolean isValid;

        do {
            isValid = true;
            // Display the prompt message
            System.out.println(prompt);

            // Read user input and remove leading/trailing spaces
            userInput = myKB.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println("The input value cannot be empty! Try again");
                // Mark input as invalid if it is empty
                isValid = false;
            }

            if (userInput.contains(" ")) {
                System.out.println("The input contains more than one word! Try again");
                // Mark input as invalid if it contains spaces
                isValid = false;
            }

            if (userInput.matches("(-?)[0-9]*[.]?[0-9]+")) {
                System.out.println("The input should not be a number! Try again");
                // Mark input as invalid if it matches a number pattern
                isValid = false;
            }
        } while (!isValid);  // Repeat until a valid word is entered

        // Return the validated user input
        return userInput;
    }

    /**
     * Prompt the user to enter a valid email or leave it empty. If empty, return an empty string.
     * Otherwise, validate that the input is a well-formed email address.
     *
     * @param prompt The prompt or message to display to the user.
     * @return The valid email entered by the user, or an empty string if none is entered.
     */
    public static String askUserForEmail(String prompt) {
        // Create a new Scanner object
        Scanner myKB = new Scanner(System.in);

        // Variable to store user input
        String userInput;
        // Boolean flag for input validity
        boolean isValid;

        do {
            isValid = true;
            // Display the prompt message
            System.out.println(prompt);

            // Read input and remove extra spaces
            userInput = myKB.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println("* email is empty *");
                // Return an empty string if input is empty
                return "";
            }

            if (userInput.contains(" ")) {
                System.out.println("The input contains space! Try again");
                // Mark input as invalid if it contains spaces
                isValid = false;
            }

            if (!userInput.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
                System.out.println("The input is not a valid email! Try again");
                // Mark input as invalid if it does not match an email pattern
                isValid = false;
            }
        } while (!isValid);    // Repeat until a valid email is entered

        // Return the validated email input
        return userInput;
    }

    /**
     * Prompt the user to enter an integer within a specific range. Display an error and re-prompt
     * if the input is not an integer or falls outside the specified range.
     *
     * @param prompt  The prompt message to display.
     * @param minimum The minimum allowed value.
     * @param maximum The maximum allowed value.
     * @return The validated integer entered by the user.
     */
    public static int askUserForInt(String prompt, int minimum, int maximum) {
        Scanner scanner;
        boolean hasInt;
        int num = 0;

        // Validate that minimum is less than or equal to maximum
        if (minimum > maximum) {
            throw new RuntimeException("Minimum should be less or equal to maximum");
        }

        do {
            // Display the prompt message
            System.out.println(prompt);
            // Create a new Scanner object for each attempt
            scanner = new Scanner(System.in);
            // Check if input is an integer
            hasInt = scanner.hasNextInt();

            if (!hasInt) {
                System.out.println("It is not an integer. Try again");
            } else {
                // Read the integer input
                num = scanner.nextInt();

                if (num < minimum) {
                    System.out.println("Your number is less than " + minimum + ". Try again");
                }

                if (num > maximum) {
                    // Display an error if input is above maximum
                    System.out.println("Your number is greater than " + maximum + ". Try again");
                }
            }

        } while (!hasInt || num < minimum || num > maximum); // Repeat until a valid integer is entered

        return num;
    }

}

