import java.util.Arrays;
import java.util.List;

public class Locations {
    public static class Location {
        String name;
        List<Option> options;
        Message message;
        List<ItemsInLocation> itemsInLocation;

        public Location(String name, List<Option> options, Message message, List<ItemsInLocation> itemsInLocation) {
            this.name = name;
            this.options = options;
            this.message = message;
            this.itemsInLocation = itemsInLocation;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationName: ").append(name);
            sb.append(", LocationOptions: ").append(options);
            if (message != null) {
                sb.append(", LocationMessage: ").append(message.toMessage());
            }
            return sb.toString();
        }
    }

    public static class Option {
        String optionName;
        String optionValue;

        public Option(String optionName, String optionValue) {
            this.optionName = optionName;
            this.optionValue = optionValue;
        }

        @Override
        public String toString() {
            return "OptionName: " + optionName + ", OptionValue: " + optionValue;
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

    public static class ItemsInLocation {
        String itemName;
        int itemId;

        public ItemsInLocation(String itemName, int itemId) {
            this.itemName = itemName;
            this.itemId = itemId;
        }

        public String toItemInLocation() {
            return itemName;
        }
    }

    public static List<Location> createLocations() {
        return Arrays.asList(
                new Location("Crossroad", Arrays.asList(
                        new Option("Go to the swamps", "Swamps"),
                        new Option("Go to the forest", "Forest")
                ), null, null),
                new Location("Swamps", Arrays.asList(
                        new Option("Check swamps", "SwampCheck"),
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                ), new Message("As you step into the swamps, a dense, misty breeze envelops you, blending the chirping of birds with the croaking of frogs. Scanning your surroundings, you notice dead trees jutting out of the marshland and enchanted vines hanging from branches. In the distance, something glimmers in the sunlight, piquing your curiosity. What do you decide to do?"), null),
                new Location("Forest", Arrays.asList(
                        new Option("Return to the crossroad", "Crossroad"),
                        new Option("Go to the river", "River"),
                        new Option("Go to the swamps", "Swamp")
                ), null, null),
                new Location("River", Arrays.asList(
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                ), null, null)
        );
    }

    public static void main(String[] args) {
        for (Location location : createLocations()) {
            System.out.println(location);
        }
    }
}
