package FirstMissingPositive;
public class FirstMissingPositivev2 {
    public static void main(String[] args) {
        System.out.println(FirstMissingPositiveNum(new int[] {1, 2, 0}));         // Output: 3
        System.out.println(FirstMissingPositiveNum(new int[] {3, 4, -1, 1}));     // Output: 2
        System.out.println(FirstMissingPositiveNum(new int[] {7, 8, 9, 11, 12})); // Output: 1
        System.out.println(FirstMissingPositiveNum(new int[] {-1, -2, -60, 40, 43})); // Output: 1
    }

    public static int FirstMissingPositiveNum(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position (nums[i] -> nums[nums[i]-1])
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Find the first index where the number is incorrect
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers are correct, the first missing positive number is n + 1
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// Time Complexity: O(n) where n is the length of the input array nums
// Space Complexity: O(1)
