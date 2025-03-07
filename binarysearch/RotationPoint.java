package org.example.binarysearch;
public class RotationPoint {

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // To avoid potential overflow

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return arr[left]; // or arr[right], they are the same when the loop terminates
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int min1 = findMin(arr1);
        System.out.println("Minimum element in arr1: " + min1); // Output: 0

        int[] arr2 = {11, 13, 15, 17};
        int min2 = findMin(arr2);
        System.out.println("Minimum element in arr2: " + min2); // Output: 11

        int[] arr3 = {2,1};
        int min3 = findMin(arr3);
        System.out.println("Minimum element in arr3: " + min3); // Output: 1

        int[] arr4 = {1,2,3,4,5};
        int min4 = findMin(arr4);
        System.out.println("Minimum element in arr4: " + min4); // Output: 1

    }
}