package MissingNumber;

import java.util.Arrays;

public class MissingNumberv2 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));  // Output: 2
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
