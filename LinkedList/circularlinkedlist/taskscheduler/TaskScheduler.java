package linkedlist.circularlinkedlist.taskscheduler;

public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList scheduler = new CircularLinkedList();

        // Add tasks
        scheduler.addAtEnd(new Task(1, "Task 1", 2, "2024-12-31"));
        scheduler.addAtBeginning(new Task(2, "Task 2", 1, "2024-12-25"));
        scheduler.addAtPosition(new Task(3, "Task 3", 3, "2025-01-05"), 1);

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View and move to the next task
        System.out.println("\nCurrent Task and Move to Next:");
        scheduler.viewAndMoveNext();
        System.out.println("All Tasks after moving to next:");
        scheduler.displayAllTasks();

        // Search for tasks by priority
        System.out.println("\nTasks with Priority 2:");
        scheduler.searchByPriority(2);

        // Remove a task
        scheduler.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        scheduler.displayAllTasks();
    }


}
