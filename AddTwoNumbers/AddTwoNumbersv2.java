package AddTwoNumbers;

public class AddTwoNumbersv2 {
    public static void main(String[] args) {
        // Crear el primer ListNode con los valores [2, 4, 3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Crear el segundo ListNode con los valores [5, 6, 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Imprimir el resultado de la suma
        ListNode result = addTwoNumbers(l1, l2);
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);  // Nodo dummy para el inicio de la lista
        ListNode current = result;  // Puntero para construir la lista de resultados
        int carry = 0;  // Variable para el acarreo de la suma

        // Recorrer ambas listas mientras haya nodos por sumar
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Empezamos con el acarreo de la operación anterior

            if (l1 != null) {
                sum += l1.val;  // Sumar el valor de l1 si existe
                l1 = l1.next;  // Mover al siguiente nodo de l1
            }

            if (l2 != null) {
                sum += l2.val;  // Sumar el valor de l2 si existe
                l2 = l2.next;  // Mover al siguiente nodo de l2
            }

            carry = sum / 10;  // Calcular el acarreo
            current.next = new ListNode(sum % 10);  // Crear el nuevo nodo con el valor de la suma
            current = current.next;  // Mover el puntero actual al nuevo nodo
        }

        return result.next;  // El nodo dummy no es parte del resultado, así que retornamos el siguiente nodo
    }

    // Método para imprimir la lista resultante
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
