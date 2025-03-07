package org.example.binarysearch;

public class TargetValueIn2DArray {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // Handle empty matrix case
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // Avoid overflow
            int row = mid / cols;
            int col = mid % cols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target1 = 5;
        System.out.println("Found 5 in matrix1: " + searchMatrix(matrix1, target1)); // Output: true

        int target2 = 20;
        System.out.println("Found 20 in matrix1: " + searchMatrix(matrix1, target2)); // Output: false


        int[][] matrix2 = {{1,3}};
        int target3 = 3;
        System.out.println("Found 3 in matrix2: " + searchMatrix(matrix2, target3)); // Output: true

        int[][] matrix3 = {{1}};
        int target4 = 2;
        System.out.println("Found 2 in matrix3: " + searchMatrix(matrix3, target4)); // Output: false

        int[][] matrix4 = {};
        int target5 = 2;
        System.out.println("Found 2 in matrix4: " + searchMatrix(matrix4, target5)); // Output: false

    }
}
