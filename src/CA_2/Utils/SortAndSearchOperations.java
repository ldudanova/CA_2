package CA_2.Utils;

import CA_2.Models.Person;
import CA_2.UI.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class SortAndSearchOperations {
    /**
     * Method for recursive insertion sort array of people
     *
     * @param array     array for sorting
     * @param n         length of sorting on current iteration
     * @param direction order of sorting
     */
    private static void recursiveInsertionSort(Person[] array, int n, Menu.sortingDirection direction) {
        // Base case: if there's only one element, it's already "sorted"
        if (n <= 1) {
            return;
        }

        // Recursively sort the first n-1 elements
        recursiveInsertionSort(array, n - 1, direction);

        // Insert the last element at its correct position in the sorted portion
        Person last = array[n - 1];
        int j = n - 2;

        // Shift elements as needed based on sorting direction
        while (j >= 0 && (direction == Menu.sortingDirection.ASC && array[j].compareTo(last) > 0 ||
                direction == Menu.sortingDirection.DESC && array[j].compareTo(last) < 0)) {
            array[j + 1] = array[j];
            j--;
        }

        // Place the last element in its correct position
        array[j + 1] = last;
    }

    /**
     * Method wrapper on recursive insertion sort
     * Copying list of people into array and sorting the new array
     * Doesn't sort original list!
     *
     * @param people    list of people
     * @param direction order of sorting
     * @return copy of original list but sorted
     */
    public static ArrayList<Person> recursiveInsertionSort(ArrayList<Person> people, Menu.sortingDirection direction) {
        // Copying list of people into array
        Person[] array = new Person[people.size()];
        array = people.toArray(array);

        // Call recursive insertion sort on the new array
        recursiveInsertionSort(array, array.length, direction);

        return new ArrayList<>(Arrays.asList(array));
    }
}
