import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int baseInventorySize = 20;
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size() < baseInventorySize) {
            items.add(item);
            System.out.println("Item added to inventory: " + item);
        } else {
            System.out.println("Inventory is full. Cannot add item: " + item);
        }
    }

    public boolean containsItem(String itemName) {
        for (Item item : items) {
            if (item.itemName.equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    // Dodaj inne metody w zależności od potrzeb, np. usuwanie przedmiotów, wyświetlanie zawartości itp.

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Przykładowe dodanie przedmiotów do inventarza
        inventory.addItem(new Item("Torch", 1, "Pick up torch"));
        inventory.addItem(new Item("Map", 2, "Examine map"));

        // Sprawdzenie, czy przedmiot jest w inventory
        System.out.println("Is Torch in inventory? " + inventory.containsItem("Torch"));
        System.out.println("Is Sword in inventory? " + inventory.containsItem("Sword"));
    }

    public static class Item {
        private String itemName;
        private int itemId;
        private String action;

        public Item(String itemName, int itemId, String action) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.action = action;
        }

        @Override
        public String toString() {
            return "Item: " + itemName + ", ItemId: " + itemId + ", Action: " + action;
        }
    }
}
