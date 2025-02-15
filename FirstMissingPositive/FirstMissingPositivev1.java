package FirstMissingPositive;

import java.util.*;

public class FirstMissingPositivev1 {
    public static void main(String[] args) {
        System.out.println(FirstMissingPositiveNum(new int[] {1,2,0}));
        System.out.println(FirstMissingPositiveNum(new int[] {3,4,-1,1}));
        System.out.println(FirstMissingPositiveNum(new int[] {7,8,9,11,12}));
        System.out.println(FirstMissingPositiveNum(new int[] {-1,-2,-60,40,43}));
    }

    public static int FirstMissingPositiveNum(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {continue;}
            if (nums[i] > 1 && i == 0) {break;}
            if (i == nums.length - 1) {return nums[i] + 1;}
            if (nums[i] + 1 != nums[i + 1]) {return nums[i] + 1;}
        }
        return 1;
    }
}
