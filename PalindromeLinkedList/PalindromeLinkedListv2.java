package PalindromeLinkedList;

import srccode.*;

public class PalindromeLinkedListv2 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 2, 1});
        System.out.print("Input: ");
        ListNode.printList(head);
        System.out.println("Output: " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle (slow will point to midpoint)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow);

        // 3. Compare both halves
        ListNode p1 = head, p2 = secondHalf;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore the list (optional)
        reverse(secondHalf);

        return isPalindrome;
    }

    // Reverse a linked list and return new head
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
