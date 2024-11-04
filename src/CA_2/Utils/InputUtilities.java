package CA_2.Utils;

import java.util.Scanner;

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


}

