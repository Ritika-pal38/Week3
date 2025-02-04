package sorting;

import java.util.Arrays;

public class HeapSortJobApplicants {

    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        // Build heap (rearrange array) - from bottom up
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(salaries, n, i);

        // One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // A recursive function to max heapify a subtree rooted at i
    // n is size of heap
    private static void heapify(double[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && salaries[l] > salaries[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && salaries[r] > salaries[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        double[] jobSalaries = {60000, 75000, 55000, 80000, 70000, 90000, 45000, 65000};

        System.out.println("Unsorted Job Salaries: " + Arrays.toString(jobSalaries));

        heapSort(jobSalaries);

        System.out.println("Sorted Job Salaries: " + Arrays.toString(jobSalaries));

        double[] alreadySorted = {10000, 20000, 30000, 40000, 50000};
        heapSort(alreadySorted);
        System.out.println("Sorted Already Sorted: " + Arrays.toString(alreadySorted));

        double[] reverseSorted = {50000, 40000, 30000, 20000, 10000};
        heapSort(reverseSorted);
        System.out.println("Sorted Reverse Sorted: " + Arrays.toString(reverseSorted));

        double[] duplicates = {25000, 15000, 25000, 15000, 25000};
        heapSort(duplicates);
        System.out.println("Sorted Duplicates: " + Arrays.toString(duplicates));

        double[] empty = {};
        heapSort(empty);
        System.out.println("Sorted Empty: " + Arrays.toString(empty));
    }
}

