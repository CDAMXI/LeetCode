package RemoveLinkedListNthElement;

import zrccode.*;

public class RemoveLinkedListNthElementv2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.print("Result 1: ");
        printList(removeElements(list1, 6)); // Expected: 1 -> 2 -> 3 -> 4 -> 5
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Result 2: ");
        printList(removeElements(list2, 6)); // Expected: 1 -> 2 -> 3 -> 4 -> 5
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
