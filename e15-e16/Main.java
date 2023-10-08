import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;


public class Main {
    /**
     * Symbols for the slot machine.
     */
    static final String SLOTS = "@!#";


    /**
     * Initial money for the player.
     */
    static final int MONEY_ON_STARTUP = 25;

    /**
     * Number of highscores.
     */
    static final int NUMBER_OF_HIGHSCORES = 5;

    /**
     * Highscores.
     */
    static final int[] HIGHSCORES = new int[NUMBER_OF_HIGHSCORES];

    /**
     * Main method - starting point for the app.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        try {
            readHighScores();
        } catch (IOException e) {
            System.out.println("Error reading high scores: " + e.getMessage());
        }


        boolean globalContinue = true;

        while (globalContinue) {
            int money = MONEY_ON_STARTUP;
            boolean shouldIContinue = true;

            while (money > 0 && shouldIContinue) {
                char askInput = getUserInput();
                if (askInput == 'q') {
                    shouldIContinue = false;
                } else {
                    int bet = askBet(money);
                    money -= bet;
                    char[] slots = randomize();
                    boolean win = checkWin(slots);
                    if (win) {
                        System.out.println("YOU WON!");
                        money += 2 * bet;
                    }
                    printSlots(slots);
                    printMoneySituation(money);
                }
            }
            updateHighScores(money);
            printHighScores();

            Console console = System.console();
            System.out.println("New game? (y) = yes, (n) = exit");
            char nextGame = console.readLine().charAt(0);
            globalContinue = (nextGame == 'y');

            try {
                writeHighScores();
            } catch (IOException e) {
                System.out.println("Error writing high scores: "
                    + e.getMessage());
            }
        }
    }

    /**
     * Asks the user if they want to play or quit.
     *
     * @return 'p' if play, 'q' if quit.
     */
    public static char getUserInput() {
        Console console = System.console();
        System.out.println("Wanna play? (p) = play, (q) = quit");
        return console.readLine().charAt(0);
    }

    /**
     * Asks the user to place a bet.
     *
     * @param currentMoney the current money of the user.
     * @return The amount bet by the user.
     */
    public static int askBet(final int currentMoney) {
        Console console = System.console();
        int bet;
        do {
            System.out.println("Place your bet (max " + currentMoney + " €)");
            bet = Integer.parseInt(console.readLine());
            if (bet > currentMoney) {
                System.out.println("Bet exceeds available money. Try again.");
            }
        } while (bet > currentMoney);
        return bet;
    }

    /**
     * Generates random slot symbols.
     *
     * @return Array of random slot symbols.
     */
    public static char[] randomize() {
        char[] slotsArray = new char[SLOTS.length()];
        for (int i = 0; i < SLOTS.length(); i++) {
            int random = (int) (Math.random() * SLOTS.length());
            slotsArray[i] = SLOTS.charAt(random);
        }
        return slotsArray;
    }

    /**
     * Checks if the user wins based on slot symbols.
     *
     * @param slots Array of slot symbols.
     * @return true if all slot symbols are the same, otherwise false.
     */
    public static boolean checkWin(final char[] slots) {
        char first = slots[0];
        for (int i = 1; i < slots.length; i++) {
            if (slots[i] != first) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints the current money situation.
     *
     * @param money Current money of the player.
     */
    public static void printMoneySituation(final int money) {
        System.out.println("You have " + money + " €");
    }

    /**
     * Prints the slot symbols.
     *
     * @param slots Array of slot symbols.
     */
    public static void printSlots(final char[] slots) {
        System.out.println(java.util.Arrays.toString(slots));
    }

    /**
     * Updates the highscores.
     *
     * @param money the money to be saved
     */
    public static void updateHighScores(final int money) {
        for (int i = 0; i < HIGHSCORES.length; i++) {
            if (money > HIGHSCORES[i]) {
                for (int j = HIGHSCORES.length - 1; j > i; j--) {
                    HIGHSCORES[j] = HIGHSCORES[j - 1];
                }
                HIGHSCORES[i] = money;
                break;
            }
        }
    }


    /**
     * Prints high scores.
     */
    public static void printHighScores() {
        System.out.println("High Scores: " + Arrays.toString(HIGHSCORES));
    }

    /**
     * Reads high scores from a file.
     * @throws IOException If file reading fails.
     */
    public static void readHighScores() throws IOException {
        Path path = Paths.get("high_scores.txt");
        if (Files.exists(path)) {
            String scoresString = Files.readString(path);
            String[] scores = scoresString.split(",");
            for (int i = 0; i < HIGHSCORES.length; i++) {
                HIGHSCORES[i] = Integer.parseInt(scores[i]);
            }
        }
    }

    /**
     * Writes high scores to a file.
     * @throws IOException If file writing fails.
     */
    public static void writeHighScores() throws IOException {
        Path path = Paths.get("high_scores.txt");
        String scoresString = "";
        for (int i = 0; i < HIGHSCORES.length; i++) {
            scoresString += HIGHSCORES[i];
            if (i < HIGHSCORES.length - 1) {
                scoresString += ",";
            }
        }
        Files.writeString(path, scoresString);
    }
}
