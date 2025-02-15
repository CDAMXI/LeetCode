public class MergeTwoListsv2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        printList(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);  // Nodo dummy
        ListNode pointer = result;
    
        // Fusionar las listas reutilizando los nodos existentes
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
    
        // Conectar directamente el resto de la lista no vacía
        pointer.next = (list1 != null) ? list1 : list2;
    
        return result.next;  // Saltar el nodo dummy
    }    

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
