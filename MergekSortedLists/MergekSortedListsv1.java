import _srccode.*;

public class MergekSortedListsv1 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Combine the linked lists
        ListNode[] lists = {list1, list2, list3};
        ListNode mergedList = mergeKLists(lists);

        // Print the merged list
        printList(mergedList);
    }

    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length <= 0) { return null; }
        ListNode result = lists[0];
        for(int i = 1; i < lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode result = new ListNode(0);  // Dummy node
        ListNode pointer = result;
    
        // Merge the lists by reusing the existing nodes
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
    
        // Directly connect the remaining non-empty list
        pointer.next = (list1 != null) ? list1 : list2;
    
        return result.next;  // Skip the dummy node
    }    

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
