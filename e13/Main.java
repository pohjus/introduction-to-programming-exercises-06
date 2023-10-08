import java.io.Console;

/**
 * Main class for exercise.
 *
 * @author Jussi Pohjolainen
 */
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
     * Main method - starting point for the app.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
       int money = MONEY_ON_STARTUP;
        boolean shouldIContinue = true;

        while (money > 0 && shouldIContinue) {
            char askInput = getUserInput();
            if (askInput == 'q') {
                shouldIContinue = false;
            } else {
                int bet = askBet();
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
     * @return The amount bet by the user.
     */
    public static int askBet() {
        Console console = System.console();
        System.out.println("Place your bet");
        return Integer.parseInt(console.readLine());
    }

    /**
     * Generates random slot symbols.
     *
     * @return Array of random slot symbols.
     */
    public static char[] randomize() {
        String slots = SLOTS;
        char[] slotsArray = new char[slots.length()];
        for (int i = 0; i < slots.length(); i++) {
            int random = (int) (Math.random() * slots.length());
            slotsArray[i] = slots.charAt(random);
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
        boolean returnValue = true;
        char first = slots[0];
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != first) {
                returnValue = false;
            }
        }
        return returnValue;
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
}
