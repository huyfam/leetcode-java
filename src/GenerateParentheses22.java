/*
 * Idea: dfs + pruning to search over all possibilities.
 * 
 * Time: O(|result|). Space: O((2*n)^2) for recursive call stack.
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public void dfs(String s, int numOpen, int numClosed, int n, List<String> res) {
        if (numOpen == n && numClosed == n) {
            res.add(s);
            return;
        }
        // If numOpen < n, then we can add an open parenthesis
        if (numOpen < n) {
            dfs(s + '(', numOpen + 1, numClosed, n, res);
        }
        // If numOpen > numClosed, then we can add a closed parenthesis
        if (numOpen > numClosed) {
            dfs(s + ')', numOpen, numClosed + 1, n, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs("", 0, 0, n, res);
        return res;
    }
}
