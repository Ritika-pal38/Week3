package org.example.binarysearch;

import java.util.Arrays;

public class LinearVsBinary {

    public static int findMissingPositive(int[] nums) {
        int n = nums.length;

        // Mark numbers as visited using negative marking
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                int index = Math.abs(nums[i]) - 1;
                nums[index] = -Math.abs(nums[index]); // Mark as negative
            }
        }

        // Find the first positive number (not marked)
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1; // All numbers from 1 to n are present
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        int missing1 = findMissingPositive(nums1);
        System.out.println("Missing positive: " + missing1); // Output: 3

        int[] nums2 = {3, 4, -1, 1};
        int missing2 = findMissingPositive(nums2);
        System.out.println("Missing positive: " + missing2); // Output: 2

        int[] nums3 = {7, 8, 9, 11, 12};
        int missing3 = findMissingPositive(nums3);
        System.out.println("Missing positive: " + missing3); // Output: 1

        int[] nums4 = {1,2,3};
        int missing4 = findMissingPositive(nums4);
        System.out.println("Missing positive: " + missing4); // Output: 4


        int[] sortedNums = {2, 5, 7, 8, 11, 12};
        int target1 = 8;
        int index1 = binarySearch(sortedNums, target1);
        System.out.println("Index of " + target1 + ": " + index1); // Output: 3

        int target2 = 10;
        int index2 = binarySearch(sortedNums, target2);
        System.out.println("Index of " + target2 + ": " + index2); // Output: -1


        int[] sortedNums2 = {1};
        int target3 = 1;
        int index3 = binarySearch(sortedNums2, target3);
        System.out.println("Index of " + target3 + ": " + index3); // Output: 0

        int[] sortedNums3 = {};
        int target4 = 1;
        int index4 = binarySearch(sortedNums3, target4);
        System.out.println("Index of " + target4 + ": " + index4); // Output: -1

    }
}
