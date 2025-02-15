public class ReverseLinkedListv1{
    public static void main(String[] args) {
        ListNode head = createListNode(new int[] {1, 2, 3, 4, 5, 6 ,7});
        printList(reverseList(head));
        head = createListNode(new int[] {1, 2, 3, 4, 5, 6});
        printList(reverseList(head));
        head = createListNode(new int[] {1, 2, 3, 4, 5});
        printList(reverseList(head));
        head = createListNode(new int[] {1, 2, 3, 4});
        printList(reverseList(head));
        head = createListNode(new int[] {1, 2, 3});
        printList(reverseList(head));
        head = createListNode(new int[] {1, 2});
        printList(reverseList(head));
        head = createListNode(new int[] {1});
        printList(reverseList(head));
        head = createListNode(new int[] {});
        printList(reverseList(head));
    }

    public static ListNode createListNode(int[] values) {
        if (values == null || values.length == 0){return null;}

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){return head;}
        int firstValue = head.val;
        ListNode result = new ListNode(0);
        while(head.next != null){
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = result.next;
            result.next = temp;
        }appendToEnd(result, firstValue);

        return result.next;
    }
    
    // Método para añadir un valor al final de un ListNode
    public static void appendToEnd(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        
        while (head.next != null) { // Recorrer hasta el último nodo
            head = head.next;
        }
    
        head.next = newNode; // Enlazar el nuevo nodo al final
    }
}
