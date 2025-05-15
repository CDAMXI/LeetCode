package SearchInRotatedSortedArray;

import java.util.stream.*;

public class SearchInRotatedSortedArrayv1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));  // Expected Output: 4
    }
    
    public static int search(int[] nums, int target){
        boolean targetFound = IntStream.of(nums).anyMatch(n -> n == target);
        if(!targetFound){return -1;}
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
