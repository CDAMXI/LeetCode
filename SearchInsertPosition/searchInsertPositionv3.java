package SearchInsertPosition;

public class searchInsertPositionv3 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5)); // Output: 2
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2)); // Output: 1
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7)); // Output: 4
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0)); // Output: 0
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        
        // Only keep searching while left < right
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;  // Reject the left half
            } else {
                right = mid;  // Rejected the right half
            }
        }

        // The index of 'left' is the insertion position
        return left;
    }
}
