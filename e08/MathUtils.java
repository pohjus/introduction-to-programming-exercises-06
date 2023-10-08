/**
 * MathUtils class provides simple mathematical operations.
 */
public class MathUtils {

    /**
     * Calculates the absolute value of an integer.
     *
     * @param x The integer whose absolute value is to be found.
     * @return The absolute value of the integer.
     */
    public static int abs(final int x) {
        return (x < 0) ? -x : x;
    }

    /**
     * Determines the maximum of two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The maximum of the two integers.
     */
    public static int max(final int a, final int b) {
        return (a > b) ? a : b;
    }

    /**
     * Generates a random integer between 0 and a given maximum.
     *
     * @param max The maximum value for the random number.
     * @return A random integer between 0 and the maximum value.
     */
    public static int random(final int max) {
        return (int) (Math.random() * (max + 1));
    }
}
