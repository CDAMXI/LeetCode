package SearchInsertPosition;

public class searchInsertPositionv2 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5)); // Output: 2
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2)); // Output: 1
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7)); // Output: 4
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow when calculating the middle

            if (nums[mid] == target) {
                return mid; // Element found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If not found, `left` will be the insertion position
        return left;
    }
}
