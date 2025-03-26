package RemoveDuplicatesFromList;

import srccode.*;

public class RemoveDuplicatesFromListv3 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        printList(deleteDuplicates(list));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Jumps the duplicate node
            } else {
                current = current.next; // Goes to the next node only if there is no duplicate
            }
        }
        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    
}
