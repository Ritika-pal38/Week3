package linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentRecord {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add students
        list.addAtEnd(new Student(1, "Aryan", 18, 'A'));
        list.addAtBeginning(new Student(2, "Hema", 19, 'B'));
        list.addAtPosition(new Student(3, "Charlie", 17, 'C'), 1);

        // Display students
        System.out.println("All Students:");
        list.display();

        // Search for student
        Student student = list.searchByRollNo(2);
        if (student != null) {
            System.out.println("Student Found: " + student.name);
        } else {
            System.out.println("Student Not Found");
        }

        // Delete student
        list.deleteByRollNo(1);

        // Update grade
        list.updateGrade(3, 'B');

        // Display students after deletion and update
        System.out.println("\nStudents after deletion and update:");
        list.display();
    }
}

