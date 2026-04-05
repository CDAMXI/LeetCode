package RotateList;

import _srccode.ListNode;

public class RotateListv2 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode rotated = rotateRight(head, 2);
        ListNode.printList(rotated); // Expected: 4 -> 5 -> 1 -> 2 -> 3
    }

    /**
     * Rotate the list to the right by k steps.
     * Time: O(n), Space: O(1)
     */
    public static ListNode rotateRight(ListNode head, int k) {
        // Trivial cases
        if (head == null || head.next == null || k == 0) return head;

        // 1) Compute length and get tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // 2) Normalize k (in case k >= n, if k == n, no rotation needed)
        k %= n;
        if (k == 0) return head;

        // 3) Make it circular
        tail.next = head;

        // 4) New tail is at position (n - k - 1) from the head
        int stepsToNewTail = n - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5) Break the circle and return new head
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
