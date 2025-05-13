package RemoveNthNodeFromList;

import zrccode.*;

public class RemoveNthNodeFromListv2 {
    public static void main(String[] args) {
        // Test cases
        printListNode(removeNthFromEnd(arrayToListNode(new int[]{1, 2, 3, 4, 5}), 2)); // Removes the second node from the end
        printListNode(removeNthFromEnd(arrayToListNode(new int[]{1, 2, 3, 4, 5}), 5)); // Removes the first node from the end
        printListNode(removeNthFromEnd(arrayToListNode(new int[]{1, 2, 3, 4, 5}), 6)); // Does nothing
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {return head;}

        // Use of a dummy node to handle special cases (deleting the first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Two pointers: fast and slow
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Mover fast n+1 pasos adelante
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head; // n is bigger than the length of the list
            }
            fast = fast.next;
        }

        // Move fast and slow until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static ListNode arrayToListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        // Create the first node (head)
        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        // Go through the array and create nodes for each element
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println(" -> null");
    }
}
