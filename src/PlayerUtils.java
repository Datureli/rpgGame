import java.util.Scanner;

public class PlayerUtils {
    public static String welcomePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imię: ");
        String playerName = scanner.nextLine();
        System.out.println("Witaj, " + playerName + "!");
        return playerName;
    }
}
