package MaximumSubarray;

import java.util.*;

public class MaximumSubarrayv1 {
    public static void main(String[] args) {
        System.out.println("For the array [1, -2, 3, 4, -1, 2], the maximum subarray sum is: " + maxSubArray(new int[]{1, -2, 3, 4, -1, 2}));
        System.out.println("For the array [-2, -3, -1], the maximum subarray sum is: " + maxSubArray(new int[]{-2, -3, -1}));
    }

    public static int maxSubArray(int[] nums){
        if(nums.length == 0 || nums.equals(null)){return 0;}
        else if(nums.length == 1){return nums[0];}
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                sum += nums[i];
            }
        }
        return sum;
    }
}
