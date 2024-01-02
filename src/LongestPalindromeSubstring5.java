/*
 * Idea: Iterate over all possible center positions, try to expand the palindrome substring from the
 * center.
 * 
 * Time: O(n^2). Space: O(1).
 */

public class LongestPalindromeSubstring5 {
    public static String longestPalindrome(String s) {
        int begIndex = 0;
        int endIndex = 0;
        int maxLength = 0;

        // Consider centers at characters
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            for (; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) != s.charAt(i + j))
                    break;
            }
            int curLength = 2 * j - 1;
            if (curLength > maxLength) {
                maxLength = curLength;
                begIndex = i - j + 1;
                endIndex = i + j - 1;
            }
        }

        // Consider centers between characters
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 1;
            for (; i - j + 1 >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j + 1) != s.charAt(i + j))
                    break;
            }
            int curLength = 2 * j - 2;
            if (curLength > maxLength) {
                maxLength = curLength;
                begIndex = i - j + 2;
                endIndex = i + j - 1;
            }
        }
        return s.substring(begIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba")); // abba
        System.out.println(longestPalindrome("abbac")); // abba
        System.out.println(longestPalindrome("abad")); // aba
    }
}
