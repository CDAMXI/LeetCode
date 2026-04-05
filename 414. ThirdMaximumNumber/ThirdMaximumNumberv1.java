package ThirdMaximumNumber;

import java.util.*;

public class ThirdMaximumNumberv1 {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1})); // 1
        System.out.println(thirdMax(new int[]{1, 2})); // 2
        System.out.println(thirdMax(new int[]{2,2,3,1})); //1
    }

    public static int thirdMax(int[] nums){
        Arrays.sort(nums);
        if (nums.length < 3) {return nums[nums.length - 1];}
        return nums[nums.length - 3];
    }
}
