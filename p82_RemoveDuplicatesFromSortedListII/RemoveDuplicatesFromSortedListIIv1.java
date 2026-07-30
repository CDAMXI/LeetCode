public class RemoveDuplicatesFromSortedListIIv1{
    public static void main(String[] args){
        ListNode head1 = ListNode.buildList(new int[]{1,2,3,3,4,4,5});
        System.out.print("For: \"[1,2,3,3,4,4,5]\" the output is: ");
        ListNode.printList(deleteDuplicates(head1));

        ListNode head2 = ListNode.buildList(new int[]{1,1,1,2,3});
        System.out.print("For: \"[1,1,1,2,3]\" the output is: ");
        ListNode.printList(deleteDuplicates(head2));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int val = current.val;
                while (current != null && current.val == val) {
                    current = current.next;
                }
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}
