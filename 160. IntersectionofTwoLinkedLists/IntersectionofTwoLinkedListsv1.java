package IntersectionofTwoLinkedLists;


public class IntersectionofTwoLinkedListsv1{
    public static void main(String[] args) {
        ListNode common = ListNode.buildList(new int[]{8,4,5});

        // Lista A: 4 -> 1 -> [8 -> 4 -> 5]
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // Lista B: 5 -> 6 -> 1 -> [8 -> 4 -> 5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // Ahora sí hay intersección en el nodo 8
        System.out.println(getIntersectionNode(headA, headB).val); // imprime 8
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){return null;}
        int lengthA = 0, lengthB = 0;

        for(ListNode curr = headA; curr != null; curr = curr.next){lengthA++;}
        for(ListNode curr = headB; curr != null; curr = curr.next){lengthB++;}

        int diff = Math.abs(lengthA - lengthB);

        if(diff != 0){
            if(lengthA > lengthB){while(diff-- > 0){headA = headA.next;}}
            else {while(diff-- > 0){headB = headB.next;}}
        }

        while(headA != null && headB != null){
            if(headA == headB){return headA;}
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
