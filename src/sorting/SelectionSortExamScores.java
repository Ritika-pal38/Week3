package sorting;

import java.util.Arrays;

public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (scores[j] < scores[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element of the unsorted subarray
            int temp = scores[min_idx];
            scores[min_idx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {85, 70, 92, 65, 80, 78, 95, 60, 75, 88};

        System.out.println("Unsorted Exam Scores: " + Arrays.toString(examScores));

        selectionSort(examScores);

        System.out.println("Sorted Exam Scores: " + Arrays.toString(examScores));

        int[] alreadySorted = {1, 2, 3, 4, 5};
        selectionSort(alreadySorted);
        System.out.println("Sorted Already Sorted: " + Arrays.toString(alreadySorted));

        int[] reverseSorted = {5, 4, 3, 2, 1};
        selectionSort(reverseSorted);
        System.out.println("Sorted Reverse Sorted: " + Arrays.toString(reverseSorted));

        int[] duplicates = {2, 1, 2, 1, 2};
        selectionSort(duplicates);
        System.out.println("Sorted Duplicates: " + Arrays.toString(duplicates));

        int[] empty = {};
        selectionSort(empty);
        System.out.println("Sorted Empty: " + Arrays.toString(empty));
    }
}
