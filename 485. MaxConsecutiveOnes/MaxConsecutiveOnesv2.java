public class MaxConsecutiveOnesv2{
    public static void main(String[] args){
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1})); // Example usage
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1})); // Example usage
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0, 0, 0})); // Example usage
    }

    public static int findMaxConsecutiveOnes(int[] nums){
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
            }
        }

        return currentCount > maxCount ? currentCount : maxCount;
    }
}
