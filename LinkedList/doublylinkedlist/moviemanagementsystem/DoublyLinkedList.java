package linkedlist.doublylinkedlist.moviemanagementsystem;

public class DoublyLinkedList {
    Movie head;
    Movie tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add movie at the beginning
    public void addAtBeginning(Movie newMovie) {
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addAtEnd(Movie newMovie) {
        if (head == null) {
            head = newMovie;
            tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addAtPosition(Movie newMovie, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addAtBeginning(newMovie);
            return;
        }

        Movie temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;

            if (temp.next != null) {
                temp.next.prev = newMovie;
            } else {
                tail = newMovie;
            }

            temp.next = newMovie;
        }
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
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

    // Search for movie by director
    public Movie searchByDirector(String director) {
        Movie temp = head;
        while (temp != null && !temp.director.equals(director)) {
            temp = temp.next;
        }
        return temp;
    }

    // Search for movie by rating
    public Movie searchByRating(double rating) {
        Movie temp = head;
        while (temp != null && temp.rating != rating) {
            temp = temp.next;
        }
        return temp;
    }

    // Display all movies in forward order
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update movie's rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.rating = newRating;
        } else {
            System.out.println("Movie not found");
        }
    }
}

