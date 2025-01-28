package linkedlist.circularlinkedlist.roundrobinscheduling;

public class RoundRobinScheduling {
    public static void main(String[] args) {
        int timeQuantum = 2; // Time quantum in milliseconds

        CircularLinkedList readyQueue = new CircularLinkedList();

        // Add processes to the ready queue
        readyQueue.addAtEnd(new Process(1, 8, 2));
        readyQueue.addAtEnd(new Process(2, 4, 1));
        readyQueue.addAtEnd(new Process(3, 5, 3));

        System.out.println("Initial Ready Queue:");
        readyQueue.displayProcesses();

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        // Round Robin Scheduling
        while (!readyQueue.isEmpty()) {
            Process currentProcess = readyQueue.head;

            if (currentProcess.remainingTime > timeQuantum) {
                currentProcess.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
            } else {
                currentTime += currentProcess.remainingTime;
                totalWaitingTime += currentTime - currentProcess.burstTime;
                totalTurnaroundTime += currentTime;
                readyQueue.removeProcessById(currentProcess.processId);
            }

            // Move to the next process in the queue
            readyQueue.head = currentProcess.next;

            System.out.println("Ready Queue after round " + (currentTime / timeQuantum) + ":");
            readyQueue.displayProcesses();
        }

        // Calculate and display average waiting time and turnaround time
        int numberOfProcesses = 3; // Adjust based on the number of processes
        double avgWaitingTime = (double) totalWaitingTime / numberOfProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / numberOfProcesses;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
