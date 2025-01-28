package linkedlist.singlylinkedlist.socialmediafriendconnections;

import java.util.*;
import java.util.ArrayList;
public class SocialNetworkMain {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        network.addUser(new User(1, "Alice", 25));
        network.addUser(new User(2, "Bob", 28));
        network.addUser(new User(3, "Charlie", 22));

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);

        network.displayFriends(1); // Output: Friends of User 1: 2 3

        List<Integer> mutualFriends = network.findMutualFriends(1, 2);
        System.out.println("Mutual friends of User 1 and User 2: " + mutualFriends); // Output: Mutual friends of User 1 and User 2: [2, 3]

        network.removeFriendConnection(1, 3);
        network.displayFriends(1); // Output: Friends of User 1: 2

        System.out.println("Number of friends of User 2: " + network.countFriends(2)); // Output: Number of friends of User 2: 1
    }

}
