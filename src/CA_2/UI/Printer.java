package CA_2.UI;

import CA_2.Models.Company;
import CA_2.Models.Person;

import java.util.ArrayList;


/**
 * The Printer class contains static methods for outputting information about various objects that are contained in the application. For example, Company or Employee.
 * <p>This class includes methods that display lists of objects and/or their data.
 * <h2>Use Examples:</h2>
 * <ul>
 * <li>Display a list of the names of all existing companies in the application</li>
 * <li>Display detailed information about each company</li>
 * <li>Sort the list of people</li>
 * </ul>
 * <p>The Printer class is designed to facilitate data visualisation in the application interface.
 */
public class Printer {
    /**
     * Prints the names of all companies in the provided list in a numbered format.
     *
     * @param companies list of existing companies or a message "No companies" if there's no companies to display.
     */
    public static void printCompanyNames(ArrayList<Company> companies) {
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
     * Prints detailed information of all companies in the provided list in a numbered format.
     *
     * @param companies list of existing companies
     *                  or a message "No companies" if there's no companies to display.
     */
    public static void printCompaniesData(ArrayList<Company> companies) {
        if (companies == null || companies.isEmpty()) {
            // Print "No data" message if the list is empty
            System.out.println("* There's no companies *");
            // Exit the method, as there's nothing to print
            return;
        }
        System.out.println("Companies: ");
        // Loop through each person in the list
        for (int i = 0; i < companies.size(); i++) {
            // Print each company’s information on a new line with a number
            // (e.g., "1) Company details here")
            companies.get(i).print(i + 1, " ");
        }
    }

    /**
     * Prints a specified number of people from the list, up to a maximum of topN.
     *
     * <p>This method displays detailed information for each person in the list.
     *
     * @param people a list of Person objects to be printed;
     * @param topN   the number of entries to display.
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
