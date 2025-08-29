package NextPermutation;

public class NextPermutationv2 {
    public static void main(String[] args) {
        int[] result = nextPermutation(new int[]{1, 2, 3});
        for (int x : result) System.out.print(x + " "); // Expected: 1 3 2
    }

    /**
     * Transform nums into the next lexicographical permutation in-place.
     * If it's already the highest, transform it into the lowest (sorted ascending).
     * Time: O(n), Space: O(1)
     */
    public static int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){return nums;}

        // 1) Find the pivot: rightmost i with nums[i] < nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){i--;}

        if (i >= 0) {
            // 2) Find rightmost successor > nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]){j--;}
            // 3) Swap pivot and successor
            swap(nums, i, j);
        }

        // 4) Reverse the suffix to make it the smallest possible
        reverse(nums, i + 1, nums.length - 1);
        return nums;
    }

    /** In-place reverse of nums[l..r]. */
    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    /** Swap helper. */
    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
