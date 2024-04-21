import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Locations {
    public static class Location {
        String name;
        List<Option> options;
        Message message;
        List<Item> items;

        public Location(String name, List<Option> options, Message message, List<Item> items) {
            this.name = name;
            this.options = options;
            this.message = message;
            this.items = items;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationName: ").append(name);
            sb.append(", LocationOptions: ").append(options);
            if (message != null) {
                sb.append(", LocationMessage: ").append(message.toMessage());
            }
            if (items != null && !items.isEmpty()) {
                sb.append(", Items: ").append(items);
            }
            return sb.toString();
        }
    }

    public static class Option {
        String optionName;
        String optionValue;
        boolean isPickable; // Dodatkowe pole, które określa czy opcja jest możliwa do podniesienia

        public Option(String optionName, String optionValue, boolean isPickable) {
            this.optionName = optionName;
            this.optionValue = optionValue;
            this.isPickable = isPickable;
        }

        @Override
        public String toString() {
            return "OptionName: " + optionName + ", OptionValue: " + optionValue;
        }
    }

    public static class Item {
        String itemName;
        int itemId;
        String action;

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

    public static class Message {
        String appearMessage;

        public Message(String appearMessage) {
            this.appearMessage = appearMessage;
        }

        public String toMessage() {
            return appearMessage;
        }
    }

    public static List<Location> createLocations() {
        List<Location> locations = new ArrayList<>();
        // Lokalizacja: Crossroad
        Location crossroad = new Location("Crossroad", Arrays.asList(
                new Option("Go to the swamps", "Swamps", true), // true oznacza, że opcja jest możliwa do podniesienia
                new Option("Go to the forest", "Forest", true)
        ), null, null);
        locations.add(crossroad);

        // Lokalizacja: Swamps
        Location swamps = new Location("Swamps", Arrays.asList(
                new Option("Pick up torch", "SwampCheck", true),
                new Option("Go to the forest", "Forest", false),
                new Option("Return to the crossroad", "Crossroad", false) // false oznacza, że opcja nie jest możliwa do podniesienia, gdyż już została podniesiona
        ), new Message("As you step into the swamps, a dense, misty breeze envelops you, blending the chirping of birds with the croaking of frogs. Scanning your surroundings, you notice dead trees jutting out of the marshland and enchanted vines hanging from branches. In the distance, something glimmers in the sunlight, piquing your curiosity. What do you decide to do?"), Arrays.asList(
                new Item("Torch", 1, "Pick up torch"),
                new Item("Map", 2, "Examine map")
        ));
        locations.add(swamps);

        // Lokalizacja: Forest
        Location forest = new Location("Forest", Arrays.asList(
                new Option("Return to the crossroad", "Crossroad", true),
                new Option("Go to the river", "River", true),
                new Option("Go to the swamps", "Swamps", true)
        ), null, null);
        locations.add(forest);

        // Lokalizacja: River
        Location river = new Location("River", Arrays.asList(
                new Option("Go to the forest", "Forest", true),
                new Option("Return to the crossroad", "Crossroad", true)
        ), null, null);
        locations.add(river);

        return locations;
    }

    public static void main(String[] args) {
        for (Location location : createLocations()) {
            System.out.println(location);
        }
    }
}
