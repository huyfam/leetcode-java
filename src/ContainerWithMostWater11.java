/*
 * Idea: Two pointers. We have 2 pointers l < r that start at both ends of the array. We iteratively
 * either increase i or decrease j in the hope to increase area(i,j) and update maxArea accordingly.
 * We maintain the loop invariant that after each iteration, all containers that has one end is the
 * index among {i,j} with lower height have been considered.
 * 
 * Time: O(n) since we either increase i or decrease j once and we do that n times. Space: O(1).
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int curArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(curArea, maxArea);
            if (height[l] < height[r])
                l += 1;
            else
                r -= 1;
        }
        return maxArea;
    }
}
