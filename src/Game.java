import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Locations.Location> locations;
    private Locations.Location currentLocation;
    private final Scanner scanner;
    private final Inventory inventory;


    public Game() {
        locations = Locations.createLocations();
        currentLocation = locations.get(0);
        scanner = new Scanner(System.in);
        inventory = new Inventory();
    }

    public void startGame() {
        String playerName;

        do {
            playerName = PlayerUtils.welcomePlayer();
        } while (playerName == null);

        while (currentLocation != null) {
            System.out.println("You are at " + currentLocation.name);

            if (currentLocation.message != null) {
                System.out.println(currentLocation.message.toMessage());
            }

            List<Locations.Option> options = currentLocation.options;

            for (int i = 0; i < options.size(); i++) {
                Locations.Option option = options.get(i);
                System.out.println((i + 1) + ". " + option.optionName);
            }

            System.out.println("Choose an option (1-" + options.size() + "): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= options.size()) {
                Locations.Option selectedOption = options.get(choice - 1);
                handleOption(selectedOption);
            } else {
                System.out.println("Invalid choice. Please choose a number from 1 to " + options.size());
            }
        }
    }

    private void handleOption(Locations.Option option) {
        String optionValue = option.optionValue;
        for (Locations.Location location : locations) {
            if (optionValue.equals(location.name)) {
                if (location.items != null && !location.items.isEmpty()) {
                    for (Locations.Item item : location.items) {
                        if (option.optionName.equals(item.action)) {
                            if (item.action.equals("Pick up torch")) {
                                // Jeśli akcja to "Pick up torch", dodaj przedmiot do inventory
                                inventory.addItem(new Inventory.Item(item.itemName, item.itemId, item.action));
                                System.out.println("Torch added to inventory.");
                            } else {
                                System.out.println("Invalid action.");
                            }
                        }
                    }
                }
                currentLocation = location;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
