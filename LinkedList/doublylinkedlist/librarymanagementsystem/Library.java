package linkedlist.doublylinkedlist.librarymanagementsystem;

public class Library {
    Book head;
    Book tail;

    public Library() {
        head = null;
        tail = null;
    }

    // Add book at the beginning
    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at the end
    public void addAtEnd(Book newBook) {
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add book at a specific position
    public void addAtPosition(Book newBook, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;

            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook;
            }

            temp.next = newBook;
        }
    }

    // Remove book by Book ID
    public void removeBookById(int bookId) {
        Book temp = head;

        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found");
        } else {
            if (temp == head) {
                head = temp.next;
            } else {
                temp.prev.next = temp.next;
            }

            if (temp == tail) {
                tail = temp.prev;
            } else {
                temp.next.prev = temp.prev;
            }
        }
    }

    // Search for book by Title
    public Book searchByTitle(String title) {
        Book temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        return temp;
    }

    // Search for book by Author
    public Book searchByAuthor(String author) {
        Book temp = head;
        while (temp != null && !temp.author.equals(author)) {
            temp = temp.next;
        }
        return temp;
    }

    // Update book's availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.isAvailable = isAvailable;
        } else {
            System.out.println("Book not found");
        }
    }

    // Display all books in forward order
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
