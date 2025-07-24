package MaximumSubarray;

public class MaximumSubarrayv2 {
    public static void main(String[] args) {
        System.out.println("For the array [1, -2, 3, 4, -1, 2], the maximum subarray sum is: " + maxSubArray(new int[]{1, -2, 3, 4, -1, 2}));
        System.out.println("For the array [-2, -3, -1], the maximum subarray sum is: " + maxSubArray(new int[]{-2, -3, -1}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxCurrent = nums[0], maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }
}
