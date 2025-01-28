package linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Add movies
        list.addAtEnd(new Movie("The Shawshank Redemption", "Frank Darabont", 1994, 9.3));
        list.addAtBeginning(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9.2));
        list.addAtPosition(new Movie("The Dark Knight", "Christopher Nolan", 2008, 9.0), 1);

        // Display movies
        System.out.println("Movies in forward order:");
        list.displayForward();

        System.out.println("\nMovies in reverse order:");
        list.displayReverse();

        // Search for movie
        Movie movie = list.searchByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("\nMovie Found: " + movie.title);
        } else {
            System.out.println("\nMovie Not Found");
        }

        // Remove movie
        list.removeByTitle("The Godfather");

        // Update rating
        list.updateRating("The Shawshank Redemption", 9.4);

        // Display movies after deletion and update
        System.out.println("\nMovies after deletion and update:");
        list.displayForward();
    }
}


