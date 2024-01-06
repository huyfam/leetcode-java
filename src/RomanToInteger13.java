/*
 * Idea: Sum all roman digits from left to right. If a roman digit is smaller than the next one, we
 * have to subtract it from the sum.
 * 
 * Time: O(n). Space: O(1).
 */

import java.util.HashMap;

public class RomanToInteger13 {
    public int romanToInt(String s) {
        var romanMap = new HashMap<Character, Integer>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int num = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                num -= romanMap.get(s.charAt(i));
            } else {
                num += romanMap.get(s.charAt(i));
            }
        }
        // Last roman digit doesn't have the next digit, we have to deal with it separately
        num += romanMap.get(s.charAt(s.length() - 1));
        return num;
    }

    public static void main(String[] args) {
        var sol = new RomanToInteger13();
        System.out.println(sol.romanToInt("XIX")); // 19
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }
}