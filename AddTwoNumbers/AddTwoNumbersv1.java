package AddTwoNumbers;

public class AddTwoNumbersv1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        int v1 = 0, v2 = 0;
        while (l1 != null) {
            v1 = v1 * 10 + l1.val;
            l1 = l1.next;
        }

        while (l2 != null) {
            v2 = v1 * 10 + l2.val;
            l2 = l2.next;
        }

        v1 = reverse(v1);
        v2 = reverse(v2);

        int r = v1 + v2;

        while(r >= 0){
            result.val = r % 10;
            r /=10;
            result = result.next;
        }

        return result;
    }

    public static int reverse(int x) {
        boolean isNegative = (x < 0);
        x = Math.abs(x);
        
        int reverse = 0;
        while (x != 0) {
            // Comprobar si el siguiente paso causará un desbordamiento
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0;  // Devuelve 0 si hay un desbordamiento
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && x % 10 > 7)) {
                return 0;  // Devuelve 0 si hay un desbordamiento
            }
            
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        return isNegative ? -reverse : reverse;
    }
}
