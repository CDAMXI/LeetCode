// Define ListNde class if not already defined elsewhere
class ListNde {
    int val;
    ListNde next;
    ListNde(int val) { this.val = val; }
}

public class AddTwoNumbersv2 {
    public static void main(String[] args) {
        // Create first ListNde with values [2, 4, 3]
        ListNde l1 = new ListNde(2);
        l1.next = new ListNde(4);
        l1.next.next = new ListNde(3);

        // Create second ListNde with values [5, 6, 4]
        ListNde l2 = new ListNde(5);
        l2.next = new ListNde(6);
        l2.next.next = new ListNde(4);

        // Print the sum result
        ListNde result = addTwoNumbers(l1, l2);
        System.out.println("Result of adding the two numbers (read left to right):");
        printList(result);
    }

    public static ListNde addTwoNumbers(ListNde l1, ListNde l2) {
        ListNde result = new ListNde(0);  // Node dummy for the start of the list
        ListNde current = result;  // Pointer to build the result list
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
            current.next = new ListNde(sum % 10);  // Create the new node with the sum value
            current = current.next;  // Move pointer to the new node
        }

        return result.next;  // The dummy node is not part of the result, so we return the next node
    }

    // Method to print the resulting list
    public static void printList(ListNde node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
