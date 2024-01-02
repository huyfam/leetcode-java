/*
 * Idea: Store complements of processed items in a HashMap. If a current item is in the HashMap, it
 * is the complement of a processed item.
 * 
 * Time: O(n). Space: O(n).
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.get(nums[i]) == null) {
                map.put(complement, i);
            } else {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum1 sol = new TwoSum1();
        System.out.println(Arrays.toString(sol.twoSum(new int[] { 5, 1, 3, 8, 7, 6 }, 10))); // [2,4]
    }
}
