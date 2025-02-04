package sorting;


    public class BubbleSortStudentMarks {

        public static void bubbleSort(int[] marks) {
            int n = marks.length;
            boolean swapped;

            for (int i = 0; i < n - 1; i++) {
                swapped = false; // Flag to check if any swaps occurred in this pass
                for (int j = 0; j < n - i - 1; j++) {
                    if (marks[j] > marks[j + 1]) {
                        // Swap marks[j] and marks[j+1]
                        int temp = marks[j];
                        marks[j] = marks[j + 1];
                        marks[j + 1] = temp;
                        swapped = true; // Set flag to true if a swap occurred
                    }
                }

                // If no swaps occurred in this pass, the array is sorted
                if (!swapped) {
                    break; // Optimization: Exit the outer loop if no swaps
                }
            }
        }

        public static void main(String[] args) {
            int[] studentMarks = {75, 90, 60, 85, 70, 95, 55};

            System.out.println("Unsorted Student Marks:");
            printArray(studentMarks);

            bubbleSort(studentMarks);

            System.out.println("\nSorted Student Marks (Ascending Order):");
            printArray(studentMarks);


            int[] anotherSet = {10, 20, 30, 40, 50}; // Test with already sorted array.
            System.out.println("\nUnsorted Another Set:");
            printArray(anotherSet);
            bubbleSort(anotherSet);
            System.out.println("\nSorted Another Set (Ascending Order):");
            printArray(anotherSet);


            int[] yetAnotherSet = {50, 40, 30, 20, 10}; // Test with reverse sorted array.
            System.out.println("\nUnsorted Yet Another Set:");
            printArray(yetAnotherSet);
            bubbleSort(yetAnotherSet);
            System.out.println("\nSorted Yet Another Set (Ascending Order):");
            printArray(yetAnotherSet);
        }

        // Helper function to print the array elements
        public static void printArray(int[] arr) {
            for (int mark : arr) {
                System.out.print(mark + " ");
            }
            System.out.println();
        }

    }
