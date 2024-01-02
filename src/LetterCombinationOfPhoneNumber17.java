/*
 * Idea: Use dfs to explore all possible combinations.
 * 
 * Time: O(4^n). Space: O(n^2) for recursive call stack.
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {
    private String[] phoneMap = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
            "wxyz" };

    public void dfs(String combin, String nextDigits, List<String> res) {
        if (nextDigits.length() == 0) {
            res.add(combin);
            return;
        }
        String s = phoneMap[nextDigits.charAt(0) - '2'];
        for (int i = 0; i < s.length(); i++) {
            dfs(combin + s.charAt(i), nextDigits.substring(1), res);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() > 0) {
            dfs("", digits, res);
        }
        return res;
    }

    public static void main(String[] args) {
        var sol = new LetterCombinationOfPhoneNumber17();
        System.out.println(sol.letterCombinations("23"));
        System.out.println("");
    }
}
