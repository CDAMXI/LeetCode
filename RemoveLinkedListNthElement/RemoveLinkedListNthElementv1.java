package RemoveLinkedListNthElement;

import _srccode.*;

public class RemoveLinkedListNthElementv1 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        System.out.print("Result 1: ");
        printList(removeElements(list1, 6)); // Expected: 1 -> 2 -> 3 -> 4 -> 5
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.print("Result 2: ");
        printList(removeElements(list2, 6)); // Expected: 1 -> 2 -> 3 -> 4 -> 5
    }

    public static ListNode removeElements(ListNode head, int val){
        ListNode dummy = new ListNode(0, head);
        return dummy.next = removeElements(dummy, head, val);
    }
    private static ListNode removeElements(ListNode prev, ListNode curr, int val) {
        if (curr == null) {return null;}
        if (curr.val == val) {
            prev.next = curr.next;
            return removeElements(prev, curr.next, val);
        } else {
            prev.next = curr;
            return removeElements(curr, curr.next, val);
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
