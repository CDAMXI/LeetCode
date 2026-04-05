import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumsInArrayv3 {
    public static void main(String[] args) {
        System.out.println("The missing numbers in [1,1] are: " + findDisappearedNumbers(new int[]{1, 1})); // [2]
        System.out.println("The missing numbers in [4,3,2,7,8,2,3,1] are: " + findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // [5, 6]
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        // Step 1: mark the present numbers using the original array
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Substract 1 because the numbers are from 1 to n
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Put numbers as negative
            }
        }

        // Step 2: Collect unmarked indices (missing numbers)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1); // Adding 1 to get the actual number
            }
        }

        return missingNumbers;
    }
}
