package sorting;

public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;

        for (int i = 1; i < n; ++i) {
            int key = employeeIDs[i]; // The current element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
            employeeIDs[j + 1] = key; // Insert the key into its correct position
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {5, 2, 9, 1, 5, 6};

        System.out.println("Unsorted Employee IDs:");
        printArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.println("\nSorted Employee IDs (Ascending Order):");
        printArray(employeeIDs);

        int[] anotherSet = {10, 20, 30, 40, 50}; // Test with already sorted array.
        System.out.println("\nUnsorted Another Set:");
        printArray(anotherSet);
        insertionSort(anotherSet);
        System.out.println("\nSorted Another Set (Ascending Order):");
        printArray(anotherSet);


        int[] yetAnotherSet = {50, 40, 30, 20, 10}; // Test with reverse sorted array.
        System.out.println("\nUnsorted Yet Another Set:");
        printArray(yetAnotherSet);
        insertionSort(yetAnotherSet);
        System.out.println("\nSorted Yet Another Set (Ascending Order):");
        printArray(yetAnotherSet);
    }

    // Helper function to print the array elements
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}
