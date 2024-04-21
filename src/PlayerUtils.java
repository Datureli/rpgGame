import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerUtils {
    public static String welcomePlayer() {
        System.out.println("Podaj swoje imię: ");
        Scanner scanner = new Scanner(System.in);
        try {
            String playerName = scanner.nextLine().trim();
            if (!playerName.isEmpty() && playerName.matches("^[a-zA-Z]+$")) {
                System.out.println("Witaj, " + playerName + "!");
                return playerName;
            } else {
                System.out.println("Wprowadzono niepoprawne imię.");
                return null;
            }
        } catch (InputMismatchException e) {
            System.out.println("Błąd: " + e.getMessage());
            return null;
        }
    }
}
