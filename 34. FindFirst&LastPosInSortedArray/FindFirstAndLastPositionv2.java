import java.util.Arrays;

public class FindFirstAndLastPositionv2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    // Helper to find either first or last occurrence
    private static int findBound(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    high = mid - 1; // keep searching to the left
                } else {
                    low = mid + 1; // keep searching to the right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
