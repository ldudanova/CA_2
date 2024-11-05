package CA_2.Utils;

import CA_2.Models.Person;

// Importing ArrayList for dynamic array functionality
import java.util.ArrayList;


public class Reader {

    /**
     * Method for prompting the user to enter a file name and then reading data from that file.
     *
     * @return ArrayList of Person objects containing data read from the file.
     */
    public static ArrayList<Person> readFile() {

        // ArrayList to store Person objects read from the file
        ArrayList<Person> people = new ArrayList<>();

        // Default filename to be used if the user provides no input
        String defaultFileName = "Applicants_Form.txt";

        // Boolean flag indicating whether the file has been successfully read
        boolean fileHasBeenRead = false;

        // Loop to repeatedly prompt the user until a valid file is read
        do {


        } while (!fileHasBeenRead); // Repeat the loop until a valid file is successfully read

        // Return the list of Person objects read from the file
        return people;
    }
}
