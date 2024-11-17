package CA_2;

//Imports
import CA_2.UI.Menu;
import CA_2.Utils.Reader;
import CA_2.Utils.Store;

/**
 * Main class
 */
public class Main {
    /**
     * Entry point
     *
     * @param args startup arguments
     */
    public static void main(String[] args) {

        System.out.println("Start of program");

        // Read file and return parsed people
        Store.people = Reader.readFile();

        // Start menu loop
        Menu.showMenu();

        System.out.println("End of program");
    }
}
