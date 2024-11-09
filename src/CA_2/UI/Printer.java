package CA_2.UI;

import CA_2.Models.Company;
import CA_2.Models.Person;

import java.util.ArrayList;


/**
 * Class with static methods for printing different objects
 */
public class Printer {
    /**
     *
     */
    public static void printCompanies(ArrayList<Company> companies) {
        if (companies == null || companies.isEmpty()) {
            // Print "No data" message if the list is empty
            System.out.println("* There's no companies *");
            // Exit the method, as there's nothing to print
            return;
        }
        // Loop through each person in the list
        for (int i = 0; i < companies.size(); i++) {
            // Print each company’s information on a new line with a number
            // (e.g., "1) Company details here")
            System.out.println((i + 1) + ") " + companies.get(i).toString());
        }
    }
    /**
     * Method to print a list of people or their subclasses.
     *
     * @param people List of people to print.
     */
    public static void printPeople(ArrayList<Person> people) {
        // Check if the list is null or empty
        // If there are no people in the list, display a message and exit the method
        if (people == null || people.isEmpty()) {
            // Print "No data" message if the list is empty
            System.out.println("* No data *");
            // Exit the method, as there's nothing to print
            return;
        }

        // Loop through each person in the list
        for (int i = 0; i < people.size(); i++) {
            // Print each person’s information on a new line with a number
            // (e.g., "1) Person details here")
            System.out.println((i + 1) + ") " + people.get(i).toString());
        }
    }

    /**
     * Method to print a specified number of people from the list, up to a maximum of `topN`.
     *
     * @param people List of people to print.
     * @param topN   Number of people to print, starting from the top of the list.
     */
    public static void printPeople(ArrayList<Person> people, int topN) {
        // Check if the list is null or empty
        // If the list has no data, print a message and exit
        if (people == null || people.isEmpty()) {
            // Indicate that there’s no data in the list
            System.out.println("* No data *");
            // Exit the method as there's nothing to print
            return;
        }

        // If topN is less than the total size of the list,
        // show a message indicating only the first 'topN' items will be printed
        if (topN < people.size()) {
            System.out.println("(Showing first " + topN + " out of " + people.size() + ")");
        }

        // Determine how many people to print: either topN or the full list, whichever is smaller
        int countToPrint = Math.min(topN, people.size());

        // Loop through each person up to the determined count and print their information
        for (int i = 0; i < countToPrint; i++) {
            // Print each person's details with a numbered format (e.g., "1) Person details here")
            System.out.println((i + 1) + ") " + people.get(i).toString());
        }
    }
}
