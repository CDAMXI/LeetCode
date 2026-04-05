package MissingNumber;

public class MissingNumbev3 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));  // Output: 2
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // Sum from 0 to n
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum; // Missing Number
    }
}
