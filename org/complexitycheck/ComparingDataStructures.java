package org.complexitycheck;
import java.util.*;

public class ComparingDataStructures {

        public static boolean linearSearch(int[] arr, int target) {
            for (int num : arr) {
                if (num == target) {
                    return true;
                }
            }
            return false;
        }

        public static boolean hashing(int[] arr, int target){
            HashSet<Integer> hashSet = new HashSet<>(arr.length);
            for(int i: arr){
                hashSet.add(i);
            }

            return hashSet.contains(target);
        }

        public static boolean balancedBST(int[] arr, int target){
            TreeSet<Integer> treeSet = new TreeSet<>();

            for(int i: arr){
                treeSet.add(i);
            }

            return treeSet.contains(target);
        }

        public static void main(String[] args) {
            int N = 10000;
            int[] array = new int[N];
            Random random = new Random();

            Set<Integer> uniqueNumbers = new HashSet<>();

            while (uniqueNumbers.size() < N) {
                uniqueNumbers.add(random.nextInt(N * 10));
            }

            int index = 0;
            for (int num : uniqueNumbers) {
                array[index++] = num;
            }


            int target = array[N / 2];

            long startTime = System.nanoTime();
            boolean foundInArray = linearSearch(array, target);
            long endTime = System.nanoTime();
            System.out.println("Time taken by array's linear search: " + (endTime - startTime));

            startTime = System.nanoTime();
            boolean foundInHashSet = hashing(array, target);
            endTime = System.nanoTime();
            System.out.println("Time taken by hashset's hashing: " + (endTime - startTime));

            startTime = System.nanoTime();
            boolean foundInTreeSet = balancedBST(array, target);
            endTime = System.nanoTime();
            System.out.println("Time taken by treeset's balanced BST: " + (endTime - startTime));
        }

    }

