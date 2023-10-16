import java.util.ArrayList;
import java.util.List;

public class Level {
    private String name;
    private List<String> locations;
    private List<String[]> options;

    public Level(String name, List<String> locations, List<String[]> options) {
        this.name = name;
        this.locations = locations;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String[]> getOptions() {
        return options;
    }
}
