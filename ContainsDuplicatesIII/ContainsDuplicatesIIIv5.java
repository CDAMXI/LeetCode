import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesIIIv5 {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Integer> buckets = new HashMap<>();
        long bucketSize = (long) valueDiff + 1; // Size of each Bucket

        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId(nums[i], bucketSize);

            // If the current bucket already has a number with difference ≤ valueDiff
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Check neighboring buckets (left and right) comparing values
            if (buckets.containsKey(bucketId - 1) && Math.abs((long) nums[i] - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(bucketId + 1) && Math.abs((long) nums[i] - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Add the current number to its corresponding bucket
            buckets.put(bucketId, nums[i]);

            // Maintain only indexDiff elements in memory
            if (i >= indexDiff) {
                buckets.remove(getBucketId(nums[i - indexDiff], bucketSize));
            }
        }
        return false;
    }

    private static long getBucketId(long num, long bucketSize) {
        return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(min(n, k))
