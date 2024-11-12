package CA_2.Utils;

import CA_2.Models.*;

// Importing necessary libraries
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

    /**
     * Reads data from a specified file and returns a list of `Person` objects.
     * <p>
     * The `readFile` method prompts the user for a file name and reads data from that file to create
     * an `ArrayList` of `Person` objects. This method is designed to provide a structured way of
     * importing employee or applicant data, which is especially useful for companies looking to
     * integrate bulk data management into their application. By centralizing the file reading process
     * in this class, the program achieves a single point of data input, making future updates to file
     * handling simpler and more efficient. Additionally, it ensures that data is read, parsed, and
     * formatted consistently, which is critical for maintaining data integrity across the application.
     * <p>
     * Use Cases:
     * - **HR Staff**: This method can be valuable for HR staff or administrative users who need to
     * import a list of applicants or employees from external sources. For example, after a recruitment
     * drive, data from applicants could be saved to a text file and then uploaded to the system
     * without manual data entry.
     * - **IT Department**: IT staff responsible for maintaining employee databases may also use this
     * method for bulk uploads, helping to streamline onboarding or periodic data updates.
     * <p>
     * Importance:
     * - This class plays an essential role in the program’s architecture by enabling automated data import.
     * - Reduces the potential for manual errors and ensures that large datasets can be quickly added to the
     * system, enhancing both speed and reliability in data management.
     * - The `Reader` class is designed to handle common file input challenges such as missing or
     * improperly formatted data, improving program robustness and user experience.
     *
     * @return ArrayList of `Person` objects containing data read from the file.
     */
    public static ArrayList<Person> readFile() {

        // Initializes an ArrayList to store Person objects, representing individuals read from the file.
        // This dynamic array allows the method to flexibly handle varying numbers of entries.
        ArrayList<Person> people = new ArrayList<>();

        // Default filename to use if no input is provided by the user.
        // Using a default name allows the method to have a fallback, ensuring the program can continue
        // without requiring specific input every time.
        String defaultFileName = "Applicants_Form.txt";

        // Boolean flag indicating whether the file has been successfully read.
        // This variable is crucial for controlling the loop and ensuring that only valid data is processed.
        boolean fileHasBeenRead = false;

        // Loop to repeatedly prompt the user until a valid file is read.
        // Using a `do-while` loop ensures the program keeps asking for a valid file until one is provided.
        // This approach enhances user experience by allowing repeated attempts, reducing the likelihood
        // of errors or program termination due to missing files.
        do {
            // Prompts the user to enter a filename or type "exit" to quit the program.
            // This interaction adds flexibility, giving the user control over the program's operation.
            String fileName = InputUtilities.askUserForText("Enter the filename to read (type \"exit\" to quit):");

            // Checks if the user has entered "exit" (case-insensitive) to terminate the program.
            // This condition provides an easy way for the user to exit gracefully, improving usability.
            if (fileName.trim().equalsIgnoreCase("exit")) {
                System.out.println("End of program");
                // Terminates the program if the user chooses to exit.
                System.exit(0);
            }

            // Checks if the user input is empty. If so, uses the default filename.
            // By using a default name, the program can proceed even if no input is provided, ensuring
            // functionality in cases where a user forgets to specify a file.
            if (fileName.isEmpty()) {
                System.out.println("Entered value is empty. Default file name \"" + defaultFileName + "\" is used");
                fileName = defaultFileName;
            }

            // Attempting to open and read the specified file within a try-catch block to handle potential
            // I/O errors and ensure that the program can handle unexpected issues gracefully.
            try (FileReader fileReader = new FileReader(fileName)) {
                Scanner fileScanner = new Scanner(fileReader);

                // List to store each line read from the file, representing the raw data to be processed.
                ArrayList<String> rows = new ArrayList<>();

                // Reads each line of the file and stores it in the `rows` list.
                // This step allows the method to capture all data before parsing, simplifying error handling.
                while (fileScanner.hasNextLine()) {
                    rows.add(fileScanner.nextLine());
                }

                // Processes each line in the file, starting from the second line to skip the header.
                // Skipping the header ensures only actual data rows are processed, preventing errors
                // from interpreting the header as data.
                for (int i = 1; i < rows.size(); i++) {
                    // Retrieves the current line to be processed.
                    String row = rows.get(i);

                    // Only processes rows containing commas, indicating data separation.
                    // This condition acts as a simple validation step, ensuring only valid rows are processed.
                    if (row.contains(",")) {
                        try {
                            // Splits the row into individual data points based on commas.
                            String[] parts = row.split(",");

                            String companyName = parts[8];
                            Company currentCompany;
                            Department currentDepartment;

                            currentCompany = Store.getOrCreateCompany(companyName);

                            String departmentName = parts[5];

                            currentDepartment = currentCompany.getOrCreateDepartment(departmentName);

                            // Creates a new Person object using the parsed data and adds it to the list.
                            // Each Person instance represents a specific individual, using their first name,
                            // last name, email, and gender as identifiers.
                            people.add(new Employee(
                                    parts[0], // First name
                                    parts[1], // Last name
                                    parts[3], //Email
                                    Gender.parse(parts[2]), // Gender
                                    Double.parseDouble(parts[4]), //Salary
                                    EmployeePosition.parse(parts[6]), //Position
                                    currentDepartment //Department
                            ));

                            // Sets the flag to true, indicating successful data processing.
                            // This flag allows the program to break out of the loop once data has been read.
                            fileHasBeenRead = true;
                        } catch (Exception e) {
                            // Catches and logs errors for individual rows, allowing the program to
                            // continue processing the remaining lines. This design choice improves robustness.
                            System.err.println("Parsing error for " + row + "; Error: " + e.getMessage());
                        }
                    }
                }

                // Checks if at least one valid row was read; displays success or error messages accordingly.
                // This feedback helps users understand whether their input was correctly processed.
                if (fileHasBeenRead) {
                    System.out.println("File \"" + fileName + "\" read successfully\n");
                } else {
                    System.err.println("No valid data in the file \"" + fileName + "\". Try again\n");
                }

            } catch (Exception e) {
                // Catches and handles file I/O errors, displaying error messages to inform the user
                // of any issues with the specified file. This design choice promotes user-friendly error handling.
                System.err.println("Error: " + e.getMessage() + "\n");
                // Resets the flag, as the file could not be read successfully.
                fileHasBeenRead = false;
            }

        } while (!fileHasBeenRead); // Loop continues until a valid file has been read successfully.

        // Returns the populated list of Person objects, making it available for further processing.
        return people;
    }
}
