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
}

