import java.util.Arrays;
import java.util.List;

public class Locations {
    public static class Location {
        String name;
        List<Option> options;

        public Location(String name, List<Option> options) {
            this.name = name;
            this.options = options;
        }

        @Override
        public String toString() {
            return "LocationName: " + name + ", LocationOptions: " + options.toString();
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

    public static List<Location> createLocations() {
        return Arrays.asList(
                new Location("Crossroad", Arrays.asList(
                        new Option("Go to the swamps", "Swamps"),
                        new Option("Go to the forest", "Forest")
                )),
                new Location("Swamps", Arrays.asList(
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                )),
                new Location("Forest", Arrays.asList(
                        new Option("Return to the crossroad", "Crossroad"),
                        new Option("Go to the river", "River"),
                        new Option("Go to the swamps", "Swamp")
                )),
                new Location("River", Arrays.asList(
                        new Option("Go to the forest", "Forest"),
                        new Option("Return to the crossroad", "Crossroad")
                ))
        );
    }

    public static void main(String[] args) {
        for (Location location : createLocations()) {
            System.out.println(location);
        }
    }
}
