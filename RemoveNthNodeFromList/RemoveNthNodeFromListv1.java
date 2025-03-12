package RemoveNthNodeFromList;

public class RemoveNthNodeFromListv1 {
    public static void main(String[] args) {
        printListNode(removeNthFromEnd(arrayToListNode(new int[]{1,2,3,4,5}), 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null || n == 0) {return head;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        int pos = getLength(head) - n;
        while (head != null) {
            if (pos >= n) {
                pointer = pointer.next;
            }
            head = head.next;
            pos++;
        }

        return pointer.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static ListNode arrayToListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        // Crear el primer nodo (head)
        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        // Recorrer el array y crear nodos para cada elemento
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
