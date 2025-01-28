package linkedlist.singlylinkedlist.studentrecordmanagement;

class LinkedList {
    Student head;

    public LinkedList() {
        head = null;
    }

    // Add student at the beginning
    public void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at the end
    public void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
    }

    // Add student at a specific position
    public void addAtPosition(Student newStudent, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addAtBeginning(newStudent);
            return;
        }

        Student temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    // Delete student by Roll Number
    public void deleteByRollNo(int rollNo) {
        Student temp = head;
        Student prev = null;

        if (temp != null && temp.rollNo == rollNo) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.rollNo != rollNo) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Student not found");
        } else {
            prev.next = temp.next;
        }
    }

    // Search for student by Roll Number
    public Student searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null && temp.rollNo != rollNo) {
            temp = temp.next;
        }
        return temp;
    }

    // Display all student records
    public void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Update student's grade
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = searchByRollNo(rollNo);
        if (temp != null) {
            temp.grade = newGrade;
        } else {
            System.out.println("Student not found");
        }
    }
}

