import _srccode.*;

public class MergeTwoListsv1 {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        printList(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val) {
                pointer.next = new ListNode(list1.val);
                list1 = list1.next;
            } else{
                pointer.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        if (list1 != null) {
            pointer.next = list1;
        }

        if (list2 != null) {
            pointer.next = list2;
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
