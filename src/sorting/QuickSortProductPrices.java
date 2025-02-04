package sorting;

import java.util.Arrays;

public class QuickSortProductPrices {

    public static void quickSort(double[] prices) {
        quickSort(prices, 0, prices.length - 1);
    }

    private static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;

                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i+1] and prices[high] (pivot)
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return (i + 1);
    }


    public static void main(String[] args) {
        double[] productPrices = {29.99, 15.50, 49.95, 9.99, 34.75, 12.25, 55.00, 2.50, 75.99, 20.00};

        System.out.println("Unsorted Product Prices: " + Arrays.toString(productPrices));

        quickSort(productPrices);

        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));

        double[] alreadySorted = {1.0, 2.0, 3.0, 4.0, 5.0};
        quickSort(alreadySorted);
        System.out.println("Sorted Already Sorted: " + Arrays.toString(alreadySorted));

        double[] reverseSorted = {5.0, 4.0, 3.0, 2.0, 1.0};
        quickSort(reverseSorted);
        System.out.println("Sorted Reverse Sorted: " + Arrays.toString(reverseSorted));

        double[] duplicates = {2.0, 1.0, 2.0, 1.0, 2.0};
        quickSort(duplicates);
        System.out.println("Sorted Duplicates: " + Arrays.toString(duplicates));
    }
}
