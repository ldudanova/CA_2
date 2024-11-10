package CA_2.Utils;

//import java utils
import java.util.Arrays;
import java.util.List;
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

    /**
     * Display a list of options for the user to select from,
     * then prompt them to enter a valid option.
     * If the selection is invalid, display an error and re-prompt.
     *
     * This method is used to present a simple list of String options to the user.
     * It directly displays the options in the String array,
     * which are passed in as a variable-length argument list.
     * The method returns the index of the chosen item.
     *
     * @param prompt  The prompt message to display.
     * @param options The list of options available to choose from.
     * @return The index of the selected option.
     */
    public static int selectFromList(String prompt, String... options) {
        // If the list of options is empty, display an error and return 0
        if (options.length == 0) {
            System.err.println("List of values is empty!");
            return 0;
        }

        // Display the prompt message
        System.out.println(prompt);

        int index = 1;
        // Display each option with a numbered index
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }

        int choice = askUserForInt("Choose an option (1-" + options.length + "): ", 1, options.length);
        return choice - 1; // Return the index of the chosen option
    }

    /**
     * Display a list of options derived from an Enum class for the user to select from.
     * If the selection is invalid, display an error and re-prompt.
     *
     * This method is specifically designed to work with enums.
     * It converts each enum constant into a string for display and lets the user select one.
     * The method returns the chosen enum constant itself rather than an index,
     * making it more type-safe and convenient when working with enums.
     *
     * @param prompt   The prompt message to display.
     * @param enumData The enum class providing options for selection.
     * @return The selected Enum value.
     */
    public static <E extends Enum<E>> E selectFromList(String prompt, Class<E> enumData) {
        // Retrieve all constants from the Enum class
        E[] enumConstants = enumData.getEnumConstants();

        System.out.println(prompt);

        for (int i = 0; i < enumConstants.length; i++) {
            System.out.println((i + 1) + ") " + enumConstants[i]);
        }

        int choice = askUserForInt("Choose an option (1-" + enumConstants.length + "): ", 1, enumConstants.length);
        return enumConstants[choice - 1];
    }

    /**
     * Display a list of options derived from an array of objects. Prompt the user to select an item.
     * If the selection is invalid, display an error and re-prompt.
     *
     * This method is used to have a more complex object array
     * and to display specific attributes of each object (not just String values).
     * The Function<E, String> converter allows to customize the string representation for each item in the array.
     * It returns the selected item from the array, providing flexibility for objects of any type,
     * not just strings or enums.
     *
     * @param prompt    The prompt message to display.
     * @param array     The array of objects to select from.
     * @param <E>       The type of objects in the array.
     * @param converter Function to convert each object in the array to a displayable string.
     * @return The selected item from the array.
     */



    public static <E> E selectFromList(String prompt, E[] array, Function<E, String> converter) {
        // Array to hold the string representations
        String[] values = new String[array.length];

        // Convert each object in the array to a string using the provided converter function
        for (int i = 0; i < array.length; i++) {
            values[i] = (converter.apply(array[i]));
        }

        // Prompt the user to select an item and return the selected item
        return array[selectFromList(prompt, values)];
    }
}

