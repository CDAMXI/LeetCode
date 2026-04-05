import java.util.TreeSet;

public class ContainsDuplicatesIIIv2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0)); // true
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3)); // false
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length == 0 || indexDiff < 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Maintain a window of size indexDiff
            if (i > indexDiff) {
                set.remove((long) nums[i - indexDiff - 1]);
            }

            // Search for the closest element in the TreeSet
            long num = nums[i];
            Long floor = set.floor(num + valueDiff);
            Long ceiling = set.ceiling(num - valueDiff);

            // Verify if there is an element that meets the condition
            if ((floor != null && floor >= num - valueDiff) || 
                (ceiling != null && ceiling <= num + valueDiff)) {
                return true;
            }

            // TreeSet Add the current element to the TreeSet
            set.add((long) num);
        }
        return false;
    }
}
