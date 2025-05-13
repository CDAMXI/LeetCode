package AddTwoNumbers;

import _srccode.*;

public class AddTwoNumbersv2 {
    public static void main(String[] args) {
        // Create first ListNode with values [2, 4, 3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second ListNode with values [5, 6, 4]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Print the sum result
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("Result of adding the two numbers (read left to right):");
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);  // Node dummy for the start of the list
        ListNode current = result;  // Pointer to build the result list
        int carry = 0;  // Variable for the sum carry

        // Go through both lists while there are nodes to add
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry from the previous operation

            if (l1 != null) {
                sum += l1.val;  // Add the value of l1 if it exists
                l1 = l1.next;  // Move to the next node of l1
            }

            if (l2 != null) {
                sum += l2.val;  // Add the value of l2 if it exists
                l2 = l2.next;  // Move to the next node of l2
            }

            carry = sum / 10;  // Calculating the carry
            current.next = new ListNode(sum % 10);  // Create the new node with the sum value
            current = current.next;  // Move pointer to the new node
        }

        return result.next;  // The dummy node is not part of the result, so we return the next node
    }

    // Method to print the resulting list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
