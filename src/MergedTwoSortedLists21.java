/*
 * Idea: Similar to the merge subroutine in MergeSort.
 * 
 * Time: O(|list1|+|list2|). Space: O(1).
 */

public class MergedTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode mergedList = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        if (list1 != null) {
            mergedList.next = list1;
        }
        if (list2 != null) {
            mergedList.next = list2;
        }
        return dummyHead.next;
    }
}
