package RotateList;

public class RotateListv1 {
    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.buildList(new int[]{1,2,3,4,5}), 2));
    }

    public static ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0) return head;
        int[] arr = ListNode.buildArray(head);
        int[] rotatedArr = new int[arr.length];
        while(k-- > 0){
            for(int i = 0; i < arr.length; i++){
                rotatedArr[(i + 1) % arr.length] = arr[i];
            }
            arr = rotatedArr.clone();
        }
        return ListNode.buildList(rotatedArr);
    }
}
