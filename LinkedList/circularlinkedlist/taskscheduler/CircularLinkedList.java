package linkedlist.circularlinkedlist.taskscheduler;

public class CircularLinkedList {
    Task head;

    public CircularLinkedList() {
        head = null;
    }

    // Check if the list is empty
    private boolean isEmpty() {
        return head == null;
    }

    // Add task at the beginning
    public void addAtBeginning(Task newTask) {
        if (isEmpty()) {
            head = newTask;
            head.next = head; // Circular link
        } else {
            newTask.next = head;
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            head = newTask;
        }
    }

    // Add task at the end
    public void addAtEnd(Task newTask) {
        if (isEmpty()) {
            head = newTask;
            head.next = head; // Circular link
        } else {
            newTask.next = head;
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
    }

    // Add task at a specific position
    public void addAtPosition(Task newTask, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        for (int i = 0; temp.next != head && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Position out of bounds");
        } else {
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    // Remove task by Task ID
    public void removeByTaskId(int taskId) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == taskId) {
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

        System.out.println("Task with ID " + taskId + " not found");
    }

    // View current task and move to the next
    public Task viewAndMoveNext() {
        if (isEmpty()) {
            System.out.println("No tasks available");
            return null;
        }

        Task current = head;
        System.out.println("Current Task:");
        System.out.println("Task ID: " + current.taskId);
        System.out.println("Task Name: " + current.taskName);
        System.out.println("Priority: " + current.priority);
        System.out.println("Due Date: " + current.dueDate);

        head = current.next;
        return current;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (isEmpty()) {
            System.out.println("No tasks to display");
            return;
        }

        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchByPriority(int priority) {
        if (isEmpty()) {
            System.out.println("No tasks to search");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}
