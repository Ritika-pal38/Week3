package linkedlist.singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add items to inventory
        inventory.addItemAtEnd(new Item("Laptop", 101, 5, 800.00));
        inventory.addItemAtBeginning(new Item("Mouse", 102, 20, 15.00));
        inventory.addItemAtPosition(new Item("Keyboard", 103, 10, 50.00), 1);

        // Display inventory
        System.out.println("Inventory:");
        inventory.displayInventory();

        // Calculate and display total value
        System.out.println("\nTotal Inventory Value: " + inventory.calculateTotalValue());

        // Search for item by ID
        Item item = inventory.searchById(102);
        if (item != null) {
            System.out.println("\nItem Found: " + item.itemName);
        } else {
            System.out.println("Item Not Found");
        }

        // Search for item by Name
        item = inventory.searchByName("Keyboard");
        if (item != null) {
            System.out.println("\nItem Found: " + item.itemId);
        } else {
            System.out.println("Item Not Found");
        }

        // Update quantity
        inventory.updateQuantity(101, 3);

        // Remove item
        inventory.removeItemById(102);

        // Display inventory after updates
        System.out.println("\nInventory after updates:");
        inventory.displayInventory();
    }
}
