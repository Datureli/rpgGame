import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Locations.Location> locations;
    private Locations.Location currentLocation;
    private Scanner scanner;

    public Game() {
        locations = Locations.createLocations();
        currentLocation = locations.get(0); // Ustawienie początkowej lokalizacji na pierwszą lokalizację z listy
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        String playerName = PlayerUtils.welcomePlayer();

        while (currentLocation != null) {
            System.out.println("You are at " + currentLocation.name);

            // Sprawdzamy, czy dla bieżącej lokalizacji jest przypisana wiadomość
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
                // Aktualizacja bieżącej lokalizacji na podstawie wyboru gracza
                Locations.Option selectedOption = options.get(choice - 1);
                for (Locations.Location location : locations) {
                    if (selectedOption.optionValue.equals(location.name)) {
                        currentLocation = location;
                        break;
                    }
                }
            } else {
                System.out.println("Invalid choice. Please choose a number from 1 to " + options.size());
            }
        }
    }
}
