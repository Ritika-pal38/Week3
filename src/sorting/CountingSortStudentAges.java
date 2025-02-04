package sorting;

import java.util.Arrays;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        int[] output = new int[n];
        int[] count = new int[9]; // Ages range from 10 to 18 (9 possible ages)

        // Initialize count array to 0
        for (int i = 0; i < 9; ++i) {
            count[i] = 0;
        }

        // Store count of each age
        for (int i = 0; i < n; ++i) {
            count[ages[i] - 10]++; // Subtract 10 to map ages to indices 0-8
        }

        // Change count[i] so that count[i] now contains actual
        // position of this age in output array
        for (int i = 1; i < 9; ++i) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = 0; i < n; ++i) {
            output[count[ages[i] - 10] - 1] = ages[i];
            count[ages[i] - 10]--;  // Decrement count to handle duplicates correctly
        }

        // Copy the output array back to ages
        for (int i = 0; i < n; ++i) {
            ages[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {15, 12, 17, 14, 16, 13, 18, 11, 10, 15, 12, 17}; // Added duplicates

        System.out.println("Unsorted Student Ages: " + Arrays.toString(studentAges));

        countingSort(studentAges);

        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));

        int[] alreadySorted = {10, 11, 12, 13, 14, 15, 16, 17, 18};
        countingSort(alreadySorted);
        System.out.println("Sorted Already Sorted: " + Arrays.toString(alreadySorted));

        int[] reverseSorted = {18, 17, 16, 15, 14, 13, 12, 11, 10};
        countingSort(reverseSorted);
        System.out.println("Sorted Reverse Sorted: " + Arrays.toString(reverseSorted));

        int[] duplicates = {12, 15, 12, 15, 12};
        countingSort(duplicates);
        System.out.println("Sorted Duplicates: " + Arrays.toString(duplicates));

        int[] empty = {};
        countingSort(empty);
        System.out.println("Sorted Empty: " + Arrays.toString(empty));
    }
}
