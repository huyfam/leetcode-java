/*
 * Idea: Use a dummy head to simplify implementation. Compute digits of the sum for each decimal
 * place while keep track of the carry. Time: O(|l1|+|l2|). Space: O(1).
 */

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode sumList = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            sumList.next = new ListNode(carry % 10);
            sumList = sumList.next;
            carry /= 10;
        }
        return dummyHead.next;
    }
}
