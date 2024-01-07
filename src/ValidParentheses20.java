/*
 * Idea: Use a stack to store open parentheses while traversing over the string. If we encounter a
 * closed parenthesis, it must close the open parenthesis at the top of the stack.
 * 
 * Time: O(n). Space: O(1).
 */

import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        Map<Character, Character> parenMap = Map.of('(', ')', '{', '}', '[', ']');
        Stack<Character> stack = new Stack<>(); // stores open parentheses

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (parenMap.get(c) != null) { // c is open parenthesis
                stack.push(c);
            } else if (stack.empty()) {
                return false;
            } else if (parenMap.get(stack.pop()) != c) { // c closes the open parenthesis at the top
                return false;
            }
        }
        return stack.empty();
    }
}
