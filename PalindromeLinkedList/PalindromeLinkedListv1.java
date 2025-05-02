package PalindromeLinkedList;

import java.util.*;
import srccode.*;

public class PalindromeLinkedListv1 {
    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 2, 1});
        System.out.print("Input: ");
        ListNode.printList(head);
        System.out.println("Output: " + isPalindrome(head));
        
        ListNode h = ListNode.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Input: ");
        ListNode.printList(h);
        System.out.println("Output: " + isPalindrome(h));
    }   
    
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){return true;}
        ArrayList<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        // Convert ArrayList to array for easier access
        int[] listArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listArray[i] = list.get(i);
        }
        int left = 0, right = listArray.length - 1;
        while (left < right) {
            if (listArray[left] != listArray[right]) {return false;}
            left++;
            right--;
        }
        return true;
    }
}
