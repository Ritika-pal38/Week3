package stackandqueue.circulartour;



import java.util.*;


public class CircularTourProblem {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int total_surplus = 0;
        int current_surplus = 0;
        int start_index = 0;


        for (int i = 0; i < n; i++) {
            int surplus = petrol[i] - distance[i];
            total_surplus += surplus;
            current_surplus += surplus;
            queue.offer(i);


            while (current_surplus < 0 && !queue.isEmpty()) {
                int removedPump = queue.poll();
                current_surplus -= (petrol[removedPump] - distance[removedPump]);
                start_index = removedPump + 1;
            }
        }


        return (total_surplus >= 0) ? start_index : -1;
    }


    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};


        int start = findStartingPoint(petrol, distance);
        System.out.println("Start petrol pump index: " + start);
    }
}

