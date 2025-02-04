package sorting;

public class MergeSortBookPrices {

    public static void mergeSort(double[] prices) {
        if (prices.length <= 1) {
            return; // Base case: already sorted
        }

        int mid = prices.length / 2;
        double[] left = new double[mid];
        double[] right = new double[prices.length - mid];

        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);

        mergeSort(left); // Recursively sort the left half
        mergeSort(right); // Recursively sort the right half

        merge(prices, left, right); // Merge the sorted halves
    }

    private static void merge(double[] prices, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }

        // Copy any remaining elements from left or right
        while (i < left.length) {
            prices[k++] = left[i++];
        }
        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        double[] bookPrices = {15.99, 8.50, 12.75, 25.00, 5.25, 22.99};

        System.out.println("Unsorted Book Prices:");
        printArray(bookPrices);

        mergeSort(bookPrices);

        System.out.println("\nSorted Book Prices (Ascending Order):");
        printArray(bookPrices);


        double[] anotherSet = {10, 20, 30, 40, 50}; // Test with already sorted array.
        System.out.println("\nUnsorted Another Set:");
        printArray(anotherSet);
        mergeSort(anotherSet);
        System.out.println("\nSorted Another Set (Ascending Order):");
        printArray(anotherSet);


        double[] yetAnotherSet = {50, 40, 30, 20, 10}; // Test with reverse sorted array.
        System.out.println("\nUnsorted Yet Another Set:");
        printArray(yetAnotherSet);
        mergeSort(yetAnotherSet);
        System.out.println("\nSorted Yet Another Set (Ascending Order):");
        printArray(yetAnotherSet);

        double[] emptySet = {}; // Test with empty array.
        System.out.println("\nUnsorted Empty Set:");
        printArray(emptySet);
        mergeSort(emptySet);
        System.out.println("\nSorted Empty Set (Ascending Order):");
        printArray(emptySet);

    }

    // Helper function to print the array elements
    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
