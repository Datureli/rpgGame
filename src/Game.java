import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Level> levels = new ArrayList<>();
    private int currentLevelIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        String[] levelNames = Locations.levelNames;
        String[][] levelOptions = Locations.levelOptions;

        for (int i = 0; i < levelNames.length; i++) {
            List<String> locations = new ArrayList<>();
            locations.add(levelNames[i]);
            List<String[]> options = new ArrayList<>();
            options.add(levelOptions[i]);
            levels.add(new Level("Poziom " + (i + 1), locations, options));
        }
    }

    public void startGame() {
        String playerName = PlayerUtils.welcomePlayer();

        while (currentLevelIndex < levels.size()) {
            Level currentLevel = levels.get(currentLevelIndex);
            System.out.println("Jesteś na " + currentLevel.getName());

            List<String> locations = currentLevel.getLocations();
            List<String[]> options = currentLevel.getOptions();

            for (int i = 0; i < options.size(); i++) {
                String locationName = locations.get(i);
                System.out.println((i + 1) + ". " + locationName);
            }

            System.out.println("Wybierz opcję (1-" + options.size() + "): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= options.size()) {
                String[] chosenOptions = options.get(choice - 1);
                System.out.println("Jesteś teraz w lokalizacji: " + chosenOptions[0]); // Wyświetl aktualną lokalizację

                if (chosenOptions.length > 1) {
                    System.out.println("Dostępne opcje:");

                    for (int i = 0; i < chosenOptions.length; i++) {
                        System.out.println((i + 1) + ". " + chosenOptions[i]);
                    }

                    System.out.println("Wybierz opcję (1-" + chosenOptions.length + "): ");
                    int optionChoice = scanner.nextInt();

                    if (optionChoice >= 1 && optionChoice <= chosenOptions.length) {
                        // Zaktualizuj aktualny poziom na podstawie wyboru
                        currentLevelIndex++;
                    }
                } else {
                    System.out.println("Gratulacje, ukończyłeś poziom " + currentLevel.getName() + "!");
                    currentLevelIndex++; // Przejdź do następnego poziomu
                }
            } else {
                System.out.println("Nieprawidłowy wybór. Wybierz numer od 1 do " + options.size());
            }
        }
        System.out.println("Gratulacje, ukończyłeś wszystkie poziomy gry!");
    }
}
