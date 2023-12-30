/*
 * Time: O(1). Space: O(1).
 */

public class IntToRoman12 {
    public String intToRoman(int num) {
        var values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        var romanNumerals = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                "V", "IV", "I" };
        var sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new IntToRoman12();
        System.out.println(sol.intToRoman(98)); // XCVIII
    }
}
