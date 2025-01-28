package linkedlist.singlylinkedlist.socialmediafriendconnections;
import java.util.*;
public class SocialNetwork {
    UserNode head;

    public SocialNetwork() {
        head = null;
    }

    public void addUser(User user) {
        UserNode newUserNode = new UserNode(user);
        if (head == null) {
            head = newUserNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUserNode;
        }
    }

    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1Node = findUserById(userId1);
        UserNode user2Node = findUserById(userId2);

        if (user1Node != null && user2Node != null) {
            user1Node.user.friendIds.add(userId2);
            user2Node.user.friendIds.add(userId1);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1Node = findUserById(userId1);
        UserNode user2Node = findUserById(userId2);

        if (user1Node != null && user2Node != null) {
            user1Node.user.friendIds.remove(Integer.valueOf(userId2));
            user2Node.user.friendIds.remove(Integer.valueOf(userId1));
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public java.util.List<java.lang.Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1Node = findUserById(userId1);
        UserNode user2Node = findUserById(userId2);
        java.util.List<Integer> mutualFriends = new ArrayList<>();

        if (user1Node != null && user2Node != null) {
            for (int friendId : user1Node.user.friendIds) {
                if (user2Node.user.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        UserNode userNode = findUserById(userId);

        if (userNode != null) {
            System.out.println("Friends of User " + userId + ":");
            for (int friendId : userNode.user.friendIds) {
                System.out.print(friendId + " ");
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }

    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.user.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.user.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public int countFriends(int userId) {
        UserNode userNode = findUserById(userId);
        if (userNode != null) {
            return userNode.user.friendIds.size();
        }
        return 0;
    }
}
