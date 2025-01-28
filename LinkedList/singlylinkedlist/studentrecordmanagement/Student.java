package linkedlist.singlylinkedlist.studentrecordmanagement;

public class Student {

        int rollNo;
        String name;
        int age;
        char grade;
        Student next;

        public Student(int rollNo, String name, int age, char grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

