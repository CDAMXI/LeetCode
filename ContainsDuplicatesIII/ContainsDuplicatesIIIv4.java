import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesIIIv4 {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long) valueDiff + 1; // Size of each bucket

        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId(nums[i], bucketSize);

            // If bucket already hsa a number, it means that the difference is <= valueDiff
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Checks neighbors buckets (left and right)
            if (buckets.containsKey(bucketId - 1) && Math.abs(nums[i] - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(bucketId + 1) && Math.abs(nums[i] - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Add the element to the bucket
            buckets.put(bucketId, (long) nums[i]);

            // Maintain only indexDiff elements in memory
            if (i >= indexDiff) {
                long oldBucketId = getBucketId(nums[i - indexDiff], bucketSize);
                buckets.remove(oldBucketId);
            }
        }
        return false;
    }

    private static long getBucketId(long num, long bucketSize) {
        return num < 0 ? (num + 1) / bucketSize - 1 : num / bucketSize;
    }
}
