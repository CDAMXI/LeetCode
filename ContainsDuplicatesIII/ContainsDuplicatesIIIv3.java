import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesIIIv3 {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff < 0 || valueDiff < 0) {
            return false;
        }

        // Bucket size
        long bucketSize = (long) valueDiff + 1;

        // Map to store buckets and their corresponding values
        Map<Long, Long> bucketMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove the bucket that is out of the window
            if (i > indexDiff) {
                long outOfWindowBucket = getBucket(nums[i - indexDiff - 1], bucketSize);
                bucketMap.remove(outOfWindowBucket);
            }

            // Get the bucket for the current number
            long currentBucket = getBucket(nums[i], bucketSize);

            // Check if the current bucket already has a number
            if (bucketMap.containsKey(currentBucket)) {
                return true;
            }

            // Check the previous bucket
            if (bucketMap.containsKey(currentBucket - 1) && 
                Math.abs(nums[i] - bucketMap.get(currentBucket - 1)) <= valueDiff) {
                return true;
            }

            // Check the next bucket
            if (bucketMap.containsKey(currentBucket + 1) && 
                Math.abs(nums[i] - bucketMap.get(currentBucket + 1)) <= valueDiff) {
                return true;
            }

            // Add the current number to its bucket
            bucketMap.put(currentBucket, (long) nums[i]);
        }
        return false;
    }

    // Helper function to get the bucket for a given number
    private static long getBucket(long num, long bucketSize) {
        // For negative numbers, adjust the bucket calculation
        return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
    }
}
