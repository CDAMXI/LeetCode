import java.util.*;

public class FindAllMissingNumsInArrayv2 {
    public static void main(String[] args) {
        System.out.println("The missing numbers in [1,1] are: " + findDisappearedNumbers(new int[]{1, 1})); // Should return [2]
        System.out.println("The missing numbers in [4,3,2,7,8,2,3,1] are: " + findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // Should return [5, 6]
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> missingNumbers = new ArrayList<>();
        int n = nums.length;

        // Check if 1 is missing
        if (nums[0] != 1) {
            for (int num = 1; num < nums[0]; num++) {
                missingNumbers.add(num);
            }
        }

        // Check if there are gaps between elements
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                for (int num = nums[i - 1] + 1; num < nums[i]; num++) {
                    missingNumbers.add(num);
                }
            }
        }

        // Check if the last number (n) is missing
        if (nums[n - 1] != n) {
            for (int num = nums[n - 1] + 1; num <= n; num++) {
                missingNumbers.add(num);
            }
        }

        return missingNumbers;
    }
}
