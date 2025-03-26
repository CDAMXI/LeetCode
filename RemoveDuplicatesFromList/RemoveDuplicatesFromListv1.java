package RemoveDuplicatesFromList;

import srccode.*;
public class RemoveDuplicatesFromListv1 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);

        printList(deleteDuplicates(list));
        list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(4);

        printList(deleteDuplicates(list));
    }

    public static ListNode deleteDuplicates(ListNode head){
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        pointer.next = head;
        while (head != null) {
            if (pointer.val == head.val) {
                pointer.next = head.next.next;
            }
            pointer = pointer.next;
            head = head.next;
        }
        return result.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
