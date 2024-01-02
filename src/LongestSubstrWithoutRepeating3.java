/*
 * Idea: Use 2 pointers left, right as the boundaries of the current substring. Try to expand the
 * substring by advancing the right boundary and move the left boundary accordingly to remove
 * duplication. At each iteration, maintain the loop invariant that the current substring is the
 * longest substring that ends at the right pointer.
 * 
 * Time: O(n). Space: O(1).
 */

import java.util.Arrays;

public class LongestSubstrWithoutRepeating3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0;
        int[] charMap = new int[128];
        Arrays.fill(charMap, -1);

        char[] chars = s.toCharArray();
        for (int r = 0; r < chars.length; r++) {
            int prevIdx = charMap[chars[r]];
            if (prevIdx != -1 && prevIdx >= l)
                l = prevIdx + 1;
            charMap[chars[r]] = r;
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        var sol = new LongestSubstrWithoutRepeating3();
        System.out.println(sol.lengthOfLongestSubstring("tmmzsxt")); // 5
        System.out.println(sol.lengthOfLongestSubstring("bbbb")); // 1
        System.out.println(sol.lengthOfLongestSubstring("bbtablud")); // 6
    }
}
