import java.io.Console;
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
        Console c = System.console();

        out.println("Anna koko:");
        char[] arr = new char[Integer.parseInt(c.readLine())];
        out.println("Anna merkit:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = c.readLine().charAt(0);
        }

        for (char value : arr) {
            out.print(value);
        }
        out.println();
    }
}
