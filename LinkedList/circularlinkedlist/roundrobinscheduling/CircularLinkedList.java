package linkedlist.circularlinkedlist.roundrobinscheduling;

public class CircularLinkedList {
    Process head;

    public CircularLinkedList() {
        head = null;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add process at the end
    public void addAtEnd(Process newProcess) {
        if (isEmpty()) {
            head = newProcess;
            head.next = head; // Circular link
        } else {
            newProcess.next = head;
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
        }
    }

    // Remove process by Process ID
    public void removeProcessById(int processId) {
        if (isEmpty()) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        Process prev = null;

        do {
            if (temp.processId == processId) {
                if (prev == null) { // Removing the head
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }

                if (temp == head) { // Only one node in the list
                    head = null;
                }

                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Display all processes in the circular queue
    public void displayProcesses() {
        if (isEmpty()) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.print("[" + temp.processId + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
