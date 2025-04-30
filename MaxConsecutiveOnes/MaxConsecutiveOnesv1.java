public class MaxConsecutiveOnesv1{
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1})); // Example usage
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1})); // Example usage
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0, 0, 0})); // Example usage
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0; // Variable to keep track of the maximum count of consecutive 1s
        int currentCount = 0; // Variable to keep track of the current count of consecutive 1s

        for (int num : nums) { // Iterate through each number in the array
            if (num == 1) { // If the number is 1
                currentCount++; // Increment the current count
            } else { // If the number is not 1
                maxCount = Math.max(maxCount, currentCount); // Update maxCount if currentCount is greater
                currentCount = 0; // Reset currentCount to 0
            }
        }

        return Math.max(maxCount, currentCount); // Return the maximum of maxCount and currentCount   
    }
}
