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
        long bucketSize = (long) valueDiff + 1; // Tamaño de cada bucket

        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId(nums[i], bucketSize);

            // Si el bucket actual ya tiene un número con diferencia ≤ valueDiff
            if (buckets.containsKey(bucketId)) {
                return true;
            }

            // Revisar buckets vecinos (izquierda y derecha) comparando valores
            if (buckets.containsKey(bucketId - 1) && Math.abs((long) nums[i] - buckets.get(bucketId - 1)) <= valueDiff) {
                return true;
            }
            if (buckets.containsKey(bucketId + 1) && Math.abs((long) nums[i] - buckets.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Agregar el número actual en su bucket correspondiente
            buckets.put(bucketId, nums[i]);

            // Mantener solo indexDiff elementos en memoria
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
