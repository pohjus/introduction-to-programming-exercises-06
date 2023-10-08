/**
 * StringHelper provides utility methods for string operations.
 */
class StringHelper {

    /**
     * Converts an array of strings to an array of integers.
     *
     * @param stringArray Array of strings to convert.
     * @return An array of integers parsed from the input strings.
     */
    public static int[] toIntArray(final String[] stringArray) {
        int[] array = new int[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }

    /**
     * Splits a string by commas.
     *
     * @param original The string to split.
     * @return An array of strings, split by commas.
     */
    public static String[] split(final String original) {
        return split(original, ',');
    }

    /**
     * Splits a string by a given separator.
     *
     * @param original The string to split.
     * @param separator The character to split by.
     * @return An array of strings, split by the separator.
     */
    public static String[] split(final String original, final char separator) {
        original = original + separator;

        int numberOfWords = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == separator) {
                numberOfWords++;
            }
        }
        String[] array = new String[numberOfWords];
        String word = "";
        int index = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != separator) {
                word += original.charAt(i);
            } else {
                array[index] = word;
                word = "";
                index++;
            }
        }
        return array;
    }

    /**
     * Checks if two strings are equal.
     *
     * @param a The first string.
     * @param b The second string.
     * @return true if the strings are equal, false otherwise.
     */
    public static boolean equals(final String a, final String b) {
        boolean returnValue = true;
        if (a.length() != b.length()) {
            returnValue = false;
        } else {
            for (int i = 0; i < a.length() && returnValue; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }

    /**
     * Checks if string 'a' contains string 'b'.
     *
     * @param a The string to search in.
     * @param b The string to search for.
     * @return true if 'a' contains 'b', false otherwise.
     */
    public static boolean contains(final String a, final String b) {
        boolean returnValue = false;
        if (b.length() > a.length()) {
            returnValue = false;
        } else if (a.equals(b)) {
            returnValue = true;
        } else {
            for (int i = 0; i <= a.length() - b.length(); i++) {
                String subString = split(a, i, b.length());
                if (subString.equals(b)) {
                    returnValue = true;
                }
            }
        }
        return returnValue;
    }

    /**
     * Splits a string from a given index for a given amount of characters.
     *
     * @param original The string to split.
     * @param index The starting index.
     * @param amount The number of characters to include.
     * @return A substring from index containing 'amount' characters.
     */
    private static String split(final String original,
                                final int index,
                                final int amount) {
        String newString = "";
        int i = index;
        int j = 0;
        while (i < original.length() && j < amount) {
            newString += original.charAt(i);
            i++;
            j++;
        }
        return newString;
    }
}
