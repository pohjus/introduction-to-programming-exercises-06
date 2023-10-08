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
        int absValue = MathUtils.abs(-7);
        System.out.println(absValue); // 7

        int max = MathUtils.max(10, 20);
        System.out.println(max); // 20

        int random = MathUtils.random(max);
        System.out.println(random); // random number between 0 and 20
    }
}
