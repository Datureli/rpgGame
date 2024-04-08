import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Locations {
    public static class Location {
        String name;
        List<Option> options;
        Message message;

        public Location(String name, List<Option> options, Message message) {
            this.name = name;
            this.options = options;
            this.message = message;
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

    public static List<Location> createLocations() {
        return Arrays.asList(
                new Location("Crossroad", Arrays.asList(
                        new Option("Go to the swamps", "Swamps"),
                        new Option("Go to the forest", "Forest")
                ), null),
                new Location("Swamps", Arrays.asList(
                        new Option("Check swamps", "SwampCheck"),
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                ), new Message("s")),
                new Location("Forest", Arrays.asList(
                        new Option("Return to the crossroad", "Crossroad"),
                        new Option("Go to the river", "River"),
                        new Option("Go to the swamps", "Swamp")
                ), null),
                new Location("River", Arrays.asList(
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                ), null)
        );
    }

    public static void main(String[] args) {
        for (Location location : createLocations()) {
            System.out.println(location);
        }
    }
}
