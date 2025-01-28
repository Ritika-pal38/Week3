package linkedlist.doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addAtEnd(new Book("The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 101, true));
        library.addAtBeginning(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 102, true));
        library.addAtPosition(new Book("1984", "George Orwell", "Dystopian", 103, false), 1);

        // Display books
        System.out.println("Books in forward order:");
        library.displayForward();

        System.out.println("\nBooks in reverse order:");
        library.displayReverse();

        // Search for book
        Book book = library.searchByAuthor("J.R.R. Tolkien");
        if (book != null) {
            System.out.println("\nBook Found: " + book.title);
        } else {
            System.out.println("\nBook Not Found");
        }

        // Update book availability
        library.updateAvailability(102, false);

        // Remove book
        library.removeBookById(103);

        // Count books
        System.out.println("\nTotal number of books: " + library.countBooks());

        // Display books after updates
        System.out.println("\nBooks after updates:");
        library.displayForward();
    }
}
