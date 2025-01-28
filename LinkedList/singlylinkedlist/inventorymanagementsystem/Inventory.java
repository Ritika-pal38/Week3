package linkedlist.singlylinkedlist.inventorymanagementsystem;

public class Inventory {
    Item head;

    public Inventory() {
        head = null;
    }

    // Add item at the beginning
    public void addItemAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addItemAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add item at a specific position
    public void addItemAtPosition(Item newItem, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addItemAtBeginning(newItem);
            return;
        }

        Item temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove item by Item ID
    public void removeItemById(int itemId) {
        Item temp = head;
        Item prev = null;

        if (temp != null && temp.itemId == itemId) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found");
        } else {
            prev.next = temp.next;
        }
    }

    // Update quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null && temp.itemId != itemId) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.quantity = newQuantity;
        } else {
            System.out.println("Item not found");
        }
    }

    // Search for item by Item ID
    public Item searchById(int itemId) {
        Item temp = head;
        while (temp != null && temp.itemId != itemId) {
            temp = temp.next;
        }
        return temp;
    }

    // Search for item by Item Name
    public Item searchByName(String itemName) {
        Item temp = head;
        while (temp != null && !temp.itemName.equals(itemName)) {
            temp = temp.next;
        }
        return temp;
    }

    // Calculate and display total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0.0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }

    // Sort inventory by Item Name (ascending)
    public void sortByNameAscending() {
        // Implement merge sort or other suitable sorting algorithm
        // ...
    }

    // Sort inventory by Item Name (descending)
    public void sortByNameDescending() {
        // Implement merge sort or other suitable sorting algorithm
        // ...
    }

    // Sort inventory by Price (ascending)
    public void sortByPriceAscending() {
        // Implement merge sort or other suitable sorting algorithm
        // ...
    }

    // Sort inventory by Price (descending)
    public void sortByPriceDescending() {
        // Implement merge sort or other suitable sorting algorithm
        // ...
    }

    // Display all items in the inventory
    public void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}
