/*
 * Idea: Merge subroutine proccesses from right to left in order to populate sorted item into the
 * end of nums1.
 * 
 * Time: O(m + n) worst case. Space: O(1) worst case.
 */

public class MergeSortedArrays88 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1; // pointer of nums1
            int j = n - 1; // pointer of nums2
            int k = m + n - 1; // pointer to populate sorted item into nums1
    
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
    
            // While i >= 0, do nothing since the remained items of nums1 are already in place
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}
