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
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(final String[] args) {
        int[] test = {1, 2, 3, 4};
        out.println(laskeKeskiarvo(test));
    }

    /**
     * Calculates the average of given array.
     *
     * @param arr int array
     * @return average of the given int array
     */
    public static double laskeKeskiarvo(final int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    }
}
