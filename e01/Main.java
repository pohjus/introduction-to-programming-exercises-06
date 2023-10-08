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

        final int arrSize = 10;
        int[] arr = new int[arrSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(c.readLine());
        }

        for (int value : arr) {
            out.println(value);
        }
    }
}
