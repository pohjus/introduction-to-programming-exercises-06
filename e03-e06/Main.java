import static java.lang.System.out;

/**
 * Main class for exercise.
 *
 * @author Jussi Pohjolainen
 */
public class Main {
    /**
     * Main method - starting point for the app.
     *
     * @param args Command line arguments
     */
    public static void main(final String[] args) {
        final int someNumber = 1;

        tulostaPaivamaara();
        out.println(palautaPaivamaara());
        out.println(jaa(someNumber, someNumber));
        out.println(toista('x', itseisarvo(someNumber)));
    }

    /**
     * Calculates the absolute value of given int.
     *
     * @param a an argument
     * @return returns abs value of a
     */
    public static int itseisarvo(final int a) {
        return (a < 0) ? -a : a;
    }

    /**
     * Repeats the given char amount of times and returns
     * that as a String.
     *
     * @param character character to be repeteated
     * @param amount amount of times character is repeated
     * @return String containing given chars amount of times
     */
    public static String toista(final char character, final int amount) {
        String temp = "";
        for (int i = 0; i < amount; i++) {
            temp = temp + character;
        }
        return temp;
    }


    /**
     * Divides given arguments.
     *
     * @param a an argument
     * @param b another argument
     * @return returns a / b
     */
    public static double jaa(final int a, final int b) {
        return (double) a / b;
    }

    /**
     * Outputs static string.
     */
    public static void tulostaPaivamaara() {
        out.println("2023-10-08");
    }

    /**
     * Returns a static string.
     *
     * @return a static string
     */
    public static String palautaPaivamaara() {
        return ("2023-10-08");
    }

}
