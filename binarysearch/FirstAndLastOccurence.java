package org.example.binarysearch;
import java.util.*;
public class FirstAndLastOccurence {

    public static int[] findFirstLast(int[] arr, int target) {
        int first = -1;
        int last = -1;

        // Find first occurrence
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Search left for first occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Find last occurrence
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Search right for last occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[] {first, last};
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = findFirstLast(arr1, target1);
        System.out.println("First and last occurrence of " + target1 + ": " + result1[0] + ", " + result1[1]); // Output: 3, 4

        int target2 = 6;
        int[] result2 = findFirstLast(arr1, target2);
        System.out.println("First and last occurrence of " + target2 + ": " + result2[0] + ", " + result2[1]); // Output: -1, -1

        int[] arr2 = {1,2,2,2,2,2,3};
        int target3 = 2;
        int[] result3 = findFirstLast(arr2, target3);
        System.out.println("First and last occurrence of " + target3 + ": " + result3[0] + ", " + result3[1]); // Output: 1, 5

        int[] arr3 = {1,2,3,4,5};
        int target4 = 6;
        int[] result4 = findFirstLast(arr3, target4);
        System.out.println("First and last occurrence of " + target4 + ": " + result4[0] + ", " + result4[1]); // Output: -1, -1

        int[] arr4 = {1,2,3,4,5};
        int target5 = 1;
        int[] result5 = findFirstLast(arr4, target5);
        System.out.println("First and last occurrence of " + target5 + ": " + result5[0] + ", " + result5[1]); // Output: 0, 0

    }
}



