package org.example.binarysearch;

public class PeakElement {

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Handle edge cases where mid might be the first or last element
            int leftNeighbor = (mid > 0) ? arr[mid - 1] : Integer.MIN_VALUE;
            int rightNeighbor = (mid < arr.length - 1) ? arr[mid + 1] : Integer.MIN_VALUE;

            if (arr[mid] > leftNeighbor && arr[mid] > rightNeighbor) {
                return arr[mid]; // Found a peak
            } else if (arr[mid] < leftNeighbor) {
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        }

        return -1; // No peak found (shouldn't happen in a valid peak array)
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1};
        int peak1 = findPeak(arr1);
        System.out.println("Peak in arr1: " + peak1); // Output: 3

        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        int peak2 = findPeak(arr2);
        System.out.println("Peak in arr2: " + peak2); // Output: 2 or 6 (either is valid)

        int[] arr3 = {1,2,3,4,5};
        int peak3 = findPeak(arr3);
        System.out.println("Peak in arr3: " + peak3); // Output: 5

        int[] arr4 = {5,4,3,2,1};
        int peak4 = findPeak(arr4);
        System.out.println("Peak in arr4: " + peak4); // Output: 5
    }
}
