import java.util.Arrays;
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
        // do all tests
        testToIntArray();
        testEquals();
        testSplit();
        testContains();
    }

    /**
     * Exercise 09.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void testToIntArray() {
        out.println("TEST: testToIntArray()");
        String[] strArr = {"1", "2", "3"};
        int[] expectedIntArr = {1, 2, 3};

        int[] result = StringHelper.toIntArray(strArr);
        out.println(Arrays.equals(result, expectedIntArr)
                                  ? "  pass" : "  fail");
    }

    /**
     * Exercise 10.
     */
    public static void testEquals() {
        out.println("TEST: testEquals()");
        out.println(StringHelper.equals("abc", "abc") ? "  pass" : "  fail");
        out.println(!StringHelper.equals("abcd", "abc") ? "  pass" : "  fail");
        out.println(!StringHelper.equals("xabc", "abc") ? "  pass" : "  fail");
        out.println(!StringHelper.equals("abc", "xabc") ? "  pass" : "  fail");
    }

    /**
     * Exercise 11.
     */
    public static void testSplit() {
        out.println("TEST: testSplit()");

        String[] expectedStrArr1 = {"tiina", "pekka", "kalle"};
        String[] result1 = StringHelper.split("tiina,pekka,kalle");

        String[] expectedStrArr2 = {"a", "tiina", "pekka", "kalle"};
        String[] result2 = StringHelper.split("a,tiina,pekka,kalle");

        String[] expectedStrArr3 = {"a", "tiina", "pekka", "kalle"};
        String[] result3 = StringHelper.split("a:tiina:pekka:kalle", ':');

        out.println(Arrays.equals(result1, expectedStrArr1)
                                  ? "  pass" : "  fail");
        out.println(Arrays.equals(result2, expectedStrArr2)
                                  ? "  pass" : "  fail");
        out.println(Arrays.equals(result3, expectedStrArr3)
                                  ? "  pass" : "  fail");

    }

    /**
     * Exercise 12.
     */
    public static void testContains() {
        out.println("TEST: testContains()");
        out.println(StringHelper.contains("koirarotu", "raro")
                                          ? "  pass" : "  fail");
        out.println(!StringHelper.contains("koirarotu", "tampio")
                                           ? "  pass" : "  fail");
        out.println(StringHelper.contains("abc", "ab")
                                          ? "  pass" : "  fail");
        out.println(StringHelper.contains("abc", "bc")
                                          ? "  pass" : "  fail");
        out.println(StringHelper.contains("abcd", "bc")
                                          ? "  pass" : "  fail");
        out.println(StringHelper.contains("abc", "abc")
                                          ? "  pass" : "  fail");
        out.println(!StringHelper.contains("abc", "abcd")
                                           ? "  pass" : "  fail");
    }
}
