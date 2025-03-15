public class KMPSearch {

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return KMPSearch(s1 + s1, s2) != -1;
    }

    /**
     * Implements the Knuth-Morris-Pratt (KMP) string searching algorithm
     *
     * @param text    the text to search in
     * @param pattern the pattern to search for
     * @return the index of the first occurrence of pattern in text, or -1 if not found
     */
    public static int KMPSearch(String text, String pattern) {
        // Handle edge cases
        if (pattern.isEmpty()) return 0;
        if (text.length() < pattern.length()) return -1;

        // Build the Longest Proper Prefix which is also Suffix array
        int[] lps = buildLpsArray(pattern);

        // Perform the search
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < text.length()) {
            // Characters match, move both pointers forward
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                // Pattern found
                if (j == pattern.length()) {
                    return i - j; // Return the starting index of the match
                }
            } else {
                // Characters don't match
                if (j > 0) {
                    // Use the LPS array to skip comparisons
                    j = lps[j - 1];
                } else {
                    // Move to the next character in text
                    i++;
                }
            }
        }

        return -1; // Pattern not found
    }

    /**
     * Builds the Longest Proper Prefix which is also Suffix array
     *
     * @param pattern the pattern string
     * @return the LPS array
     */
    private static int[] buildLpsArray(String pattern) {
        int[] lps = new int[pattern.length()];

        // Length of the previous longest prefix & suffix
        int length = 0;

        // lps[0] is always 0
        lps[0] = 0;

        // Calculate lps[i] for i = 1 to pattern.length() - 1
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                // Found a match - increment length and save in lps
                lps[i++] = ++length;
            } else {
                // No match
                if (length != 0) {
                    // Look for a shorter prefix that is also a suffix
                    length = lps[length - 1];
                    // Don't increment i here
                } else {
                    // No proper prefix found
                    lps[i++] = 0;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        // Test your implementation
        System.out.println(areRotations("AABAABAAB", "ABAABAABA")); // true
        System.out.println(areRotations("ABCD", "CDBA")); // false
    }
}
