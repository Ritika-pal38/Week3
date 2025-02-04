package hashmapsandfunctions.customhashmap;
import java.util.*;
public class HashMapClone{
private static final int SIZE = 1000; // Number of buckets
private LinkedList<Node>[] map;


// Node class to store key-value pairs
static class Node {
    int key, value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


// Constructor: Initialize buckets
public HashMapClone() {
    map = new LinkedList[SIZE];
    for (int i = 0; i < SIZE; i++) {
        map[i] = new LinkedList<>();
    }
}


// Hash function to get bucket index
private int hash(int key) {
    return key % SIZE;
}


// Insert or update a key-value pair
public void put(int key, int value) {
    int index = hash(key);
    for (Node node : map[index]) {
        if (node.key == key) {
            node.value = value; // Update value if key exists
            return;
        }
    }
    map[index].add(new Node(key, value)); // Insert new node
}


// Retrieve value associated with a key
public int get(int key) {
    int index = hash(key);
    for (Node node : map[index]) {
        if (node.key == key) {
            return node.value;
        }
    }
    return -1; // Key not found
}


// Remove a key-value pair
public void remove(int key) {
    int index = hash(key);
    map[index].removeIf(node -> node.key == key);
}
}

